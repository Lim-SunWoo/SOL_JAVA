package mymain;

import java.util.Scanner;

import myutil.Lotto;

public class MyMain_Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String yn = "Y";

		int[] user_no = new int[6]; // ���� ��ȣ

		Lotto lotto = new Lotto();
		// ��÷��ȣ�� �̸� 
		lotto.make_win_no();
		
		while (true) {

			System.out.print("6�ڸ� ��ȣ�� �Է��ϼ��� >> "); // ���� �����̽� �� ����
			for (int i = 0; i < 6; i++) {
				user_no[i] = scan.nextInt();
			}

			// �ζ� ��ȣ ���纸��
			lotto.setUser_no(user_no);
			lotto.display(); // ��÷���
			
			
			scan.next(); // ���� ���ſ�
			// �ٽ� �Ұ��ΰ�
			System.out.println("���ҷ�?");
			yn = scan.next();

			if (yn.equalsIgnoreCase("Y") == false)
				break; // (!="Y"�� ����)
		} // end while
		System.out.println("���α׷��� ����Ǿ����ϴ�.");

	}

}
