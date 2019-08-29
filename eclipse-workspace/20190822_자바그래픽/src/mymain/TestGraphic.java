package mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestGraphic extends JFrame {

	static Image img;
	
	static { // main method���� ���� ó����.
		// �̹����� ���� �ȵ�.
		// �̹��� �ε�
		img = new ImageIcon("ik.jpg").getImage();
	}

	JPanel grimPan;

	public TestGraphic() {
		super("�׷���"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		init_grimPan();

		// ���콺�̺�Ʈ
		init_mouse_event();

		// ��ġ�� ������
		super.setLocation(400, 200);
		setResizable(false);// ��ŷ ���� �� ��
		// setSize(300, 300);
		pack(); // ��Ű¡ ���� �ڽ� ������ �ֺ��� �������� ���δ� ����

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Dimension d = grimPan.getSize();

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		// Listener(interface)->Adapter(�̹������� �� ���� �߻�Ŭ����)
		// Adapter�� �̿��ϸ� �ʿ��� �̺�Ʈ�� �����ؼ� ��밡���ϴ�
		MouseListener listener = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				// �׸��ǿ� �׸� �ױ�� ���� ���
				Graphics g = grimPan.getGraphics();

				Point pt = e.getPoint();
				int button = e.getButton();

				if (button == MouseEvent.BUTTON1) {
					String str = String.format("(%d, %d) Click", pt.x, pt.y);
					g.drawString(str, pt.x, pt.y);
					g.drawImage(img, pt.x, pt.y, null);

				} else if (button == MouseEvent.BUTTON2) {
					// �簢��
					g.drawRect(pt.x, pt.y, 100, 100);
					g.setColor(Color.cyan);
					g.fillRect(pt.x + 105, pt.y, 50, 50);
				} else if (button == MouseEvent.BUTTON3) {
					g.drawOval(pt.x, pt.y, 100, 100);
					g.setColor(Color.magenta);
					g.fillOval(pt.x + 105, pt.y, 50, 50);
				}

				super.mousePressed(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
			}
		};

		grimPan.addMouseListener(listener);
		// listener��� ���� �� �������̽� () �� ����� �̺�Ʈ�� �ʹ� ����.
		//

	}

	private void init_grimPan() {
		// TODO Auto-generated method stub
		grimPan = new JPanel();

		// �׸��� ũ�� ����, ����
		grimPan.setPreferredSize(new Dimension(500, 500));

		this.add(grimPan);
	}

	public static void main(String[] args) {
		new TestGraphic();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}
}
