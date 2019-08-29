package mymain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MoveWin extends JFrame {

	// 내부 클래스 : KeyEvent 처리 객체를 선언
	class MyKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

			// 어떤 키가 눌렸나
			// System.out.println(e);
			int key = e.getKeyCode(); // 가상 키 VK_A VK_UP
			System.out.println(key);
			// 가상키를 쓰는 이유 -> 키보드 제조사 별로 리턴값이 다르기 때문에 통일을 위해서 가상키보드를 씀.
			// 화면에서 사라짐.
			
			// 현재 윈도우의 위치
			// point (x.y)를 묶어서 만즌 자료
			Point pt = getLocation(); // this쓰면 안됨. BC, this가 가리키는게 KeyListener라서 위치가 없음.

			// 이동 간격
			int move_gan = 20;
			
			// 스트린 해상도 구하기
			int screen_w, screen_h;
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			screen_h = d.height;
			screen_w = d.width;

			if (key == KeyEvent.VK_LEFT) {
				pt.x = pt.x - move_gan;
				if (pt.x < -300)
					pt.x = screen_w;
			} else if (key == KeyEvent.VK_RIGHT) {
				pt.x = pt.x + move_gan;
				if (pt.x > screen_w)
					pt.x = -300;
			} else if (key == KeyEvent.VK_UP) { // Y좌표의 숫자가 클 수록 밑
				pt.y = pt.y - move_gan;
				if (pt.y < -300)
					pt.y = screen_h;
			} else if (key == KeyEvent.VK_DOWN) {
				pt.y = pt.y + move_gan;
				if (pt.y > screen_h)
					pt.y = -300;
			}

			// 보정된 좌표를 현재윈도우에 적용하기
			setLocation(pt);

		}

		@Override
		public void keyTyped(KeyEvent e) { // 아스키코드 거의 안씀
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	public MoveWin() {
		// super("타이틀"); // JFrame("타이틀") 호출과 같은 기능을 함.
		super("움직인다~!!!");


		// 위치와 사이즈
		super.setLocation(400, 200);
		setSize(300, 300);

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// keyEvent등록 (JVM)
		KeyListener listener = new MyKeyListener();
		this.addKeyListener(listener);
	}

	public static void main(String[] args) {
		new MoveWin();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}
}
