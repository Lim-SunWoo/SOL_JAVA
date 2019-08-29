package ex;

import java.io.IOException;

public class _7while {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int count = 0;
		int white = 0;

		System.out.println("종료하려면 Ctrl_Z를 누르세요!");
		System.out.println("아무거나 입력");

		while (true) {
			int ch = System.in.read();
			if (ch == -1)
				break;

			System.out.printf("%c", ch);

			if (ch == 0 || ch == 9 || ch == 10 || ch == 13) { // \0 \t \n \r
				white++; // 여기 조건에 전체 ! 가능
			}
			count++;
			// 여기섯 else 주고 else에서만 카운트하는 방법도 있음.

		}
		count = count - white;
		System.out.printf("글자 수 > %d\n", count);
		System.out.println("----END----");
	}

	// 눈에 보이는 문자 수만 세는 것 -> count로는 불가능
	// 눈에 안보이는 화이트 문자: \n \r \t
	// 눈에 보이는 문자 수만 출력하기 위해서는 화이트 문자가 아니몀ㄴ 카운트하는 방법을 쓴다.

}
