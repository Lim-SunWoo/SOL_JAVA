package mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import mycommon.Constant;

public class Me {
	Rectangle pos = new Rectangle();
	int speed = 5;

	public Me() {
		pos.x = Constant.GAMEPAN_W / 2 - 40 / 2;
		pos.y = Constant.GAMEPAN_H - 65;
		pos.width = 40;
		pos.height = 60;

	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(pos.x, pos.y, pos.width, pos.height);
	}

	public void move_right() {
		pos.x += speed;
	}

	public void move_left() {
		pos.x -= speed;
	}

	public void move(int key_state) {
		// TODO Auto-generated method stub
		if (key_state == Constant.Key.LEFT) {
			move_left();
		} else if (key_state == Constant.Key.RIGHT) {
			move_right();
		}
	}
}
