package ex;

import java.util.Random;

public class _6�Ϲݳ������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 12;
		if ((n%2==0)&&(n%3==0)) { // 2�� ��� & 3�� ���
			System.out.printf("%d��(��) ¦���̸鼭 3�� ����Դϴ�.\n", n);
		}
		else System.out.println("���ǿ� �������� �ʽ��ϴ�.");

		// ���ⱸ�ϱ� 
		Random rand = new Random();// �����߻���ü

		int year = rand.nextInt(20)+2000; //2000-2019 �⵵
		
		if ((year%400==0)||((year%4==0)&&(year%100!=0)))
			System.out.printf("%d�⵵�� �����Դϴ�.\n", year);
		else System.out.printf("%d�⵵�� ������ �ƴմϴ�.", year);
		
		// ***
		System.out.println("&&�� ||");
		System.out.printf("true && true = %b\n", true&&true);
		System.out.printf("true || false = %b\n", true||false);

	//***
		int kor= rand.nextInt(101);
		String grade= "F";
		
		if (kor>=90&&kor<=100) grade= "A";
		else if (kor>=80&&kor<90) grade= "B";
		else if (kor>=70&&kor<80) grade= "C";

		// A��� üũ 90-100
		System.out.printf("����� ��������%d�� �̹Ƿ� %s�Դϴ�.", kor, grade);
		
		}
}
