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

	JTextArea jta_display;// 출력창

	JTextField jtf_ip_address;// IP 주소
	JTextField jtf_message; // 메시지

	Font font = new Font("굴림체", Font.BOLD, 22);

	String nick_name = "t";

	// UDP소켓
	DatagramSocket socket;

	public UDPChat() {
		// TODO Auto-generated constructor stub
		super("BroadCast Chat");// JFrame("타이틀") call

		// 출력창초기화
		init_display();

		// 입력창초기화
		init_input();

		// 소켓초기화
		init_socket();

		// 위치
		setLocation(400, 200);
		// 크기
		// setSize(300, 300);
		pack();

		// 보여줘라
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_socket() {
		// TODO Auto-generated method stub

		try {
			socket = new DatagramSocket(5000);

			// 데이터 수신
			my_read_message();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void my_read_message() {
		// TODO Auto-generated method stub
		// 수신용 스레드 생성

		Thread t = new Thread() { // 추상클래스나 인터페이스 뿐만 아니라 일반 클래스도 생성과 동시에 정의가 가능함.
			public void run() {
				String name = Thread.currentThread().getName();

				// 데이터 수신
				while (true) {
					try {
						byte[] buff = new byte[512];
						DatagramPacket dp = new DatagramPacket(buff, buff.length);

						socket.receive(dp);

						// 송신자 주소
						InetAddress ia = dp.getAddress();
						String ip = ia.getHostAddress();

						byte[] read_bytes = dp.getData();
						String read_data = new String(read_bytes, 0, read_bytes.length);

						// read_data = "홍길동#안녕하세요"

						String[] msg_array = read_data.split("#");
						// String [] msg_array = {"홍길동", "안녕하세요"};

						String display_message = String.format("%s님 말씀: \r\n %s", msg_array[0], msg_array[1]);

						// 화면 출력
						my_display_message(display_message);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace(); // IOEX말고 EX하면(퉁쳐서) 프로그램이 구동중지되지 않음.
					}

				}

			}
		};
		
		t.start(); // 수신 스레드 구동
	}

	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(2, 1));
		// 주소창
		jtf_ip_address = new JTextField("255.255.255.255");
		// 메시지창
		jtf_message = new JTextField();

		p.add(jtf_ip_address);
		p.add(jtf_message);

		this.add(p, BorderLayout.SOUTH); // "South"

		// 폰트적용
		jtf_ip_address.setFont(font);
		jtf_message.setFont(font);

		// 키이벤트
		jtf_message.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					my_send_message();
				}
			}
		});

	}

	protected void my_send_message() {
		// TODO Auto-generated method stub
		// System.out.println("--Enter--");
		// 입력된 메시지 가져오기 + trim() <-공백제거
		String message = jtf_message.getText().trim();

		if (message.isEmpty()) {// 비어있냐?
			jtf_message.setText("");// 비우기
			jtf_message.requestFocus();
			return;
		}

		try {
			// 전송데이터 포장 : send_data = "홍길동#안녕하세요";
			String send_data = String.format("%s#%s", nick_name, message);
			// 목적지 주소
			// broadcast주소
			// local_broadcast : 172.16.7.255
			// global_broadcast : 255.255.255.255
			String ip_address = jtf_ip_address.getText();
			InetAddress ia = InetAddress.getByName(ip_address);

			// 데이터 + 주소포장
			byte[] send_bytes = send_data.getBytes();// String->byte []
			DatagramPacket dp = new DatagramPacket(send_bytes, send_bytes.length, ia, 5000);
			// 전송
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

		// 스크롤 처리
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);

	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		// 내용스크롤 처리
		JScrollPane jsp = new JScrollPane(jta_display);

		jsp.setPreferredSize(new Dimension(400, 400));

		this.add(jsp, BorderLayout.CENTER);

		jta_display.setFont(font);

		// 출력창 읽기전용
		jta_display.setEditable(false);

		jta_display.append("~~여기는 출력창입니다~~\r\n");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPChat();
	}
}
