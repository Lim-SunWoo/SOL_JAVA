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
		super("Ÿ��Ʋ"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		// �޴�
		init_menu();

		// ī��Layout�ʱ�ȭ
		init_cardLayout();

		// ��ġ
		setLocation(400, 200);
		// ũ��
		setSize(500, 400);

		// �������
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_cardLayout() {
		// TODO Auto-generated method stub

		card = new CardLayout();

		// �߾ӹ�ġ�� �гλ���+ cardLayout����
		centerP = new JPanel();//
		centerP.setLayout(card);

		this.add(centerP, "Center");

		MyPanel1 mp1 = new MyPanel1();
		MyPanel2 mp2 = new MyPanel2();
		MyPanel3 mp3 = new MyPanel3();

		// centerP�� ����
		// ī���̸�
		centerP.add(mp1, "1");
		centerP.add(mp2, "2");
		centerP.add(mp3, "3");

	}

	private void init_menu() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(1, 3));

		JButton jbt1 = new JButton("������Ʈ�ѿ���");
		JButton jbt2 = new JButton("�α���ȭ��");
		JButton jbt3 = new JButton("3");

		p.add(jbt1);
		p.add(jbt2);
		p.add(jbt3);

		this.add(p, "North");

		// ��ư�̺�Ʈ
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
		// �����츦 �� ������� �� �� �۾��� ȿ�Ｚ�� ���� ���÷��� �����س����� ����.
	}
}
