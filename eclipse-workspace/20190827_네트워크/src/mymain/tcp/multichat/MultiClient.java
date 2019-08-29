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
	boolean bConnect = false; // ���Ῡ��

	Font font = new Font("����ü", Font.BOLD, 20);

	// ����
	Socket client;
	String nick_name = "30�� ���Ҵ�";

	public MultiClient() {
		super("MultiClient"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		init_display(); // Center

		init_user_list(); // East

		init_input(); // South

		// ��ġ�� ������
		super.setLocation(400, 200);
		// setSize(300, 300);
		pack(); // Ŭ���̾�Ʈ ũ�Ⱑ ���� ��.

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_input() {
		// TODO Auto-generated method stub

		JPanel p = new JPanel(new BorderLayout());
		jtf_message = new JTextField();
		jbt_connect = new JButton("����");

		jbt_connect.setPreferredSize(new Dimension(120, 0));

		p.add(jtf_message, BorderLayout.CENTER);
		p.add(jbt_connect, BorderLayout.EAST);

		this.add(p, BorderLayout.SOUTH);

		jtf_message.setFont(font);

		// ��ư �̺�Ʈ
		jbt_connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // ����� ���忡 ����ȭ�� �ɾ����.
				// TODO Auto-generated method stub

				bConnect = !bConnect;

				if (bConnect) { // ����
					try {
						client = new Socket("172.16.7.100", 8000);

						// ����޼��� ����: "IN#ȫ�浿\n"
						String send_data = String.format("IN#%s\n", nick_name);
						client.getOutputStream().write(send_data.getBytes());

						// ������ ����
						my_read_message();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();

						my_display_message("�������");
						bConnect = false;

					}

				} else { // ����
					try {
						client.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// ��ư ĸ�Ǻ���
				jbt_connect.setText(bConnect ? "����" : "����");

			}
		});

	}

	protected void my_read_message() {
		// TODO Auto-generated method stub
		try {
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			// ���� ������
			new Thread() {
				public void run() {
					while (true) {
						try {
							String readStr = br.readLine();
							if (readStr == null)
								break;

							System.out.println("���Ÿ޼����� �̿��ؼ� ó��");
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

		// �б�����
		jta_display.setEditable(false);

		jta_display.setFont(font);

		// jta_display.append("--���������--\r\n");

	}

	public static void main(String[] args) {
		new MultiClient();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}
}
