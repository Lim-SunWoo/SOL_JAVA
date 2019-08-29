package mymain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MoveWin extends JFrame {

	// ���� Ŭ���� : KeyEvent ó�� ��ü�� ����
	class MyKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

			// � Ű�� ���ȳ�
			// System.out.println(e);
			int key = e.getKeyCode(); // ���� Ű VK_A VK_UP
			System.out.println(key);
			// ����Ű�� ���� ���� -> Ű���� ������ ���� ���ϰ��� �ٸ��� ������ ������ ���ؼ� ����Ű���带 ��.
			// ȭ�鿡�� �����.
			
			// ���� �������� ��ġ
			// point (x.y)�� ��� ���� �ڷ�
			Point pt = getLocation(); // this���� �ȵ�. BC, this�� ����Ű�°� KeyListener�� ��ġ�� ����.

			// �̵� ����
			int move_gan = 20;
			
			// ��Ʈ�� �ػ� ���ϱ�
			int screen_w, screen_h;
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			screen_h = d.height;
			screen_w = d.width;

			if (key == KeyEvent.VK_LEFT) {
				pt.x = pt.x - move_gan;
				if (pt.x < -300)
					pt.x = screen_w;
			} else if (key == KeyEvent.VK_RIGHT) {
				pt.x = pt.x + move_gan;
				if (pt.x > screen_w)
					pt.x = -300;
			} else if (key == KeyEvent.VK_UP) { // Y��ǥ�� ���ڰ� Ŭ ���� ��
				pt.y = pt.y - move_gan;
				if (pt.y < -300)
					pt.y = screen_h;
			} else if (key == KeyEvent.VK_DOWN) {
				pt.y = pt.y + move_gan;
				if (pt.y > screen_h)
					pt.y = -300;
			}

			// ������ ��ǥ�� ���������쿡 �����ϱ�
			setLocation(pt);

		}

		@Override
		public void keyTyped(KeyEvent e) { // �ƽ�Ű�ڵ� ���� �Ⱦ�
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	public MoveWin() {
		// super("Ÿ��Ʋ"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.
		super("�����δ�~!!!");


		// ��ġ�� ������
		super.setLocation(400, 200);
		setSize(300, 300);

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// keyEvent��� (JVM)
		KeyListener listener = new MyKeyListener();
		this.addKeyListener(listener);
	}

	public static void main(String[] args) {
		new MoveWin();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}
}
