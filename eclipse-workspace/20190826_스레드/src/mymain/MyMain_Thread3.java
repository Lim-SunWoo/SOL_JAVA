package mymain;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MyMain_Thread3 extends JFrame {

	JProgressBar jpb_red, jpb_green, jpb_blue;

	boolean bRedRunning = true, bGreenRunning = true, bBlueRunning = true;

	// Red �����ϴ� Thread

	class RedThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (true) {
				/// ���� ��ġ �� ������
				int pos = jpb_red.getValue();
				pos++;

				if (pos > 100)
					pos = 0;

				// ����� ������ ���� �ٽ� ����
				jpb_red.setValue(pos);

				try {
					this.sleep(10); // this�� RedThread
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	class BlueThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (true) {
				/// ���� ��ġ �� ������
				int pos = jpb_blue.getValue();
				pos++;

				if (pos > 100)
					pos = 0;

				// ����� ������ ���� �ٽ� ����
				jpb_blue.setValue(pos);

				try {
					this.sleep(10); // this�� RedThread
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	class GreenThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (true) {
				/// ���� ��ġ �� ������
				int pos = jpb_green.getValue();
				pos++;

				if (pos > 100)
					pos = 0;

				// ����� ������ ���� �ٽ� ����
				jpb_green.setValue(pos);

				try {
					this.sleep(10); // this�� RedThread
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public MyMain_Thread3() {

		super("190826"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		setLayout(new GridLayout(3, 1));
		jpb_red = new JProgressBar();
		jpb_blue = new JProgressBar();
		jpb_green = new JProgressBar();

		jpb_red.setForeground(Color.red);
		jpb_green.setForeground(Color.green);
		jpb_blue.setForeground(Color.blue);

		jpb_red.setValue(10);
		jpb_blue.setValue(70);
		jpb_green.setValue(50);

		this.add(jpb_red);
		this.add(jpb_green);
		this.add(jpb_blue);

		// Thread����
		Thread t_red = new RedThread();
		t_red.start();

		Thread t_blue = new BlueThread();
		t_blue.start();

		Thread t_green = new GreenThread();
		t_green.start();

		// Ű �̺�Ʈ
		KeyListener listener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);

				int key = e.getKeyCode();
				// ������ ����
				if (key == KeyEvent.VK_R) { // R�̳� r�� ������
					bRedRunning = !bRedRunning;
					if (bRedRunning) {
						t_red.resume(); // �簡��
					} else
						t_red.suspend(); // �Ͻ�����
				}
				// �ʷϻ� ����
				if (key == KeyEvent.VK_G) { // R�̳� r�� ������
					bGreenRunning = !bGreenRunning;
					if (bGreenRunning) {
						t_green.resume(); // �簡��
					} else
						t_green.suspend(); // �Ͻ�����
				}
				// �Ķ��� ����
				if (key == KeyEvent.VK_B) { // R�̳� r�� ������
					bBlueRunning = !bBlueRunning;
					if (bBlueRunning) {
						t_blue.resume(); // �簡��
					} else
						t_blue.suspend(); // �Ͻ�����
				}
			}
		};

		this.addKeyListener(listener);

		// ��ġ�� ������
		super.setLocation(400, 200);
		setSize(300, 150);

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_Thread3();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}
}
