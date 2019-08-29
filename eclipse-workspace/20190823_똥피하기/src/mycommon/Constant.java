package mycommon;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Constant {
	// 게임판의크기

	public static final int GAMEPAN_W = 400;
	public static final int GAMEPAN_H = 600;
	
	public static class Key {
		public static final int NONE = 0;
		public static final int LEFT = 1;
		public static final int RIGHT = 2; // 비트연산 이용
	}

}
