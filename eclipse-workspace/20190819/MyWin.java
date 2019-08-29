package mymain;

import java.awt.Frame;
import javax.swing.JFrame;

//자바에서 윈도우 기능을 만드는 패키지 
// java.awt.~ (Abstract Window )
// ㄴ상속받아서 만든 javax.swing.스윙객체.

public class MyWin extends JFrame {

	public MyWin() {
		// TODO Auto-generated constructor stub

		// dnlsehdn wpahr
		super.setTitle("내가 만든 윈도우창");
		// 
		
		// 생성위치, 모니터 기준
		super.setLocation(300, 200);
		// 크기지정
		super.setSize(300, 300);
		// 조절 불가
		super.setResizable(false);
		// 보여줘라
		super.setVisible(true);
		// X버튼 누르면 hide로 변경, 하지만 
		// 터미널에는 계속 돌아가고있음. > 종료코드를 설정해야함.
		// X버튼 누르면 끝내라.
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // defalt도 가능
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyWin(); // jframe상속받는 객체

	}

}
