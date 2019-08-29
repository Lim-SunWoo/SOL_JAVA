package mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import mycommon.Constant;

public class Dung {
	// 떨어지기 위해서 필요한 것: 크기와 좌표

	public static final int DUNG_W = 50;
	public static final int DUNG_H = 20;

	// 사각좌표 정보를 관리하는 객체
	// x,y,width,heigh
	Rectangle pos = new Rectangle();// 사각형의 좌표관리 객체
	// 퍼블릭을 안써도 됨. 9동일한 패키지
	//
	// x.y,W.H .한 점과 폭, 높이
	Color color;//
	int speed;// 이동속도

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(pos.x, pos.y, pos.width, pos.height);
	}

	public boolean move() {

		pos.y += speed;

		return (pos.y > Constant.GAMEPAN_H);// 화면아래로 내려갔으면
	}

}
