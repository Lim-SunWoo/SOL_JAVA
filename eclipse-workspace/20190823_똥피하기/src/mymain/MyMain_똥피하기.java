package mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import mycommon.Constant;

public class MyMain_똥피하기 extends JFrame {

	static Image back_image;
	static {
		back_image = new ImageIcon("C://Users/Soldesk/eclipse-workspace/20190823_똥피하기/src/mymain/background.jpg")
				.getImage();
	}

	JPanel gamePan;
	Timer timer;

	// 똥매니져
	DungManager dungManager = new DungManager();
	Me me = new Me();
	int key_state = Constant.Key.NONE;

	public MyMain_똥피하기() {
		// TODO Auto-generated constructor stub
		super("xkdlxmdmdmdmdmf");// JFrame("타이틀") call

		// 게임판 초기화
		init_gamepan();

		// 타이머 초기화
		init_timer();

		// 키이벤트 초기화
		init_key_event();

		// 위치
		setLocation(400, 200);
		// 크기
		// setSize(300, 300);

		setResizable(false);

		pack();// 자식윈도우를 JFrame으로 감싼다

		// 보여줘라
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_key_event() {
		// TODO Auto-generated method stub
		KeyListener listener = new KeyAdapter() { // 알쉬S오버라이드

			@Override
			public void keyPressed(KeyEvent e) { // 추가
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_LEFT) {
					// 움직이기는 하나 딱딱 끊김. me.move_left();
					key_state = key_state | Constant.Key.LEFT;
				} else if (key == KeyEvent.VK_RIGHT) {
					// 움직이기는 하나 딱딱 끊김. me.move_right();
					key_state = key_state | Constant.Key.RIGHT;

				}
			}

			@Override
			public void keyReleased(KeyEvent e) { // 소거
				// TODO Auto-generated method stub
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_LEFT) {
					// 움직이기는 하나 딱딱 끊김. me.move_left();
					key_state = key_state ^ Constant.Key.LEFT;
				} else if (key == KeyEvent.VK_RIGHT) {
					// 움직이기는 하나 딱딱 끊김. me.move_right();
					key_state = key_state ^ Constant.Key.RIGHT;

				}
			}
		};
		this.addKeyListener(listener);
	}

	private void init_timer() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-gener               ated method stub

				process();

				// 다시그려라
				gamePan.repaint();
			}
		};

		// FPS Frame Per Second 초당

		// 1/1000 수행객체
		timer = new Timer(10, listener);
		timer.start();

	}

	// 게임판

	// SwingComponent는 자신을 그리기 위한 메소드가

	// paintComponent(Graphics g)

	// 2. 언제 호출되나?
	// 1.프로그램 처음 시작할 때
	// 다시 그려져야할 필요가 있을 때
	// 다른 윈도우에 가져갔다가 사라질 때
	// 사용자호출: gamePAn, repaint() call
	// paintComponent Call

	// 게임판

	// int x =0, y=200; // 파랭이 사각형 테스트
	class GamePan extends JPanel {
		@Override
		protected void paintComponent(Graphics g) { // 변경된 부분만 다시 그림.
			// TODO Auto-generated method stub
			// 배경이미지
			draw_backgroun(g);
			// 게임제목
			draw_title(g);
			// 나 그리기
			me.draw(g);

			// 똥그리기
			dungManager.draw_all(g);

			// g.setColor(Color.blue);
			// g.fillRect(x, y, 20, 20);

			dungManager.draw_all(g);

		}
	}

	protected void process() {
		// TODO Auto-generated method stub

		// 똥만들기
		dungManager.make_dung();

		// 똥이동시키기
		dungManager.move_all();

		//setTitle(dungManager.dung_list.size() + "");
		// 나 이동시키기
		me.move(key_state);

	}

	private void init_gamepan() {
		// TODO Auto-generated method stub
		gamePan = new GamePan();

		gamePan.setPreferredSize(new Dimension(Constant.GAMEPAN_W, Constant.GAMEPAN_H));
		this.add(gamePan);

	}

	Font font = new Font("휴면옛체", Font.BOLD, 30);

	public void draw_title(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(font);
		g.drawString("똥피하기게임", 110 + 2, 35 + 2);
		g.setColor(Color.blue);
		g.drawString("똥피하기게임", 110, 35);
	}

	public void draw_backgroun(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(back_image, 0, 0, this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_똥피하기();
	}
}