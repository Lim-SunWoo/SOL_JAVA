package ex;

import java.util.Scanner;

public class _12문제3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 60*120
		// 40*200
		
		Scanner scan = new Scanner(System.in);
		System.out.println("금액: ");
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
		
		System.out.printf("필요한 지폐의 수는 \n오만원 %d장, 만원 %d장 \n오천원 %d장, 천원 %d장 \n오백원 %d개, 백원 %d개 \n오십원 %d개, 십원 %d개 입니다.", m_50000, m_10000, m_5000, m_1000, m_500, m_100, m_50, m_10);
		

	}

}
