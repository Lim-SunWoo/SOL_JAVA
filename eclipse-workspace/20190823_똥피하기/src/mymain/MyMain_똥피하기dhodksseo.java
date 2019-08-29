package mymain;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mycommon.Constant;

public class MyMain_�����ϱ�dhodksseo extends JFrame {

	static Image back_image;
	static {
		back_image = new ImageIcon("background.jpg").getImage();
	}

	JPanel gamePan;

	public MyMain_�����ϱ�dhodksseo() {

		super("�����ϱ� ����"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		// ������ �ʱ�ȭ
		init_gamepan();

		// ��ġ�� ������
		super.setLocation(300, 100);

		setResizable(false);
		pack(); // �ڽ� �����츦 JFrame���� ���Ѵ�.

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ���������� ������ â ������ ����� paint();�� ȣ���ؼ� ȭ���� ��������.
	class GamePan extends JPanel {
		@Override // �������� �ٽ� �׸��� ����.
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(back_image, 0, 0, this);

			g.drawString("���� ��������", 10, 50);
			// super.paintComponent(g);
		}
	}

	private void init_gamepan() {
		gamePan = new JPanel(); // {}�ϸ� �͸� ���� Ŭ������ �������. ��ü ������ ���ÿ� �����Ǹ� ��.
		gamePan.setPreferredSize(new Dimension(Constant.GAMEPAN_W, Constant.GAMEPAN_H));

		this.add(gamePan);
	}

	public static void main(String[] args) {
		new MyMain_�����ϱ�dhodksseo();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}

}
