package mymain;

import javax.swing.JFrame;

public class MyMain_�������̽�Ȱ�� extends JFrame {

	public MyMain_�������̽�Ȱ��() {
		super("Ÿ��Ʋ"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		// ��ġ�� ������
		super.setLocation(400, 200);
		setSize(300, 300);

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_�������̽�Ȱ��();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}
}
