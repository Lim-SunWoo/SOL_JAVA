// ���� ��ư�� ����� �پ��� ���

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
		super("�� ���� �λ縻"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		setLayout(new GridLayout(3, 2));
		JButton jbt_kor = new JButton("�ѱ��� �λ縻");
		JButton jbt_eng = new JButton("���� �λ縻");
		JButton jbt_jpn = new JButton("�Ϻ��� �λ縻");
		JButton jbt_chn = new JButton("�߱��� �λ縻");
		JButton jbt_frn = new JButton("������ �λ縻");
		JButton jbt_ind = new JButton("�ε� �λ縻");

		this.add(jbt_kor); // this�� ������
		this.add(jbt_eng);
		this.add(jbt_jpn);
		this.add(jbt_chn);
		this.add(jbt_frn);
		this.add(jbt_ind);

		// �� ��ư �̺�Ʈ ó��
		// �ѱ� ����
		class MyButtonEventListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�ѱ��� �λ� �˷���!");
				JOptionPane.showMessageDialog(HelloWin.this, "�ѱ��� �λ�� '�ȳ��ϼ���'�Դϴ�.");
			}
		}

		// ���� �͸�ü
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���� �λ� �˷���!");
				JOptionPane.showMessageDialog(HelloWin.this, "���� �λ�� 'HELLO'�Դϴ�.");
			}
		};
		jbt_eng.addActionListener(listener);

		// �Ϻ��� �͸��� Ŭ����
		jbt_jpn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�Ϻ��� �λ� �˷���!");
				JOptionPane.showMessageDialog(HelloWin.this, "�Ϻ��� �λ�� '���Ϫ誦�������ު�'�Դϴ�.");
			}
		});

		// �߱���
		jbt_chn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�߱��� �λ� �˷���!");
				JOptionPane.showMessageDialog(HelloWin.this, "�߱��� �λ�� '���Ͽ�'�Դϴ�.");
			}
		});

		// ������
		jbt_frn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("������ �λ� �˷���!");
				JOptionPane.showMessageDialog(HelloWin.this, "������ �λ�� 'Bonjour'�Դϴ�.");
			}
		});

		
		// -----------
		ActionListener actionListener = new MyButtonEventListener();
		jbt_kor.addActionListener(actionListener); // ó����ü / A.�� ������ ()���� ó���� �����Ѵ�.

		// ��ġ�� ������
		super.setLocation(400, 200);
		setSize(300, 300);

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new HelloWin();
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}
}