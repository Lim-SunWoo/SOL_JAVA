package mymain.input;

import java.io.IOException;
import java.io.InputStream;

public class _1_Keyboard_input {
	public static void main(String [] args) {
		InputStream is = System.in; // 키보드의 장치명
		System.out.println("종료하려면 Ctrl+Z를 누르세요");
		// 컨트롤 in을 눌러보면 
		while(true) {
			try {
				int ch = is.read();
				if (ch==-1) break;
				System.out.printf("%c", ch);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("---END---");

	}

}
