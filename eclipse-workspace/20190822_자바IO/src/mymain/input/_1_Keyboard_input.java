package mymain.input;

import java.io.IOException;
import java.io.InputStream;

public class _1_Keyboard_input {
	public static void main(String [] args) {
		InputStream is = System.in; // Ű������ ��ġ��
		System.out.println("�����Ϸ��� Ctrl+Z�� ��������");
		// ��Ʈ�� in�� �������� 
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
