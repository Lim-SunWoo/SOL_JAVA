package mymain.tcp.multichat.serial;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiServer extends JFrame {

	JTextArea jta_display;        //메시시 모니터
	JList<String> jlist_user_list;//접속자목록
	JTextField jtf_user_count;    //접속자수
	
	Font font = new Font("휴먼엑스포",Font.BOLD,20);
	
	//서버소켓
	ServerSocket server;
	
	//자소켓정보를 저장관리할 객체
	List<ReadThread> socketList = new ArrayList<ReadThread>();
	
	//접속자 리스트 저장관리할 객체
	List<String>  userList = new ArrayList<String>();
	
	//쓰레드 동기화 관리객체
	Object syncObj = new Object();
	
	
	
	public MultiServer() {
		// TODO Auto-generated constructor stub
		super("멀티채팅서버");// JFrame("타이틀") call

		init_display();  //Center
		
		init_user_list();//East
		
		init_user_count();//South
		
		//서버초기화
		init_server();
		
		
		//위치
		setLocation(400, 200);
		//크기
		//setSize(300, 300);
		pack();

		//보여줘라
		setVisible(true);

		//종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_server() {
		// TODO Auto-generated method stub
		
		try {
			server = new ServerSocket(8000);
			
			//접속대기 쓰레드 구동
			new Thread() {
				public void run() {
					while(true) {
					
						try {
							//접속대기
							Socket child = server.accept();
							
							ReadThread rt = new ReadThread(child);
							socketList.add(rt);
							
							rt.start();//쓰레드 구동
							
							//접속자수 출력
							my_display_user_count();
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}.start();
			
			jta_display.append("--서버 구동중...--\r\n");
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void my_display_user_count() {
		// TODO Auto-generated method stub
		jtf_user_count.setText(socketList.size()+""); 

	}

	private void init_user_count() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(1, 3));
		
		JLabel jlb1 = new JLabel("접속자수:", JLabel.RIGHT);
		jtf_user_count = new JTextField("0");
		JLabel jlb2 = new JLabel("(명)");
		
		p.add(jlb1);
		p.add(jtf_user_count);
		p.add(jlb2);
		
		this.add(p,BorderLayout.SOUTH);
		
		jlb1.setFont(font);
		jtf_user_count.setFont(font);
		jlb2.setFont(font);
		
		jtf_user_count.setHorizontalAlignment(JTextField.CENTER);
		
		
	}

	private void init_user_list() {
		// TODO Auto-generated method stub
		jlist_user_list = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_user_list);
		jsp.setPreferredSize(new Dimension(150, 0));
		
		this.add(jsp,BorderLayout.EAST);
		
		jlist_user_list.setFont(font);
		
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		
		jsp.setPreferredSize(new Dimension(400, 400));
		this.add(jsp,BorderLayout.CENTER);
		
		//읽기전용
		jta_display.setEditable(false);
		
		jta_display.setFont(font);
		
		//jta_display.append("--서버대기중--\r\n");
		
		
	}

//---수신용 쓰레드(Inner class)	
	class ReadThread  extends Thread{
		
		Socket child;
		
		ObjectInputStream ois;
		ObjectOutputStream oos;
				
		
		public ReadThread() {
			// TODO Auto-generated constructor stub
		}
		
		public ReadThread(Socket child) {
			super();
			this.child = child;
			
			try {
				//client측에서 ObjectOutputStream을 먼저 생성
				//서버측에서는 ObjectInputStream을 생성해야 한다
				ois = new ObjectInputStream(child.getInputStream());
				oos = new ObjectOutputStream(child.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				
				
				try {
					//데이터 수신
					Data data = (Data)ois.readObject();
					if(data==null) break;
					
					//서버 모니터
					//my_display_message(readStr);
					
					//데이터 분리
					if(data.protocol==Data.IN) {//입장이면
						
						synchronized (syncObj) {
							
							userList.add(data.nick_name);
							
							//접속자 목록 넣기
							my_display_user_list();
							
							//현재접속자목록 클라이언측에 전송
							my_send_user_list();
							
							//모든접속자에게 입장메시지 전달
							my_send_message_all(data);
							
						}
					}else if(data.protocol==Data.MSG) {
						
						synchronized (syncObj) 
						{
							//모든접속자에게 입장메시지 전달
							my_send_message_all(data);
						}
						
					}else if(data.protocol==Data.DRAW) {
						synchronized (syncObj) 
						{
							//모든접속자에게 입장메시지 전달
							my_send_message_all(data);
						}
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					//System.out.println("--비정상종료--");
					break;//비정상종료
				}
			}//end-while
			
			
			synchronized (syncObj) {
				//퇴장상황
				//삭제할 index구하기
				int del_index = socketList.indexOf(this);
				
				//퇴장할 유저의 이름
				String del_nick_name = userList.get(del_index);
				
				//유저삭제
				userList.remove(del_index);
				
				socketList.remove(this);
				
				//접속자수 출력
				my_display_user_count();
				
				//접속자목록 갱신
				my_display_user_list();
				
				//현재접속자목록 클라이언측에 전송
				my_send_user_list();
				
				//퇴장정보 전달
				Data data = new Data();
				data.protocol = Data.OUT;
				data.nick_name = del_nick_name;
				
				my_send_message_all(data);
				
			
			}
			
		}
		
	}
	
	protected void my_display_message(String message) {
		// TODO Auto-generated method stub
		jta_display.append(message + "\r\n");
		
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);
				
		
	}
	
	
    public void my_send_user_list() {
		// TODO Auto-generated method stub
		
    	Data data = new Data();
    	data.protocol = Data.LIST;
    	data.userList = userList;
    	
    	//현재 접속한 모든 클라이언트에게 전송
    	my_send_message_all(data) ;
    	
    			
    	
	}

    // IN#\n
    
	private void my_send_message_all(Data data) {
		// TODO Auto-generated method stub
	    for(int i=0;i<socketList.size();i++) {
	    	ReadThread rt = socketList.get(i);
			try {
				rt.oos.writeObject(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}

	}

	public void my_display_user_list() {
		// TODO Auto-generated method stub
    	String [] user_array = new String[userList.size()];
    	userList.toArray(user_array);//ArrayList -> Array

    	jlist_user_list.setListData(user_array);
		
	}

	//---끝:수신용 쓰레드	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiServer();
	}
}
