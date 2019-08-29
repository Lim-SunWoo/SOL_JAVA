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
		
		ObjectInputStream ois;
		ObjectOutputStream oos;
				
		
		public ReadThread() {
			// TODO Auto-generated constructor stub
		}
		
		public ReadThread(Socket child) {
			super();
			this.child = child;
			
			try {
				//client������ ObjectOutputStream�� ���� ����
				//������������ ObjectInputStream�� �����ؾ� �Ѵ�
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
					//������ ����
					Data data = (Data)ois.readObject();
					if(data==null) break;
					
					//���� �����
					//my_display_message(readStr);
					
					//������ �и�
					if(data.protocol==Data.IN) {//�����̸�
						
						synchronized (syncObj) {
							
							userList.add(data.nick_name);
							
							//������ ��� �ֱ�
							my_display_user_list();
							
							//���������ڸ�� Ŭ���̾����� ����
							my_send_user_list();
							
							//��������ڿ��� ����޽��� ����
							my_send_message_all(data);
							
						}
					}else if(data.protocol==Data.MSG) {
						
						synchronized (syncObj) 
						{
							//��������ڿ��� ����޽��� ����
							my_send_message_all(data);
						}
						
					}else if(data.protocol==Data.DRAW) {
						synchronized (syncObj) 
						{
							//��������ڿ��� ����޽��� ����
							my_send_message_all(data);
						}
					}
					
					
				} catch (Exception e) {
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
    	
    	//���� ������ ��� Ŭ���̾�Ʈ���� ����
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

	//---��:���ſ� ������	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiServer();
	}
}
