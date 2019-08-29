package mymain;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mycommon.Constant;

public class MyMain_똥피하기dhodksseo extends JFrame {

	static Image back_image;
	static {
		back_image = new ImageIcon("background.jpg").getImage();
	}

	JPanel gamePan;

	public MyMain_똥피하기dhodksseo() {

		super("똥피하기 게임"); // JFrame("타이틀") 호출과 같은 기능을 함.

		// 게임판 초기화
		init_gamepan();

		// 위치와 사이즈
		super.setLocation(300, 100);

		setResizable(false);
		pack(); // 자식 윈도우를 JFrame으로 감싼다.

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 내부적으로 윈도우 창 밖으로 벗어나면 paint();를 호출해서 화면을 지워버림.
	class GamePan extends JPanel {
		@Override // 지워진걸 다시 그리게 해줌.
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(back_image, 0, 0, this);

			g.drawString("절대 안지워져", 10, 50);
			// super.paintComponent(g);
		}
	}

	private void init_gamepan() {
		gamePan = new JPanel(); // {}하면 익명 내부 클래스가 만들어짐. 객체 생성과 동시에 재정의를 함.
		gamePan.setPreferredSize(new Dimension(Constant.GAMEPAN_W, Constant.GAMEPAN_H));

		this.add(gamePan);
	}

	public static void main(String[] args) {
		new MyMain_똥피하기dhodksseo();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}

}
