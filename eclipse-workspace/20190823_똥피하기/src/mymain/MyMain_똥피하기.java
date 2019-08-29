package mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import mycommon.Constant;

public class MyMain_�����ϱ� extends JFrame {

	static Image back_image;
	static {
		back_image = new ImageIcon("C://Users/Soldesk/eclipse-workspace/20190823_�����ϱ�/src/mymain/background.jpg")
				.getImage();
	}

	JPanel gamePan;
	Timer timer;

	// �˸Ŵ���
	DungManager dungManager = new DungManager();
	Me me = new Me();
	int key_state = Constant.Key.NONE;

	public MyMain_�����ϱ�() {
		// TODO Auto-generated constructor stub
		super("xkdlxmdmdmdmdmf");// JFrame("Ÿ��Ʋ") call

		// ������ �ʱ�ȭ
		init_gamepan();

		// Ÿ�̸� �ʱ�ȭ
		init_timer();

		// Ű�̺�Ʈ �ʱ�ȭ
		init_key_event();

		// ��ġ
		setLocation(400, 200);
		// ũ��
		// setSize(300, 300);

		setResizable(false);

		pack();// �ڽ������츦 JFrame���� ���Ѵ�

		// �������
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_key_event() {
		// TODO Auto-generated method stub
		KeyListener listener = new KeyAdapter() { // �˽�S�������̵�

			@Override
			public void keyPressed(KeyEvent e) { // �߰�
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_LEFT) {
					// �����̱�� �ϳ� ���� ����. me.move_left();
					key_state = key_state | Constant.Key.LEFT;
				} else if (key == KeyEvent.VK_RIGHT) {
					// �����̱�� �ϳ� ���� ����. me.move_right();
					key_state = key_state | Constant.Key.RIGHT;

				}
			}

			@Override
			public void keyReleased(KeyEvent e) { // �Ұ�
				// TODO Auto-generated method stub
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_LEFT) {
					// �����̱�� �ϳ� ���� ����. me.move_left();
					key_state = key_state ^ Constant.Key.LEFT;
				} else if (key == KeyEvent.VK_RIGHT) {
					// �����̱�� �ϳ� ���� ����. me.move_right();
					key_state = key_state ^ Constant.Key.RIGHT;

				}
			}
		};
		this.addKeyListener(listener);
	}

	private void init_timer() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-gener               ated method stub

				process();

				// �ٽñ׷���
				gamePan.repaint();
			}
		};

		// FPS Frame Per Second �ʴ�

		// 1/1000 ���ఴü
		timer = new Timer(10, listener);
		timer.start();

	}

	// ������

	// SwingComponent�� �ڽ��� �׸��� ���� �޼ҵ尡

	// paintComponent(Graphics g)

	// 2. ���� ȣ��ǳ�?
	// 1.���α׷� ó�� ������ ��
	// �ٽ� �׷������� �ʿ䰡 ���� ��
	// �ٸ� �����쿡 �������ٰ� ����� ��
	// �����ȣ��: gamePAn, repaint() call
	// paintComponent Call

	// ������

	// int x =0, y=200; // �ķ��� �簢�� �׽�Ʈ
	class GamePan extends JPanel {
		@Override
		protected void paintComponent(Graphics g) { // ����� �κи� �ٽ� �׸�.
			// TODO Auto-generated method stub
			// ����̹���
			draw_backgroun(g);
			// ��������
			draw_title(g);
			// �� �׸���
			me.draw(g);

			// �˱׸���
			dungManager.draw_all(g);

			// g.setColor(Color.blue);
			// g.fillRect(x, y, 20, 20);

			dungManager.draw_all(g);

		}
	}

	protected void process() {
		// TODO Auto-generated method stub

		// �˸����
		dungManager.make_dung();

		// ���̵���Ű��
		dungManager.move_all();

		//setTitle(dungManager.dung_list.size() + "");
		// �� �̵���Ű��
		me.move(key_state);

	}

	private void init_gamepan() {
		// TODO Auto-generated method stub
		gamePan = new GamePan();

		gamePan.setPreferredSize(new Dimension(Constant.GAMEPAN_W, Constant.GAMEPAN_H));
		this.add(gamePan);

	}

	Font font = new Font("�޸鿾ü", Font.BOLD, 30);

	public void draw_title(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(font);
		g.drawString("�����ϱ����", 110 + 2, 35 + 2);
		g.setColor(Color.blue);
		g.drawString("�����ϱ����", 110, 35);
	}

	public void draw_backgroun(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(back_image, 0, 0, this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_�����ϱ�();
	}
}