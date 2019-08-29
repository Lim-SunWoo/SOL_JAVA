package mymain;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMain_CardLayout extends JFrame {

	CardLayout card;
	JPanel centerP;

	public MyMain_CardLayout() {
		// TODO Auto-generated constructor stub
		super("타이틀"); // JFrame("타이틀") 호출과 같은 기능을 함.

		// 메뉴
		init_menu();

		// 카드Layout초기화
		init_cardLayout();

		// 위치
		setLocation(400, 200);
		// 크기
		setSize(500, 400);

		// 보여줘라
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_cardLayout() {
		// TODO Auto-generated method stub

		card = new CardLayout();

		// 중앙배치할 패널생성+ cardLayout적용
		centerP = new JPanel();//
		centerP.setLayout(card);

		this.add(centerP, "Center");

		MyPanel1 mp1 = new MyPanel1();
		MyPanel2 mp2 = new MyPanel2();
		MyPanel3 mp3 = new MyPanel3();

		// centerP에 적재
		// 카드이름
		centerP.add(mp1, "1");
		centerP.add(mp2, "2");
		centerP.add(mp3, "3");

	}

	private void init_menu() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(1, 3));

		JButton jbt1 = new JButton("스윙컨트롤연습");
		JButton jbt2 = new JButton("로그인화면");
		JButton jbt3 = new JButton("3");

		p.add(jbt1);
		p.add(jbt2);
		p.add(jbt3);

		this.add(p, "North");

		// 버튼이벤트
		jbt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(centerP, "1");

			}
		});

		jbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(centerP, "2");
			}
		});

		jbt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(centerP, "3");
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_CardLayout();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}
}
