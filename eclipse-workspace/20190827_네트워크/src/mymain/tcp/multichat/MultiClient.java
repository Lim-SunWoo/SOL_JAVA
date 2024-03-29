package mymain.tcp.multichat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mymain.tcp.multichat.serial.Data;

public class MultiClient extends JFrame {

	JTextArea jta_display;
	JList<String> jlist_user_list;
	JTextField jtf_message;
	JButton jbt_connect;
	boolean bConnect = false;// 연결여부

	Font font = new Font("휴먼엑스포", Font.BOLD, 20);

	// 소켓
	Socket client;
	String nick_name = "홍길동";

	// *** 직렬소켓 직렬화 처리객체
	ObjectOutputStream oos;
	ObjectInputStream ois;

	// 그림판
	JPanel grimPan;
	Image memPan;

	int thick = 5;// 선굵기
	int line_color = 0;// 선색상

	public MultiClient() {
		// TODO Auto-generated constructor stub
		super("MultiChat Client");// JFrame("타이틀") call

		init_display();// Center

		init_user_list();// East

		init_grimpan();// West

		init_input();// South

		// 위치
		setLocation(400, 200);
		// 크기
		// setSize(300, 300);
		setResizable(false);

		pack();

		// 보여줘라
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 메모리 그림판 생성
		memPan = grimPan.createImage(400, 400);

	}

