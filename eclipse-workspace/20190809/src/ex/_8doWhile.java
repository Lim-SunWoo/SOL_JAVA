package ex;  ////// �ٽ� �� �� ������ ���

import java.util.Scanner;

public class _8doWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int dan;
		String yn = "y"; // �ٽ�

		do {
			System.out.println("���� �Է��ϼ���");
			dan = scan.nextInt();

			// ��ȿ�� üũ
			if (dan <= 0 || dan > 9) {
				System.out.println("2-9������ ���� �Է��� �ֽʽÿ�.");
				continue; // �������� �����ϰ� ���� ��������� �̵�
			}

			// ������ ���
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d X %d = %2d\n", dan, i, dan * i);
			}

			System.out.printf("�ѹ� �� �Ͻðڽ��ϱ�? y/n");
			yn = scan.next();

		} while (yn.equals("y") || yn.equals("Y")); // �Է°��� y�� �ٽ�

		System.out.println("---End---");

	}
}