package mymain;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMain_Total extends JFrame {

	JPanel centerP;
	
	public MyMain_Total() {
		// TODO Auto-generated constructor stub
		super("Ÿ��Ʋ");// JFrame("Ÿ��Ʋ") call

		//�޴���ġ
		init_menu();
		
		//�߾ӿ� �г� ��ġ
		centerP = new JPanel();
		this.add(centerP,"Center");
		centerP.setBackground(Color.red);
		
		
		
		//��ġ
		setLocation(400, 200);
		//ũ��
		setSize(300, 300);

		//�������
		setVisible(true);

		//����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_menu() {
		// TODO Auto-generated method stub
		//North���� �޴���ġ
		JPanel p = new JPanel();//FlowLayout
		p.setLayout(new GridLayout(1, 3));
		
		p.setBackground(Color.red);
		
		JButton jbt_red 	= new JButton("����");
		JButton jbt_green 	= new JButton("�ʷ�");
		JButton jbt_blue 	= new JButton("�Ķ�");
		
		//�гο� ��ư 3�� �ֱ�
		p.add(jbt_red);
		p.add(jbt_green);
		p.add(jbt_blue);
		
		//ȭ�����ʹ�ġ
		this.add(p,"North");
		
		//��ư�̺�Ʈ ó��
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e);
				//���1)
				//Ŭ���� ��ư ĸ��(Ÿ��Ʋ) ���ϱ�
				String caption = e.getActionCommand();
				//System.out.println(caption);
				
				if(caption.equals("����")) {
					jbt_red.setBackground(Color.red);
				}else if(caption.equals("�ʷ�")) {
					jbt_green.setBackground(Color.green);
				}else if(caption.equals("�Ķ�")) {
					jbt_blue.setBackground(Color.blue);
					
				}
				
				
				//���2)
				//�̺�Ʈ�� �߻���Ų �̺�Ʈ �ҽ�(Source)(��Ʈ��)
				Object evt_bt =  e.getSource();
				
				if(evt_bt == jbt_red) {//����
					
					centerP.setBackground(Color.red);
					
				}else if(evt_bt==jbt_green) {//�ʷ�
					
					centerP.setBackground(Color.green);
					
				}else if(evt_bt==jbt_blue) {//�Ķ�
					
					centerP.setBackground(Color.blue);
				}
				
				
			}
		};
		
		//��ư�̺�Ʈ ���
		//�̺�Ʈ�ҽ�:�̺�Ʈ�� �߻���Ų ��Ʈ��
		jbt_red.addActionListener(listener);
		jbt_green.addActionListener(listener);
		jbt_blue.addActionListener(listener);
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_Total();
	}
}
