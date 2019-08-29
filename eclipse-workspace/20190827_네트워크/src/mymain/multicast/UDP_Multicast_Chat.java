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

	JTextArea jta_display;// ���â

	JTextField jtf_ip_address;// IP �ּ�
	JTextField jtf_message; // �޽���

	JList<String> jlist_group_list;
	List<String> group_list = new ArrayList<String>();// ���尴ü

	Font font = new Font("����ü", Font.BOLD, 22);

	String nick_name = "t";

	// UDP����
	MulticastSocket socket;

	public UDP_Multicast_Chat() {
		// TODO Auto-generated constructor stub
		super("Multicast Chat");// JFrame("Ÿ��Ʋ") call

		// ���â�ʱ�ȭ
		init_display();

		// �Է�â�ʱ�ȭ
		init_input();

		// ���Ա׷���â �ʱ�ȭ
		init_group_list();

		// �����ʱ�ȭ
		init_socket();

		// ��ġ
		setLocation(400, 200);
		// ũ��
		// setSize(300, 300);
		pack();

		// �������
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_group_list() {
		// TODO Auto-generated method stub
		jlist_group_list = new JList<String>();

		jlist_group_list.setPreferredSize(new Dimension(160, 0));
		jlist_group_list.setFont(font);
		this.add(jlist_group_list, BorderLayout.EAST);

		// JList�� �ִ� ���
		// String [] group_array = {"224.0.0.1","224.0.0.2","224.0.0.3"};
		// jlist_group_list.setListData(group_array);

	}

	private void init_socket() {
		// TODO Auto-generated method stub

		try {
			socket = new MulticastSocket(6000);

			// ������ ����
			my_read_message();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void my_read_message() {
		// TODO Auto-generated method stub
		// ���ſ� ������ ����

		Thread t = new Thread() { // �߻�Ŭ������ �������̽� �Ӹ� �ƴ϶� �Ϲ� Ŭ������ ������ ���ÿ� ���ǰ� ������.
			public void run() {
				String name = Thread.currentThread().getName();

				// ������ ����
				while (true) {
					try {
						byte[] buff = new byte[512];
						DatagramPacket dp = new DatagramPacket(buff, buff.length);

						socket.receive(dp);

						// �۽��� �ּ�
						InetAddress ia = dp.getAddress();
						String ip = ia.getHostAddress();

						byte[] read_bytes = dp.getData();
						String read_data = new String(read_bytes, 0, read_bytes.length);

						// read_data = "ȫ�浿#�ȳ��ϼ���"

						String[] msg_array = read_data.split("#");
						// String [] msg_array = {"ȫ�浿", "�ȳ��ϼ���"};

						String display_message = String.format("%s�� ����: \r\n %s", msg_array[0], msg_array[1]);

						// ȭ�� ���
						my_display_message(display_message);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace(); // IOEX���� EX�ϸ�(���ļ�) ���α׷��� ������������ ����.
					}

				}

			}
		};

		t.start(); // ���� ������ ����
	}

	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(3, 1));
		// �ּ�â
		jtf_ip_address = new JTextField("224.0.0.1");

		// ��ư2��
		JPanel p1 = new JPanel(new GridLayout(1, 2));
		JButton jbt_join = new JButton("����");
		JButton jbt_leave = new JButton("Ż��");
		p1.add(jbt_join);
		p1.add(jbt_leave);

		// �޽���â
		jtf_message = new JTextField();

		p.add(jtf_ip_address);
		p.add(p1);
		p.add(jtf_message);

		this.add(p, BorderLayout.SOUTH); // "South"

		// ��Ʈ����
		jtf_ip_address.setFont(font);
		jtf_message.setFont(font);

		// Ű�̺�Ʈ
		jtf_message.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					my_send_message();
				}
			}
		});

		// ��ư�̺�Ʈ
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
		// ���ԵǾ��ִ��� Ȯ��
		int result = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
		// (����, ����, ��ư )
		System.out.println(result); // ��ư �� Ȯ�� (3���� 0,1,-1)
		
		String ip = jtf_ip_address.getText();

		if (result != JOptionPane.YES_NO_OPTION)
			return;

		// ��ȿ��
		if (group_list.contains(ip)) {

			try {
				
				//System.out.println(ip);
				
				InetAddress ia = InetAddress.getByName(ip);
				// �׷���
				socket.leaveGroup(ia);

				// ArrayList�߰�
				group_list.remove(ip);
				// JList�� �߰�
				// ArrayList -> Array����
				String[] group_array = new String[group_list.size()];
				group_list.toArray(group_array);
				jlist_group_list.setListData(group_array);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
		JOptionPane.showMessageDialog(this, "���ԵǾ����� ���� �ּ��Դϴ�");
		return;
		}



	}

	protected void my_join_group() {
		// TODO Auto-generated method stub
		
		
		// ������ �ּ� ������
		String ip = jtf_ip_address.getText();

		if (group_list.contains(ip)) {

			JOptionPane.showMessageDialog(this, "�̹� ���Ե� �ּ��Դϴ�");
			return;
		}

		try {
			
			//System.out.println(ip);
			
			InetAddress ia = InetAddress.getByName(ip);
			// �׷���
			socket.joinGroup(ia);

			// ArrayList�߰�
			group_list.add(ip);
			// JList�� �߰�
			// ArrayList -> Array����
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
		// �Էµ� �޽��� �������� + trim() <-��������
		String message = jtf_message.getText().trim();

		if (message.isEmpty()) {// ����ֳ�?
			jtf_message.setText("");// ����
			jtf_message.requestFocus();
			return;
		}

		try {

			// ������ �ּ�
			// broadcast�ּ�
			// local_broadcast : 172.16.7.255
			// global_broadcast : 255.255.255.255
			String ip_address = jtf_ip_address.getText();
			InetAddress ia = InetAddress.getByName(ip_address);

			// ���۵����� ���� : send_data = "ȫ�浿#�ȳ��ϼ���";
			String send_data = String.format("%s(%s)#%s", nick_name, ip_address, message);

			// ������ + �ּ�����
			byte[] send_bytes = send_data.getBytes();// String->byte []
			DatagramPacket dp = new DatagramPacket(send_bytes, send_bytes.length, ia, 6000); // ��Ʈ ���������Ƿ� ���� ����
			// ����
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

		// ��ũ�� ó��
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);

	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		// ���뽺ũ�� ó��
		JScrollPane jsp = new JScrollPane(jta_display);

		jsp.setPreferredSize(new Dimension(400, 400));

		this.add(jsp, BorderLayout.CENTER);

		jta_display.setFont(font);

		// ���â �б�����
		jta_display.setEditable(false);

		jta_display.append("~~����� ���â�Դϴ�~~\r\n");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDP_Multicast_Chat();
	}
}
