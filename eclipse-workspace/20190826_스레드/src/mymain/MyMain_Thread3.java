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

	// Red 진행하는 Thread

	class RedThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (true) {
				/// 현재 위치 값 얻어오기
				int pos = jpb_red.getValue();
				pos++;

				if (pos > 100)
					pos = 0;

				// 변경된 변수와 값을 다시 설정
				jpb_red.setValue(pos);

				try {
					this.sleep(10); // this는 RedThread
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
				/// 현재 위치 값 얻어오기
				int pos = jpb_blue.getValue();
				pos++;

				if (pos > 100)
					pos = 0;

				// 변경된 변수와 값을 다시 설정
				jpb_blue.setValue(pos);

				try {
					this.sleep(10); // this는 RedThread
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
				/// 현재 위치 값 얻어오기
				int pos = jpb_green.getValue();
				pos++;

				if (pos > 100)
					pos = 0;

				// 변경된 변수와 값을 다시 설정
				jpb_green.setValue(pos);

				try {
					this.sleep(10); // this는 RedThread
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public MyMain_Thread3() {

		super("190826"); // JFrame("타이틀") 호출과 같은 기능을 함.

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

		// Thread생성
		Thread t_red = new RedThread();
		t_red.start();

		Thread t_blue = new BlueThread();
		t_blue.start();

		Thread t_green = new GreenThread();
		t_green.start();

		// 키 이벤트
		KeyListener listener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);

				int key = e.getKeyCode();
				// 빨강색 제어
				if (key == KeyEvent.VK_R) { // R이나 r가 눌리면
					bRedRunning = !bRedRunning;
					if (bRedRunning) {
						t_red.resume(); // 재가동
					} else
						t_red.suspend(); // 일시정지
				}
				// 초록색 제어
				if (key == KeyEvent.VK_G) { // R이나 r가 눌리면
					bGreenRunning = !bGreenRunning;
					if (bGreenRunning) {
						t_green.resume(); // 재가동
					} else
						t_green.suspend(); // 일시정지
				}
				// 파란색 제어
				if (key == KeyEvent.VK_B) { // R이나 r가 눌리면
					bBlueRunning = !bBlueRunning;
					if (bBlueRunning) {
						t_blue.resume(); // 재가동
					} else
						t_blue.suspend(); // 일시정지
				}
			}
		};

		this.addKeyListener(listener);

		// 위치와 사이즈
		super.setLocation(400, 200);
		setSize(300, 150);

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_Thread3();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}
}
