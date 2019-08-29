package mymain;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class testwin extends JFrame {

	public testwin() {
		super("타이틀"); // JFrame("타이틀") 호출과 같은 기능을 함.

		// 위치와 사이즈
		super.setLocation(400, 200);
		setSize(300, 300);

		// 보이기
		setVisible(true);

		// 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 윈도우 이벤트 등록 
		// this 이벤트 소스
		// 처리객체:: 발생된 이벤트를 처리할 객체
		// Delegation Model 위임 이벤트 모델 
		// MyWindowEventListener listener = new MyWindowEventListener(); // ~가 윈도우 이벤트를 받을 수 있도록 준비해야함.
		/*ㄴ로 사용가능*/ WindowListener listener = new MyWindowEventListener();
		this.addWindowListener(listener); // 이벤트 주체 / 처리객체
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	}

}

/*
 * 이벤트의 발생: 운영체제가 제일 먼저 감지 
 * 이벤트 > OS감지 > JVM이 가져옴 > 처리
 * 이벤트 발생 > 처리할 객체를 만듬 > 처리
 * 
 */