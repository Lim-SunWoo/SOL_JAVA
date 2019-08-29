package mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import mycommon.Constant;

public class Dung {
	// �������� ���ؼ� �ʿ��� ��: ũ��� ��ǥ

	public static final int DUNG_W = 50;
	public static final int DUNG_H = 20;

	// �簢��ǥ ������ �����ϴ� ��ü
	// x,y,width,heigh
	Rectangle pos = new Rectangle();// �簢���� ��ǥ���� ��ü
	// �ۺ��� �Ƚᵵ ��. 9������ ��Ű��
	//
	// x.y,W.H .�� ���� ��, ����
	Color color;//
	int speed;// �̵��ӵ�

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(pos.x, pos.y, pos.width, pos.height);
	}

	public boolean move() {

		pos.y += speed;

		return (pos.y > Constant.GAMEPAN_H);// ȭ��Ʒ��� ����������
	}

}
