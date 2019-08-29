package mymain.multicast;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UDP_Multicast_Chat extends JFrame {

	JTextArea jta_display;// 출력창

	JTextField jtf_ip_address;// IP 주소
	JTextField jtf_message; // 메시지

	JList<String> jlist_group_list;
	List<String> group_list = new ArrayList<String>();// 저장객체

	Font font = new Font("굴림체", Font.BOLD, 22);

	String nick_name = "t";

	// UDP소켓
	MulticastSocket socket;

	public UDP_Multicast_Chat() {
		// TODO Auto-generated constructor stub
		super("Multicast Chat");// JFrame("타이틀") call

		// 출력창초기화
		init_display();

		// 입력창초기화
		init_input();

		// 가입그룹목록창 초기화
		init_group_list();

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

	private void init_group_list() {
		// TODO Auto-generated method stub
		jlist_group_list = new JList<String>();

		jlist_group_list.setPreferredSize(new Dimension(160, 0));
		jlist_group_list.setFont(font);
		this.add(jlist_group_list, BorderLayout.EAST);

		// JList값 넣는 방법
		// String [] group_array = {"224.0.0.1","224.0.0.2","224.0.0.3"};
		// jlist_group_list.setListData(group_array);

	}

	private void init_socket() {
		// TODO Auto-generated method stub

		try {
			socket = new MulticastSocket(6000);

			// 데이터 수신
			my_read_message();

		} catch (Exception e) {
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
		JPanel p = new JPanel(new GridLayout(3, 1));
		// 주소창
		jtf_ip_address = new JTextField("224.0.0.1");

		// 버튼2개
		JPanel p1 = new JPanel(new GridLayout(1, 2));
		JButton jbt_join = new JButton("가입");
		JButton jbt_leave = new JButton("탈퇴");
		p1.add(jbt_join);
		p1.add(jbt_leave);

		// 메시지창
		jtf_message = new JTextField();

		p.add(jtf_ip_address);
		p.add(p1);
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

		// 버튼이벤트
		jbt_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				my_join_group();
			}
		});

		jbt_leave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				my_leave_group();
			}
		});

	}

	protected void my_leave_group() {
		// TODO Auto-generated method stub
		// 가입되어있는지 확인
		int result = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
		// (내용, 제목, 버튼 )
		System.out.println(result); // 버튼 값 확인 (3개임 0,1,-1)
		
		String ip = jtf_ip_address.getText();

		if (result != JOptionPane.YES_NO_OPTION)
			return;

		// 유효성
		if (group_list.contains(ip)) {

			try {
				
				//System.out.println(ip);
				
				InetAddress ia = InetAddress.getByName(ip);
				// 그룹등록
				socket.leaveGroup(ia);

				// ArrayList추가
				group_list.remove(ip);
				// JList에 추가
				// ArrayList -> Array추출
				String[] group_array = new String[group_list.size()];
				group_list.toArray(group_array);
				jlist_group_list.setListData(group_array);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
		JOptionPane.showMessageDialog(this, "가입되어있지 않은 주소입니다");
		return;
		}



	}

	protected void my_join_group() {
		// TODO Auto-generated method stub
		
		
		// 가입할 주소 얻어오기
		String ip = jtf_ip_address.getText();

		if (group_list.contains(ip)) {

			JOptionPane.showMessageDialog(this, "이미 가입된 주소입니다");
			return;
		}

		try {
			
			//System.out.println(ip);
			
			InetAddress ia = InetAddress.getByName(ip);
			// 그룹등록
			socket.joinGroup(ia);

			// ArrayList추가
			group_list.add(ip);
			// JList에 추가
			// ArrayList -> Array추출
			String[] group_array = new String[group_list.size()];
			group_list.toArray(group_array);
			jlist_group_list.setListData(group_array);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

			// 목적지 주소
			// broadcast주소
			// local_broadcast : 172.16.7.255
			// global_broadcast : 255.255.255.255
			String ip_address = jtf_ip_address.getText();
			InetAddress ia = InetAddress.getByName(ip_address);

			// 전송데이터 포장 : send_data = "홍길동#안녕하세요";
			String send_data = String.format("%s(%s)#%s", nick_name, ip_address, message);

			// 데이터 + 주소포장
			byte[] send_bytes = send_data.getBytes();// String->byte []
			DatagramPacket dp = new DatagramPacket(send_bytes, send_bytes.length, ia, 6000); // 포트 변경했으므로 같이 변경
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
		new UDP_Multicast_Chat();
	}
}
