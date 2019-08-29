package mymain;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//자바에서 윈도우 기능을 만드는 패키지 
// java.awt.~ (Abstract Window )
// ㄴ상속받아서 만든 javax.swing.스윙객체.

public class MyWin extends JFrame {

	public MyWin() {
		// TODO Auto-generated constructor stub

		// dnlsehdn wpahr
		super.setTitle("내가 만든 윈도우창");

		setLayout(null);

		// 버튼 생성
		JButton jbt1 = new JButton("클릭해보세요");
		this.add(jbt1);
		// jbt1.setButtons(x,y,width,height);
		jbt1.setBounds(75, 30, 150, 30);

		// 텍스트 필드
		JTextField jtf_name = new JTextField();

		this.add(jtf_name);
		jtf_name.setBounds(75, 70, 150, 30);

		// 콤보박스 제목
		JLabel jlb_blood = new JLabel("혈액형");
		this.add(jlb_blood);
		jlb_blood.setBounds(20, 110, 150, 30);

		// 콤보박스 // 목록 나오는 것
		String[] blood_array = { "A형", "B형", "O형", "AB형" };
		JComboBox jcb_blood = new JComboBox(blood_array);
		this.add(jcb_blood);
		jcb_blood.setBounds(75, 110, 150, 30);

		// ******************

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