	private void init_grimpan() {
		// TODO Auto-generated method stub
		// 익명 class
		grimPan = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				// Memory 화면내용 여기로 복사
				g.drawImage(memPan, 0, 0, this);
			}
		};

		grimPan.setPreferredSize(new Dimension(400, 400));

		this.add(grimPan, BorderLayout.WEST);

		// 마우스 이베트
		init_mouse_event();

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				// 연결되지 않았으면 끝내라
				if (bConnect == false)
					return;

				Point pt = e.getPoint();// 눌린위치

				// 전송데이터 포장
				String send_data = String.format("DRAW#%d#%d#%d#%d\n", pt.x, pt.y, thick, line_color);
				// 전송
				try {
					client.getOutputStream().write(send_data.getBytes());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		};

		// 마우스가 움직일때 발생되는 이벤트 처리
		grimPan.addMouseMotionListener(adapter);

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

		// 그림판 메뉴
		JPanel westP = new JPanel(new GridLayout(1, 3));
		westP.setPreferredSize(new Dimension(400, 0));

		p.add(westP, BorderLayout.WEST);

		Integer[] thick_array = { 5, 10, 15, 20, 25, 30 };
		JComboBox<Integer> jcb_thick = new JComboBox<Integer>(thick_array);
		JButton jbt_color = new JButton("선색상");
		JButton jbt_clear = new JButton("지우기");
		westP.add(jcb_thick);
		westP.add(jbt_color);
		westP.add(jbt_clear);

		// 콤포박스이벤트
		jcb_thick.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int state = e.getStateChange();// SELECTED or DESELECTED
				if (state == ItemEvent.SELECTED) {
					thick = (int) jcb_thick.getSelectedItem();
					// System.out.println(thick);
				}
			}
		});

		// 선색상 이벤트
		jbt_color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color color = new Color(line_color);
				Color sel_color = JColorChooser.showDialog(MultiClient.this, "선색상을 선택하세요", color);

				if (sel_color == null)
					return;// 취소 누르면 끝내라
				line_color = sel_color.getRGB();
			}
		});

		// 지우기
		jbt_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 메모리 그림판의 그리기 도구 구하기
				Graphics g = memPan.getGraphics();
				g.clearRect(0, 0, 400, 400);

				grimPan.repaint();// paintComponent(Graphics g) Call

			}
		});

		// 키이벤트
		jtf_message.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					my_send_message();
				}
			}

		});

		// 버튼이벤트
		jbt_connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bConnect = !bConnect;

				if (bConnect) {// 연결

					try {
						client = new Socket("172.16.7.100", 8000);

						// ***
						oos = new ObjectOutputStream(client.getOutputStream());
						ois = new ObjectInputStream(client.getInputStream());

						// ***

						// 전달객체 생성, 셋팅
						Data data = new Data();
						data.protocol = Data.IN;
						data.nick_name = nick_name;
						oos.writeObject(data); // data란 객체를 보냄. 그 안에 protocal, nickname 등이 있음.값을 안 넣음녀 빈 껍데기.
						// 다 넘어가지만 다 넘어가진 않아서 쓸모없는건 안넘어감.
						////////

						// 입장메시지 전달 : "IN#홍길동\n"
						String send_data = String.format("IN#%s\n", nick_name);
						client.getOutputStream().write(send_data.getBytes());

						// 수신
						my_read_message();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
						my_display_message("--연결실패--");
						bConnect = false;
					}

				} else {// 끊기

					try {
						// 소켓닫기
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

	protected void my_send_message() {
		// TODO Auto-generated method stub
		// 연결되지 않았으면 끝내라
		if (bConnect == false)
			return;

		String message = jtf_message.getText().trim();
		if (message.isEmpty()) {
			jtf_message.setText("");// 공백지우기
			return;
		}

		// 전송데이터 포장
		String send_data = String.format("MSG#%s#%s\n", nick_name, message);

		try {
			client.getOutputStream().write(send_data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 이전내용 지우기
		jtf_message.setText("");

	}

	protected void my_read_message() {
		// TODO Auto-generated method stub
		try {
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			// 수신Thread
			new Thread() {

				public void run() {

					while (true) {

						try {
							String readStr = br.readLine();
							if (readStr == null)
								break;

							// 수신메시지이용해서 처리..
							// System.out.println(readStr);
							// readStr = "IN#홍길동";
							// readStr = "OUT#홍길동";
							// readStr = "MSG#홍길동#잘지내";
							// readStr = "LIST#홍길동1#홍길동2#";
							// readStr = "DRAW#x#y#thick#line_color";
							String[] msg_array = readStr.split("#");
							if (msg_array[0].equals("IN")) {

								String msg = String.format("->[%s]님 입장", msg_array[1]);
								my_display_message(msg);

							} else if (msg_array[0].equals("OUT")) {

								String msg = String.format("<-[%s]님 퇴장", msg_array[1]);
								my_display_message(msg);

							} else if (msg_array[0].equals("MSG")) {

								// readStr = "MSG#홍길동#잘지내";
								String msg = String.format("[%s]님 말씀:\r\n   %s", msg_array[1], msg_array[2]);
								my_display_message(msg);

							} else if (msg_array[0].equals("LIST")) {

								my_display_user_list(readStr);

							} else if (msg_array[0].equals("DRAW")) {
								// 0 1 2 3 4
								// readStr = "DRAW#x#y#thick#line_color"
								// 0 1 2 3 4
								// msg_array = {"DRAW","30","50","15","0"};
								int x, y, thick1, line_color1;

								try {

									x = Integer.parseInt(msg_array[1]);
									y = Integer.parseInt(msg_array[2]);
									thick1 = Integer.parseInt(msg_array[3]);
									line_color1 = Integer.parseInt(msg_array[4]);

									// 메모리 그리기
									Graphics g = memPan.getGraphics();
									g.setColor(new Color(line_color1));
									g.fillOval(x - thick, y - thick, thick1 * 2, thick1 * 2);

									// 메모리->화면으로
									grimPan.repaint();

								} catch (Exception e) {
									// TODO: handle exception
									continue;
								}
							}

						} catch (IOException e) {
							// TODO Auto-generated catch block
							// e.printStackTrace();
							break;
						}

					} // end-while

					// System.out.println("--socket close--");
					// 사용자목록 지우고
					String[] user_array = new String[0];
					jlist_user_list.setListData(user_array);

					bConnect = false;
					jbt_connect.setText("연결");

				}

			}.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void my_display_user_list(String readStr) {
		// TODO Auto-generated method stub
		// readStr = "LIST#홍길동1#홍길동2#";
		readStr = readStr.replaceAll("LIST#", "");
		// readStr = "홍길동1#홍길동2#";
		jlist_user_list.setListData(readStr.split("#"));

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
		// TODO Auto-generated method stub
		new MultiClient();
	}
}
