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

	Font font = new Font("�޸տ�ü", Font.BOLD, 25);

	public MyPanel1() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(7, 1));

		// 1��°��
		JLabel jlb_title = new JLabel("::::��Ʈ�� ����::::", JLabel.CENTER);
		jlb_title.setFont(font);
		Color color = new Color(80, 180, 250);
		jlb_title.setForeground(color);
		this.add(jlb_title);

		// 2��°��
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jlb_name = new JLabel("�̸�:");
		JTextField jtf_name = new JTextField(10);
		p2.add(jlb_name);
		p2.add(jtf_name);
		this.add(p2);

		// 3��°��
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jlb_gender = new JLabel("����:");
		JRadioButton jrb_male = new JRadioButton("����", true);
		JRadioButton jrb_female = new JRadioButton("����");

		p3.add(jlb_gender);
		p3.add(jrb_male);
		p3.add(jrb_female);

		// 2�� ��ư����� ���´�
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb_male);
		bg.add(jrb_female);

		this.add(p3);

		// 4��°��
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jlb_hobby = new JLabel("���:");
		JCheckBox jcb_hobby1 = new JCheckBox("����");
		JCheckBox jcb_hobby2 = new JCheckBox("����");
		JCheckBox jcb_hobby3 = new JCheckBox("��ȭ");
		JCheckBox jcb_hobby4 = new JCheckBox("�");

		p4.add(jlb_hobby);
		p4.add(jcb_hobby1);
		p4.add(jcb_hobby2);
		p4.add(jcb_hobby3);
		p4.add(jcb_hobby4);

		this.add(p4);

		// 5��°��
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jlb_blood = new JLabel("������:");
		String[] blood_array = { "A", "B", "O", "AB" };
		JComboBox jcb_blood = new JComboBox(blood_array);

		p5.add(jlb_blood);
		p5.add(jcb_blood);

		this.add(p5);

		// 6��°�� :
		JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jlb_pwd = new JLabel("��й�ȣ:");
		JPasswordField jpf_pwd = new JPasswordField(10);
		p6.add(jlb_pwd);
		p6.add(jpf_pwd);

		this.add(p6);

		// 7��°��
		JPanel p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton jbt_register = new JButton("�����ϱ�");
		JButton jbt_cancel = new JButton("����ϱ�");

		p7.add(jbt_register);
		p7.add(jbt_cancel);

		this.add(p7);

	}
}
