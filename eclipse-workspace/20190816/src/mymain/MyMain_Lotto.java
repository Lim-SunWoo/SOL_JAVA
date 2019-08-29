package mymain;

import java.util.Scanner;

import myutil.Lotto;

public class MyMain_Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String yn = "Y";

		int[] user_no = new int[6]; // 찍은 번호

		Lotto lotto = new Lotto();
		// 추첨번호를 미리 
		lotto.make_win_no();
		
		while (true) {

			System.out.print("6자리 번호를 입력하세요 >> "); // 엔터 스페이스 다 가능
			for (int i = 0; i < 6; i++) {
				user_no[i] = scan.nextInt();
			}

			// 로또 번호 맞춰보기
			lotto.setUser_no(user_no);
			lotto.display(); // 당첨결과
			
			
			scan.next(); // 오류 제거용
			// 다시 할것인가
			System.out.println("또할래?");
			yn = scan.next();

			if (yn.equalsIgnoreCase("Y") == false)
				break; // (!="Y"와 동일)
		} // end while
		System.out.println("프로그램이 종료되었습니다.");

	}

}
