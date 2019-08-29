package mymain;

import java.util.Scanner;

import myutil.MabangJin;

public class MyMain_마방진 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int chasu;
		Scanner scan = new Scanner(System.in);
		MabangJin mabang = new MabangJin();

		String yn = "Y";

		while (true) {
			System.out.println("차수: ");
			chasu = scan.nextInt();
			if (chasu % 2 == 0) {
				System.out.println("홀수만 입력하세요.");
				continue;
			}
			// 마방진 생성 및 출력
			mabang.setChasu(chasu);
			mabang.display();
			
			
			// 질문
			System.out.println("또할래? Y/N");
			yn = scan.next();
			if (!yn.equalsIgnoreCase("Y"))
				break;

		} // end While
		System.out.println("--End--");

	}

}
