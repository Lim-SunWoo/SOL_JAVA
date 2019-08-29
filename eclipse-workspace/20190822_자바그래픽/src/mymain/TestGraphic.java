package mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestGraphic extends JFrame {

	static Image img;
	
	static { // main method보다 먼저 처리됨.
		// 이미지는 직렬 안됨.
		// 이미지 로드
		img = new ImageIcon("ik.jpg").getImage();
	}

	JPanel grimPan;

	public TestGraphic() {
		super("그래픽"); // JFrame("타이틀") 호출과 같은 기능을 함.

		init_grimPan();

		// 마우스이벤트
		init_mouse_event();

		// 위치와 사이즈
		super.setLocation(400, 200);
		setResizable(false);// 패킹 전에 쓸 것
		// setSize(300, 300);
		pack(); // 패키징 포장 자식 윈도우 주변을 프레임이 감싸는 구조

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Dimension d = grimPan.getSize();

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		// Listener(interface)->Adapter(이미재정의 해 놓는 추상클래스)
		// Adapter를 이용하면 필요한 이벤트만 선택해서 사용가능하다
		MouseListener listener = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				// 그림판에 그릴 그기시 도구 얻기
				Graphics g = grimPan.getGraphics();

				Point pt = e.getPoint();
				int button = e.getButton();

				if (button == MouseEvent.BUTTON1) {
					String str = String.format("(%d, %d) Click", pt.x, pt.y);
					g.drawString(str, pt.x, pt.y);
					g.drawImage(img, pt.x, pt.y, null);

				} else if (button == MouseEvent.BUTTON2) {
					// 사각형
					g.drawRect(pt.x, pt.y, 100, 100);
					g.setColor(Color.cyan);
					g.fillRect(pt.x + 105, pt.y, 50, 50);
				} else if (button == MouseEvent.BUTTON3) {
					g.drawOval(pt.x, pt.y, 100, 100);
					g.setColor(Color.magenta);
					g.fillOval(pt.x + 105, pt.y, 50, 50);
				}

				super.mousePressed(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
			}
		};

		grimPan.addMouseListener(listener);
		// listener라고 했을 때 인터페이스 () 를 만들면 이벤트가 너무 많음.
		//

	}

	private void init_grimPan() {
		// TODO Auto-generated method stub
		grimPan = new JPanel();

		// 그림판 크기 지정, 예약
		grimPan.setPreferredSize(new Dimension(500, 500));

		this.add(grimPan);
	}

	public static void main(String[] args) {
		new TestGraphic();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}
}
