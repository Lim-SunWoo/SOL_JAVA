package mymain;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_FlowLayout extends JFrame {

	public MyMain_FlowLayout() {
		super("FlowLayout ����"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		// Layout����
		// FlowLayout fl = new FlowLayout(FlowLayout.RIGHT); // (���ı���)
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 40, 20); // (����, , ���򰣰� ��������)

		this.setLayout(fl);

		int count = 10;
		for (int i = 0; i < count; i++) {
			String title = String.format("%03d", i);
			JButton jbt = new JButton(i + 1 + "");
			this.add(jbt);
		}

		// ��ġ�� ������
		super.setLocation(400, 200);
		setSize(300, 300);

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_FlowLayout();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}
}
