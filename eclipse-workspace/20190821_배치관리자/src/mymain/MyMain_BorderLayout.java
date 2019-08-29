package mymain;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_BorderLayout extends JFrame {

	public MyMain_BorderLayout() {
		super("Boder Layout"); // JFrame("타이틀") 호출과 같은 기능을 함.

		// 보더 레이아웃을 갖는 컨트롤러 : JFrame, JDialog
		JButton jbt_east = new JButton("East");
		JButton jbt_west = new JButton("West");
		JButton jbt_south = new JButton("South");
		JButton jbt_north = new JButton("North");
		JButton jbt_center = new JButton("Center");
		// 각 컨트롤을 배치
		// (적재 컨트롤, 위치) > 순서 바뀌어도 상관없음
		this.add(jbt_east, "East");
		this.add(jbt_west, BorderLayout.WEST);
		this.add(jbt_south, "South");
		this.add(jbt_north, "North");
		this.add(jbt_center, "Center");

		// 위치와 사이즈
		super.setLocation(400, 200);
		setSize(300, 300);

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_BorderLayout();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}
}
