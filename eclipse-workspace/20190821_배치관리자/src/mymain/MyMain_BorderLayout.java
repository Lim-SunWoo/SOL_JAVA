package mymain;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_BorderLayout extends JFrame {

	public MyMain_BorderLayout() {
		super("Boder Layout"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		// ���� ���̾ƿ��� ���� ��Ʈ�ѷ� : JFrame, JDialog
		JButton jbt_east = new JButton("East");
		JButton jbt_west = new JButton("West");
		JButton jbt_south = new JButton("South");
		JButton jbt_north = new JButton("North");
		JButton jbt_center = new JButton("Center");
		// �� ��Ʈ���� ��ġ
		// (���� ��Ʈ��, ��ġ) > ���� �ٲ� �������
		this.add(jbt_east, "East");
		this.add(jbt_west, BorderLayout.WEST);
		this.add(jbt_south, "South");
		this.add(jbt_north, "North");
		this.add(jbt_center, "Center");

		// ��ġ�� ������
		super.setLocation(400, 200);
		setSize(300, 300);

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_BorderLayout();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}
}
