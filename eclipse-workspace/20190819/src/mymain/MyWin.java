package mymain;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//�ڹٿ��� ������ ����� ����� ��Ű�� 
// java.awt.~ (Abstract Window )
// ����ӹ޾Ƽ� ���� javax.swing.������ü.

public class MyWin extends JFrame {

	public MyWin() {
		// TODO Auto-generated constructor stub

		// dnlsehdn wpahr
		super.setTitle("���� ���� ������â");

		setLayout(null);

		// ��ư ����
		JButton jbt1 = new JButton("Ŭ���غ�����");
		this.add(jbt1);
		// jbt1.setButtons(x,y,width,height);
		jbt1.setBounds(75, 30, 150, 30);

		// �ؽ�Ʈ �ʵ�
		JTextField jtf_name = new JTextField();

		this.add(jtf_name);
		jtf_name.setBounds(75, 70, 150, 30);

		// �޺��ڽ� ����
		JLabel jlb_blood = new JLabel("������");
		this.add(jlb_blood);
		jlb_blood.setBounds(20, 110, 150, 30);

		// �޺��ڽ� // ��� ������ ��
		String[] blood_array = { "A��", "B��", "O��", "AB��" };
		JComboBox jcb_blood = new JComboBox(blood_array);
		this.add(jcb_blood);
		jcb_blood.setBounds(75, 110, 150, 30);

		// ******************

		// ������ġ, ����� ����
		super.setLocation(300, 200);
		// ũ������
		super.setSize(300, 300);
		// ���� �Ұ�
		super.setResizable(false);
		// �������
		super.setVisible(true);
		// X��ư ������ hide�� ����, ������
		// �͹̳ο��� ��� ���ư�������. > �����ڵ带 �����ؾ���.
		// X��ư ������ ������.
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // defalt�� ����

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyWin(); // jframe��ӹ޴� ��ü

	}

}
