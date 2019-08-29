package mymain;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_GridLayout extends JFrame {

	public MyMain_GridLayout() {
		super("GridLayout ����"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		// ���̾ƿ� ����
		GridLayout gl = new GridLayout(3, 4); // ��, ��, �����, ������
		this.setLayout(gl); // this�� ������

		int counter = 10;// �� �켭
		for (int i = 0; i < counter; i++) {
			String title = String.format("Bt_%02d", i);
			JButton jbt = new JButton(title);
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
		new MyMain_GridLayout();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}
}
