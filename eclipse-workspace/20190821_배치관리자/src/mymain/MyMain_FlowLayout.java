package mymain;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_FlowLayout extends JFrame {

	public MyMain_FlowLayout() {
		super("FlowLayout 연습"); // JFrame("타이틀") 호출과 같은 기능을 함.

		// Layout변경
		// FlowLayout fl = new FlowLayout(FlowLayout.RIGHT); // (정렬기준)
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 40, 20); // (정렬, , 수평간격 수직간격)

		this.setLayout(fl);

		int count = 10;
		for (int i = 0; i < count; i++) {
			String title = String.format("%03d", i);
			JButton jbt = new JButton(i + 1 + "");
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
		new MyMain_FlowLayout();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}
}
