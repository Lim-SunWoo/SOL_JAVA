package mymain;

import java.awt.Frame;
import javax.swing.JFrame;

//�ڹٿ��� ������ ����� ����� ��Ű�� 
// java.awt.~ (Abstract Window )
// ����ӹ޾Ƽ� ���� javax.swing.������ü.

public class MyWin extends JFrame {

	public MyWin() {
		// TODO Auto-generated constructor stub

		// dnlsehdn wpahr
		super.setTitle("���� ���� ������â");
		// 
		
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
