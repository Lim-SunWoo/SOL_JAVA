package ex;

import java.util.Scanner;

public class _11����2_switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���̶� �� ���ϱ� 
		// �� �� �� �� �� �� �� �� �� �� �� ��
		// �� �� �� �� �� �� �� �� �� �� �� ��
		// 4   5  6   7  8  9  10 11 12 1  2   3
		// ��� �⵵�� %12�� ������. > 0~11�� ����.
		
		int year= 1990;
		int age;
		
		String tti;
		int n_tti;
		
		System.out.println("����⵵�� �Է��ϼ��� ex. 1990");
		Scanner scan = new Scanner(System.in);
		
		year= scan.nextInt();
		
		n_tti= year%12;
		age= 2019-year+1;
		

		switch (n_tti){
		case 4:
			tti= "���";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);
			break;
		case 5:
			tti= "�Ҷ�";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);
			break;
		case 6:
			tti= "ȣ���̶�";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);
			break;
		case 7:
			tti= "�䳢��";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);
			break;
		case 8:
			tti= "���";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);
			break;
		case 9:
			tti= "���";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);
			break;
		case 10:
			tti= "����";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);
			break;
		case 11:
			tti= "���";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);
			break;
		case 12:
			tti= "�����̶�";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);
			break;
		case 1:
			tti= "�߶�";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);
			break;
		case 2:
			tti= "����";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);

			break;
		case 3:
			tti= "������";
			System.out.printf("����� %d����̹Ƿ� %d���̰�  %s �Դϴ�.", year, age, tti);

			break;
		}

	}
}
