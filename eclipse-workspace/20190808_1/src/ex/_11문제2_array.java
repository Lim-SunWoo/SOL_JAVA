package ex;

import java.util.Calendar;
import java.util.Scanner;

public class _11����2_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���̶� �� ���ϱ� 
		// �� �� �� �� �� �� �� �� �� �� �� ��
		// �� �� �� �� �� �� �� �� �� �� �� ��
		// 4   5  6   7  8  9  10 11 12 1  2   3
		// ��� �⵵�� %12�� ������. > 0~11�� ����.
		
		int year= 1990;
		int age;
		String[] tti = {"��","��","����","��","��","ȣ����","�䳢","��","��","��","��","������"};		
		int n_tti;
		
		System.out.println("����⵵�� �Է��ϼ��� ex. 1990");
		Scanner scan = new Scanner(System.in);
		
		year= scan.nextInt();
		
		n_tti= year%12;
		// age= 2019-year+1;
		// �ý��� ��¥�� ���ϱ�:
		Calendar c = Calendar.getInstance();
		int current_year= c.get(Calendar.YEAR);
		age=current_year-year+1;
		
		System.out.printf("����� %d��(%d���)�̸� %s�� �Դϴ�.", age, year, tti[n_tti-1]);
	}
}
