package ex;

import java.util.Scanner;

import myUtil.MyUtil;

public class �޷¸���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year, month;
		Scanner scan = new Scanner(System.in);

		String yn = "y";

		while (true) {

			System.out.print("�� / ��: ");
			year = scan.nextInt();
			month = scan.nextInt();

			// �޷� �����, ���
			MyUtil.make_calendar(year, month);

			// ���ҷ�?
			System.out.print("��? Y/N:");
			yn = scan.next();

			if (!yn.equalsIgnoreCase("Y"))
				break;

		}

		System.out.println("---END---");

	}

}