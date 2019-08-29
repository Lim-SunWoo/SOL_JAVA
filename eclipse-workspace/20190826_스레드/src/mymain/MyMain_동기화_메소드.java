package mymain;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_����ȭ_�޼ҵ� extends JFrame {

	JButton jbt_red, jbt_yellow, jbt_green;

	// ���ఴü �����
	class SignalRunable extends Object implements Runnable {
		synchronized void redOn() { // this �� ���ԵǸ� ����ȭ�� �����ϴ� �⺻ ��ü���� this�� �ٰ� �Ǿ� �ȵ�.
			jbt_red.setBackground(Color.red);
			jbt_yellow.setBackground(Color.gray);
			jbt_green.setBackground(Color.gray);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		synchronized void yellowOn() {

			jbt_red.setBackground(Color.gray);
			jbt_yellow.setBackground(Color.yellow);
			jbt_green.setBackground(Color.gray);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		synchronized void greenOn() {

			jbt_red.setBackground(Color.gray);
			jbt_yellow.setBackground(Color.gray);
			jbt_green.setBackground(Color.green);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block

			}
		}

		public void run() {
			String name = Thread.currentThread().getName();

			while (true) {
				if (name.equals("R")) {
					redOn();

				} else if (name.equals("Y")) {
					yellowOn();

				} else if (name.equals("G")) {

					greenOn();

				} // ������ ������ �ڿ��� �����Ǵ� ���� : �Ӱ迵��? -> �������.

			}

		}
	}

	public MyMain_����ȭ_�޼ҵ�() {
		super("��ȣ��"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		setLayout(new GridLayout(1, 3, 5, 5));

		jbt_red = new JButton();
		jbt_yellow = new JButton();
		jbt_green = new JButton();

		jbt_red.setBackground(Color.red);
		jbt_yellow.setBackground(Color.yellow);
		jbt_green.setBackground(Color.green);

		this.add(jbt_red);
		this.add(jbt_yellow);
		this.add(jbt_green);

		Runnable r = new SignalRunable();
		Thread t_R = new Thread(r, "R");
		Thread t_Y = new Thread(r, "Y");
		Thread t_G = new Thread(r, "G");
		// ��ü�� �ϳ����� ���̶� �޼����� �� �����尡 ��ŸƮ �� ������ ���� ������.

		t_R.start();
		t_Y.start();
		t_G.start();

		// ��ġ�� ������
		super.setLocation(400, 200);
		setSize(300, 130);

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_����ȭ_�޼ҵ�();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}

	// ����ȭ�� �ȵǾ ���� ������.
}
