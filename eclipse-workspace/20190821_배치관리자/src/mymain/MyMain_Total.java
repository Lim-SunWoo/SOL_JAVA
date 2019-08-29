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
		super("타이틀");// JFrame("타이틀") call

		//메뉴배치
		init_menu();
		
		//중앙에 패널 패치
		centerP = new JPanel();
		this.add(centerP,"Center");
		centerP.setBackground(Color.red);
		
		
		
		//위치
		setLocation(400, 200);
		//크기
		setSize(300, 300);

		//보여줘라
		setVisible(true);

		//종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_menu() {
		// TODO Auto-generated method stub
		//North측에 메뉴배치
		JPanel p = new JPanel();//FlowLayout
		p.setLayout(new GridLayout(1, 3));
		
		p.setBackground(Color.red);
		
		JButton jbt_red 	= new JButton("빨강");
		JButton jbt_green 	= new JButton("초록");
		JButton jbt_blue 	= new JButton("파랑");
		
		//패널에 버튼 3개 넣기
		p.add(jbt_red);
		p.add(jbt_green);
		p.add(jbt_blue);
		
		//화면윗쪽배치
		this.add(p,"North");
		
		//버튼이벤트 처리
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e);
				//방법1)
				//클릭된 버튼 캡션(타이틀) 구하기
				String caption = e.getActionCommand();
				//System.out.println(caption);
				
				if(caption.equals("빨강")) {
					jbt_red.setBackground(Color.red);
				}else if(caption.equals("초록")) {
					jbt_green.setBackground(Color.green);
				}else if(caption.equals("파랑")) {
					jbt_blue.setBackground(Color.blue);
					
				}
				
				
				//방법2)
				//이벤트를 발생시킨 이벤트 소스(Source)(컨트롤)
				Object evt_bt =  e.getSource();
				
				if(evt_bt == jbt_red) {//빨강
					
					centerP.setBackground(Color.red);
					
				}else if(evt_bt==jbt_green) {//초록
					
					centerP.setBackground(Color.green);
					
				}else if(evt_bt==jbt_blue) {//파랑
					
					centerP.setBackground(Color.blue);
				}
				
				
			}
		};
		
		//버튼이벤트 등록
		//이벤트소스:이벤트를 발생시킨 컨트롤
		jbt_red.addActionListener(listener);
		jbt_green.addActionListener(listener);
		jbt_blue.addActionListener(listener);
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_Total();
	}
}
