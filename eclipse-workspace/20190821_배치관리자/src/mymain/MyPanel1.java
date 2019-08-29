package mymain;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyPanel1 extends JPanel {

	Font font = new Font("휴먼옛체", Font.BOLD, 25);

	public MyPanel1() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(7, 1));

		// 1번째줄
		JLabel jlb_title = new JLabel("::::컨트롤 연습::::", JLabel.CENTER);
		jlb_title.setFont(font);
		Color color = new Color(80, 180, 250);
		jlb_title.setForeground(color);
		this.add(jlb_title);

		// 2번째줄
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jlb_name = new JLabel("이름:");
		JTextField jtf_name = new JTextField(10);
		p2.add(jlb_name);
		p2.add(jtf_name);
		this.add(p2);

		// 3번째줄
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jlb_gender = new JLabel("성별:");
		JRadioButton jrb_male = new JRadioButton("남자", true);
		JRadioButton jrb_female = new JRadioButton("여자");

		p3.add(jlb_gender);
		p3.add(jrb_male);
		p3.add(jrb_female);

		// 2개 버튼기능을 묶는다
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb_male);
		bg.add(jrb_female);

		this.add(p3);

		// 4번째줄
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jlb_hobby = new JLabel("취미:");
		JCheckBox jcb_hobby1 = new JCheckBox("낚시");
		JCheckBox jcb_hobby2 = new JCheckBox("독서");
		JCheckBox jcb_hobby3 = new JCheckBox("영화");
		JCheckBox jcb_hobby4 = new JCheckBox("운동");

		p4.add(jlb_hobby);
		p4.add(jcb_hobby1);
		p4.add(jcb_hobby2);
		p4.add(jcb_hobby3);
		p4.add(jcb_hobby4);

		this.add(p4);

		// 5번째줄
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jlb_blood = new JLabel("혈액형:");
		String[] blood_array = { "A", "B", "O", "AB" };
		JComboBox jcb_blood = new JComboBox(blood_array);

		p5.add(jlb_blood);
		p5.add(jcb_blood);

		this.add(p5);

		// 6번째줄 :
		JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jlb_pwd = new JLabel("비밀번호:");
		JPasswordField jpf_pwd = new JPasswordField(10);
		p6.add(jlb_pwd);
		p6.add(jpf_pwd);

		this.add(p6);

		// 7번째줄
		JPanel p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton jbt_register = new JButton("가입하기");
		JButton jbt_cancel = new JButton("취소하기");

		p7.add(jbt_register);
		p7.add(jbt_cancel);

		this.add(p7);

	}
}
