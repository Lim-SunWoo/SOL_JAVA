package mymain;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_GridLayout extends JFrame {

	public MyMain_GridLayout() {
		super("GridLayout 연습"); // JFrame("타이틀") 호출과 같은 기능을 함.

		// 레이아웃 변경
		GridLayout gl = new GridLayout(3, 4); // 행, 열, 행공백, 열공백
		this.setLayout(gl); // this는 프레임

		int counter = 10;// 행 우서
		for (int i = 0; i < counter; i++) {
			String title = String.format("Bt_%02d", i);
			JButton jbt = new JButton(title);
			this.add(jbt);
		}

		// 위치와 사이즈
		super.setLocation(400, 200);
		setSize(300, 300);

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_GridLayout();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}
}
