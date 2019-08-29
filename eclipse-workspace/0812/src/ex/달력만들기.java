package ex;

import java.util.Scanner;

import myUtil.MyUtil;

public class 달력만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year, month;
		Scanner scan = new Scanner(System.in);

		String yn = "y";

		while (true) {

			System.out.print("년 / 월: ");
			year = scan.nextInt();
			month = scan.nextInt();

			// 달력 만들기, 출력
			MyUtil.make_calendar(year, month);

			// 또할래?
			System.out.print("또? Y/N:");
			yn = scan.next();

			if (!yn.equalsIgnoreCase("Y"))
				break;

		}

		System.out.println("---END---");

	}

}