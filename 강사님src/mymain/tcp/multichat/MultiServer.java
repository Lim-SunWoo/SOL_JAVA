package mymain.tcp.multichat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	JTextArea jta_display;        //�޽ý� �����
	JList<String> jlist_user_list;//�����ڸ��
	JTextField jtf_user_count;    //�����ڼ�
	
	Font font = new Font("�޸տ�����",Font.BOLD,20);
	
	//��������
	ServerSocket server;
	
	//�ڼ��������� ��������� ��ü
	List<ReadThread> socketList = new ArrayList<ReadThread>();
	
	//������ ����Ʈ ��������� ��ü
	List<String>  userList = new ArrayList<String>();
	
	//������ ����ȭ ������ü
	Object syncObj = new Object();
	
	
	
	public MultiServer() {
		// TODO Auto-generated constructor stub
		super("��Ƽä�ü���");// JFrame("Ÿ��Ʋ") call

		init_display();  //Center
		
		init_user_list();//East
		
		init_user_count();//South
		
		//�����ʱ�ȭ
		init_server();
		
		
		//��ġ
		setLocation(400, 200);
		//ũ��
		//setSize(300, 300);
		pack();

		//�������
		setVisible(true);

		//����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_server() {
		// TODO Auto-generated method stub
		
		try {
			server = new ServerSocket(8000);
			
			//���Ӵ�� ������ ����
			new Thread() {
				public void run() {
					while(true) {
					
						try {
							//���Ӵ��
							Socket child = server.accept();
							
							ReadThread rt = new ReadThread(child);
							socketList.add(rt);
							
							rt.start();//������ ����
							
							//�����ڼ� ���
							my_display_user_count();
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}.start();
			
			jta_display.append("--���� ������...--\r\n");
			
			
			
			
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
		
		JLabel jlb1 = new JLabel("�����ڼ�:", JLabel.RIGHT);
		jtf_user_count = new JTextField("0");
		JLabel jlb2 = new JLabel("(��)");
		
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
		
		//�б�����
		jta_display.setEditable(false);
		
		jta_display.setFont(font);
		
		//jta_display.append("--���������--\r\n");
		
		
	}

//---���ſ� ������(Inner class)	
	class ReadThread  extends Thread{
		
		Socket child;
		
		BufferedReader br = null;
		
		public ReadThread() {
			// TODO Auto-generated constructor stub
		}
		
		public ReadThread(Socket child) {
			super();
			this.child = child;
			
			try {
				// InputStream->InputStreamReader->BufferdReader
				InputStreamReader isr = new InputStreamReader(child.getInputStream());
				br = new BufferedReader(isr);
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
					//������ ����
					String readStr = br.readLine();//1�ٴ����� �о����
					if(readStr==null) {
						//System.out.println("--��������--");
						break;//��������
					}
					
					//���� �����
					my_display_message(readStr);
					
					//������ �и�
					String [] msg_array = readStr.split("#");
					//readStr   = "IN#ȫ�浿"
					//              0      1 
					//msg_array = {"IN","ȫ�浿"};
					if(msg_array[0].equals("IN")) {//�����̸�
						
						synchronized (syncObj) {
							
							userList.add(msg_array[1]);
							
							//������ ��� �ֱ�
							my_display_user_list();
							
							//���������ڸ�� Ŭ���̾����� ����
							my_send_user_list();
							
							//��������ڿ��� ����޽��� ����
							my_send_message_all(readStr+"\n");
							
						}
					}else if(msg_array[0].equals("MSG")) {
						
						synchronized (syncObj) 
						{
							//readStr = "MSG#�浿#���� ��������?"
							String [] bad_array = {
									"����","���۳�","��","����"};
							
							for(String bad : bad_array) {
								readStr = readStr.replaceAll(bad, "***");
							}
							//��������ڿ��� ����޽��� ����
							my_send_message_all(readStr+"\n");
						}
						
					}else if(msg_array[0].equals("DRAW")) {
						synchronized (syncObj) 
						{
							//��������ڿ��� ����޽��� ����
							my_send_message_all(readStr+"\n");
						}
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					//System.out.println("--����������--");
					break;//����������
				}
			}//end-while
			
			
			synchronized (syncObj) {
				//�����Ȳ
				//������ index���ϱ�
				int del_index = socketList.indexOf(this);
				
				//������ ������ �̸�
				String del_nick_name = userList.get(del_index);
				
				//��������
				userList.remove(del_index);
				
				socketList.remove(this);
				
				//�����ڼ� ���
				my_display_user_count();
				
				//�����ڸ�� ����
				my_display_user_list();
				
				//���������ڸ�� Ŭ���̾����� ����
				my_send_user_list();
				
				//�������� ����
				String send_data = String.format("OUT#%s\n", del_nick_name);
				my_send_message_all(send_data);
				
			
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
		// user_list = "LIST#�浿1#�浿2#�浿3#\n"
    	StringBuffer sb = new StringBuffer("LIST#");
    	for(String nick_name : userList) {
    		sb.append(nick_name);
    		sb.append("#");
    	}
    	sb.append("\n");
    	
    	
    	//StringBuffer -> String
    	String user_list = sb.toString();
    	
    	//���� ������ ��� Ŭ���̾�Ʈ���� ����
    	my_send_message_all(user_list) ;
    			
    	
	}

    // IN#\n
    
	private void my_send_message_all(String message) {
		// TODO Auto-generated method stub
		//synchronized (syncObj) {
			//for(ReadThread rt : socketList) {
		    for(int i=0;i<socketList.size();i++) {
		    	ReadThread rt = socketList.get(i);
				try {
					rt.child.getOutputStream().write(message.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		//}
	}

	public void my_display_user_list() {
		// TODO Auto-generated method stub
    	String [] user_array = new String[userList.size()];
    	userList.toArray(user_array);//ArrayList -> Array

    	jlist_user_list.setListData(user_array);
		
	}

	//---��:���ſ� ������	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiServer();
	}
}
