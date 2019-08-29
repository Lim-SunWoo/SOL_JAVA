package mymain.broadcast;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UDPChat extends JFrame {

	JTextArea  jta_display;//���â
	
	JTextField jtf_ip_address;//IP �ּ�
	JTextField jtf_message;   //�޽���
	
	Font font = new Font("����ü", Font.BOLD, 22);
	
	String nick_name = "ȫ�浿";
	
	//UDP����
	DatagramSocket socket;
	
	public UDPChat() {
		// TODO Auto-generated constructor stub
		super("BroadCast Chat");// JFrame("Ÿ��Ʋ") call

		//���â�ʱ�ȭ
		init_display();
		
		//�Է�â�ʱ�ȭ
		init_input();
		
		//�����ʱ�ȭ
		init_socket();
		
		
		
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

	private void init_socket() {
		// TODO Auto-generated method stub
		
		try {
			socket = new DatagramSocket(5000);
			
			//������ ����
			my_read_message();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void my_read_message() {
		// TODO Auto-generated method stub
		//���ſ� ������ ����
		
		/*
		class MyThread extends Thread{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}*/
		
		
		Thread t = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//String name = Thread.currentThread().getName();
				//System.out.printf("[%s] Thread ���Ŵ��\n",name);
				
				//������ ����
				while(true) {
					
					try {
						byte [] buff = new byte[512];
						DatagramPacket dp = new DatagramPacket(buff, buff.length);
						socket.receive(dp);
						
						//�۽��� �ּ�
						InetAddress ia = dp.getAddress();
						String ip = ia.getHostAddress();
						
						
						byte [] read_bytes = dp.getData();
						// byte [] -> String
						String read_data = new String(read_bytes,0,read_bytes.length).trim();
					
						System.out.printf("[%s] %s\n", ip,read_data);
						
						//read_data = "ȫ�浿#�ȳ��ϼ���";
						/*
						  [ȫ�浿]�� ����:
						     �ȳ��ϼ��� 
						 */
						
						String [] msg_array = read_data.split("#");
						//                          0             1 
						//String [] msg_array = {"ȫ�浿" , "�ȳ��ϼ���"};
						
						String display_message = String.format("[%s]�� ����:\r\n    %s", 
								                          msg_array[0],   msg_array[1]  
								);
						
						//ȭ�����
						my_display_message(display_message);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				
			}
		};
		t.start();
		
		
	}

	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(2, 1));
		//�ּ�â
		jtf_ip_address = new JTextField("255.255.255.255");
		//�޽���â
		jtf_message = new JTextField();
		
		p.add(jtf_ip_address);
		p.add(jtf_message);
		
		this.add(p,BorderLayout.SOUTH ); // "South"
		
		//��Ʈ����
		jtf_ip_address.setFont(font);
		jtf_message.setFont(font);
		
		//Ű�̺�Ʈ
		jtf_message.addKeyListener( new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
				if(key== KeyEvent.VK_ENTER) {
					my_send_message();
				}
			}
		} );
		
		
	}

	protected void my_send_message() {
		// TODO Auto-generated method stub
		//System.out.println("--Enter--");
		//�Էµ� �޽��� �������� + trim() <-��������
		String message = jtf_message.getText().trim();
		
		if(message.isEmpty()) {//����ֳ�?
			jtf_message.setText("");//����
			jtf_message.requestFocus();
			return;
		}
		
		try {
			//���۵����� ���� :  send_data =  "ȫ�浿#�ȳ��ϼ���";
			String send_data = String.format("%s#%s", nick_name,message);
			//������ �ּ�
			//broadcast�ּ�
			//             local_broadcast : 172.16.7.255
			//            global_broadcast : 255.255.255.255
			String ip_address = jtf_ip_address.getText();
			InetAddress ia = InetAddress.getByName(ip_address);
			
			//������ + �ּ�����
			byte [] send_bytes = send_data.getBytes();//String->byte []
			DatagramPacket dp = new DatagramPacket(send_bytes, 
					                               send_bytes.length, 
					                               ia, 
					                               5000);
			//����
			socket.send(dp);	
						
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		jtf_message.setText("");
		
		
	}

	private void my_display_message(String message) {
		// TODO Auto-generated method stub
		jta_display.append(message + "\r\n");
		
		//��ũ�� ó�� 
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);
		
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		//���뽺ũ�� ó��
		JScrollPane jsp = new JScrollPane(jta_display);
		
		jsp.setPreferredSize(new Dimension(400, 400));
		
		this.add(jsp,BorderLayout.CENTER);
		
		jta_display.setFont(font);
		
		//���â �б�����
		jta_display.setEditable(false);
		
		jta_display.append("~~����� ���â�Դϴ�~~\r\n");
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPChat();
	}
}
