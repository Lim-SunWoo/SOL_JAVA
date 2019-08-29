package mymain;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_동기화_메소드 extends JFrame {

	JButton jbt_red, jbt_yellow, jbt_green;

	// 수행객체 만들기
	class SignalRunable extends Object implements Runnable {
		synchronized void redOn() { // this 를 쓰게되면 동기화를 관리하는 기본 객체에도 this가 붙게 되어 안됨.
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

				} // 스레드 내에서 자원이 공유되는 영역 : 임계영역? -> 묶어놓자.

			}

		}
	}

	public MyMain_동기화_메소드() {
		super("신호등"); // JFrame("타이틀") 호출과 같은 기능을 함.

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
		// 객체는 하나지만 런이란 메세지는 각 스레드가 스타트 할 때마다 각자 움직임.

		t_R.start();
		t_Y.start();
		t_G.start();

		// 위치와 사이즈
		super.setLocation(400, 200);
		setSize(300, 130);

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_동기화_메소드();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}

	// 동기화가 안되어서 마구 움직임.
}
