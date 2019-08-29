// 스윙 버튼을 만드는 다양한 방법

package mymain;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HelloWin extends JFrame {

	public HelloWin() {
		super("각 나라 인사말"); // JFrame("타이틀") 호출과 같은 기능을 함.

		setLayout(new GridLayout(3, 2));
		JButton jbt_kor = new JButton("한국어 인사말");
		JButton jbt_eng = new JButton("영어 인사말");
		JButton jbt_jpn = new JButton("일본어 인사말");
		JButton jbt_chn = new JButton("중국어 인사말");
		JButton jbt_frn = new JButton("프랑스 인사말");
		JButton jbt_ind = new JButton("인도 인사말");

		this.add(jbt_kor); // this는 프레임
		this.add(jbt_eng);
		this.add(jbt_jpn);
		this.add(jbt_chn);
		this.add(jbt_frn);
		this.add(jbt_ind);

		// 각 버튼 이벤트 처리
		// 한국 정석
		class MyButtonEventListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("한국어 인사 알려줘!");
				JOptionPane.showMessageDialog(HelloWin.this, "한국어 인사는 '안녕하세요'입니다.");
			}
		}

		// 영어 익명개체
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("영어 인사 알려줘!");
				JOptionPane.showMessageDialog(HelloWin.this, "영어 인사는 'HELLO'입니다.");
			}
		};
		jbt_eng.addActionListener(listener);

		// 일본어 익명내부 클래스
		jbt_jpn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("일본어 인사 알려줘!");
				JOptionPane.showMessageDialog(HelloWin.this, "일본어 인사는 'おはようございます'입니다.");
			}
		});

		// 중국어
		jbt_chn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("중국어 인사 알려줘!");
				JOptionPane.showMessageDialog(HelloWin.this, "중국어 인사는 '니하오'입니다.");
			}
		});

		// 프랑스
		jbt_frn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("프랑스 인사 알려줘!");
				JOptionPane.showMessageDialog(HelloWin.this, "프랑스 인사는 'Bonjour'입니다.");
			}
		});

		
		// -----------
		ActionListener actionListener = new MyButtonEventListener();
		jbt_kor.addActionListener(actionListener); // 처리객체 / A.가 눌리면 ()에게 처리를 위임한다.

		// 위치와 사이즈
		super.setLocation(400, 200);
		setSize(300, 300);

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new HelloWin();
		// 윈도우를 또 만드려고 할 때 작업의 효울성을 위해 탬플렛을 설정해놓으면 좋음.
	}
}