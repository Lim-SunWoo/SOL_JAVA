package mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mycommon.Constant;

public class DungManager {

	// 생성간격
	public static final int DUNG_INTERVAL = 10;// 생성간격을 상수로 만들어 놓은 것
	int dung_interval = DUNG_INTERVAL;

	List<Dung> dung_list = new ArrayList<Dung>();

	Random rand = new Random();
	Color[] colors = { Color.red, Color.green, Color.blue, Color.yellow, Color.cyan };

	public void make_dung() {

		if (dung_interval == DUNG_INTERVAL) {
			Dung dung = new Dung();
			dung.pos.x = rand.nextInt(Constant.GAMEPAN_W) - Dung.DUNG_W / 2;// -25 ~375
			dung.pos.y = -Dung.DUNG_H;
			dung.pos.width = Dung.DUNG_W;
			dung.pos.height = Dung.DUNG_H;

			// 색상
			int index = rand.nextInt(colors.length);
			dung.color = colors[index];

			// 속도
			dung.speed = rand.nextInt(3) + 2; // 2 ~ 4

			// ArrayList추가
			dung_list.add(dung);
		}

		dung_interval--;
	}

	/*
	 * public void draw_all(Graphics g) { for (int i = 0; i < dung_list.size(); i++)
	 * { Dung dung = dung_list.get(i);
	 * 
	 * // 화면아래로 내려감 if (dung.move() == true) { // 현재 dung 제거 dung_list.remove(dung);
	 * // return; } }
	 */

	public void draw_all(Graphics g) {
		for (Dung dung : dung_list) {
			dung.draw(g);
		}
	}

	public void move_all() {

		for (int i = 0; i < dung_list.size(); i++) {
			Dung dung = dung_list.get(i);

			// 화면아래로 내려감
			if (dung.move() == true) {
				// 현재 dung 제거
				dung_list.remove(dung);
				// return;
			}
		}
	}
}
