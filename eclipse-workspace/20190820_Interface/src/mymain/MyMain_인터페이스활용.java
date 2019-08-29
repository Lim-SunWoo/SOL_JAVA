package mymain;

import javax.swing.JFrame;

public class MyMain_인터페이스활용 extends JFrame {

	public MyMain_인터페이스활용() {
		super("타이틀"); // JFrame("타이틀") 호출과 같은 기능을 함.

		// 위치와 사이즈
		super.setLocation(400, 200);
		setSize(300, 300);

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_인터페이스활용();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}
}
