package ex;

import java.util.Scanner;

public class _12����3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 60*120
		// 40*200
		
		Scanner scan = new Scanner(System.in);
		System.out.println("�ݾ�: ");
		int money, m_50000, m_10000, m_5000, m_1000, m_500, m_100, m_50, m_10;
		
		money = scan.nextInt();
		
		m_50000= money/50000;
		money= money%50000;
		
		m_10000= money/10000;
		money= money%10000;
		
		m_5000= money/5000;
		money= money%5000;
		
		m_1000= money/1000;
		money= money%1000;
		
		m_500= money/500;
		money= money%500;
		
		m_100= money/100;
		money= money%100;
		
		m_50= money/50;
		money= money%50;
		
		m_10= money/10;
		money= money%10;
		
		System.out.printf("�ʿ��� ������ ���� \n������ %d��, ���� %d�� \n��õ�� %d��, õ�� %d�� \n����� %d��, ��� %d�� \n���ʿ� %d��, �ʿ� %d�� �Դϴ�.", m_50000, m_10000, m_5000, m_1000, m_500, m_100, m_50, m_10);
		

	}

}
