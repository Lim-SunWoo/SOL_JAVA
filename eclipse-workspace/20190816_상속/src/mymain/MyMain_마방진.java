package mymain;

import java.util.Scanner;

import myutil.MabangJin;

public class MyMain_������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int chasu;
		Scanner scan = new Scanner(System.in);
		MabangJin mabang = new MabangJin();

		String yn = "Y";

		while (true) {
			System.out.println("����: ");
			chasu = scan.nextInt();
			if (chasu % 2 == 0) {
				System.out.println("Ȧ���� �Է��ϼ���.");
				continue;
			}
			// ������ ���� �� ���
			mabang.setChasu(chasu);
			mabang.display();
			
			
			// ����
			System.out.println("���ҷ�? Y/N");
			yn = scan.next();
			if (!yn.equalsIgnoreCase("Y"))
				break;

		} // end While
		System.out.println("--End--");

	}

}
