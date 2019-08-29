package mymain.tcp.multichat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame {

	JTextArea jta_display;
	JList<String> jlist_user_list;
	JTextField jtf_message;
	JButton jbt_connect;
	boolean bConnect = false; // 연결여부

	Font font = new Font("굴림체", Font.BOLD, 20);

	// 소켓
	Socket client;
	String nick_name = "30분 남았다";

	public MultiClient() {
		super("MultiClient"); // JFrame("타이틀") 호출과 같은 기능을 함.

		init_display(); // Center

		init_user_list(); // East

		init_input(); // South

		// 위치와 사이즈
		super.setLocation(400, 200);
		// setSize(300, 300);
		pack(); // 클라이언트 크기가 유지 됨.

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_input() {
		// TODO Auto-generated method stub

		JPanel p = new JPanel(new BorderLayout());
		jtf_message = new JTextField();
		jbt_connect = new JButton("연결");

		jbt_connect.setPreferredSize(new Dimension(120, 0));

		p.add(jtf_message, BorderLayout.CENTER);
		p.add(jbt_connect, BorderLayout.EAST);

		this.add(p, BorderLayout.SOUTH);

		jtf_message.setFont(font);

		// 버튼 이벤트
		jbt_connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // 임장과 퇴장에 동기화를 걸어야함.
				// TODO Auto-generated method stub

				bConnect = !bConnect;

				if (bConnect) { // 연결
					try {
						client = new Socket("172.16.7.100", 8000);

						// 입장메세지 전달: "IN#홍길동\n"
						String send_data = String.format("IN#%s\n", nick_name);
						client.getOutputStream().write(send_data.getBytes());

						// 데이터 수신
						my_read_message();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();

						my_display_message("연결실패");
						bConnect = false;

					}

				} else { // 끊기
					try {
						client.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// 버튼 캡션변경
				jbt_connect.setText(bConnect ? "끊기" : "연결");

			}
		});

	}

	protected void my_read_message() {
		// TODO Auto-generated method stub
		try {
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			// 수신 스레드
			new Thread() {
				public void run() {
					while (true) {
						try {
							String readStr = br.readLine();
							if (readStr == null)
								break;

							System.out.println("수신메세지를 이용해서 처리");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void my_display_message(String message) {
		// TODO Auto-generated method stub
		jta_display.append(message + "\r\n");
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);

	}

	private void init_user_list() {
		// TODO Auto-generated method stub

		jlist_user_list = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_user_list);
		jsp.setPreferredSize(new Dimension(120, 0));

		this.add(jsp, BorderLayout.EAST);

		jlist_user_list.setFont(font);

	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);

		jsp.setPreferredSize(new Dimension(400, 400));
		this.add(jsp, BorderLayout.CENTER);

		// 읽기전용
		jta_display.setEditable(false);

		jta_display.setFont(font);

		// jta_display.append("--서버대기중--\r\n");

	}

	public static void main(String[] args) {
		new MultiClient();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}
}
