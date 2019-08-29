package mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mycommon.Constant;

public class DungManager {

	// ��������
	public static final int DUNG_INTERVAL = 10;// ���������� ����� ����� ���� ��
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

			// ����
			int index = rand.nextInt(colors.length);
			dung.color = colors[index];

			// �ӵ�
			dung.speed = rand.nextInt(3) + 2; // 2 ~ 4

			// ArrayList�߰�
			dung_list.add(dung);
		}

		dung_interval--;
	}

	/*
	 * public void draw_all(Graphics g) { for (int i = 0; i < dung_list.size(); i++)
	 * { Dung dung = dung_list.get(i);
	 * 
	 * // ȭ��Ʒ��� ������ if (dung.move() == true) { // ���� dung ���� dung_list.remove(dung);
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

			// ȭ��Ʒ��� ������
			if (dung.move() == true) {
				// ���� dung ����
				dung_list.remove(dung);
				// return;
			}
		}
	}
}
