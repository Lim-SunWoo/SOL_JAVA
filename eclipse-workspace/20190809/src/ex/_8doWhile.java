package ex;  ////// 다시 본 후 문서에 기록

import java.util.Scanner;

public class _8doWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int dan;
		String yn = "y"; // 다시

		do {
			System.out.println("단을 입력하세요");
			dan = scan.nextInt();

			// 유효성 체크
			if (dan <= 0 || dan > 9) {
				System.out.println("2-9사이의 값을 입력해 주십시오.");
				continue; // 현재명령을 중지하고 다음 제어식으로 이동
			}

			// 구구단 출력
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d X %d = %2d\n", dan, i, dan * i);
			}

			System.out.printf("한번 더 하시겠습니까? y/n");
			yn = scan.next();

		} while (yn.equals("y") || yn.equals("Y")); // 입력값이 y면 다시

		System.out.println("---End---");

	}
}