package ex;

import java.util.Random;

public class _6일반논리연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 12;
		if ((n%2==0)&&(n%3==0)) { // 2의 배수 & 3의 배수
			System.out.printf("%d은(는) 짝수이면서 3의 배수입니다.\n", n);
		}
		else System.out.println("조건에 만족하지 않습니다.");

		// 윤년구하기 
		Random rand = new Random();// 난수발생객체

		int year = rand.nextInt(20)+2000; //2000-2019 년도
		
		if ((year%400==0)||((year%4==0)&&(year%100!=0)))
			System.out.printf("%d년도는 윤년입니다.\n", year);
		else System.out.printf("%d년도는 윤년이 아닙니다.", year);
		
		// ***
		System.out.println("&&와 ||");
		System.out.printf("true && true = %b\n", true&&true);
		System.out.printf("true || false = %b\n", true||false);

	//***
		int kor= rand.nextInt(101);
		String grade= "F";
		
		if (kor>=90&&kor<=100) grade= "A";
		else if (kor>=80&&kor<90) grade= "B";
		else if (kor>=70&&kor<80) grade= "C";

		// A등급 체크 90-100
		System.out.printf("당신의 국어등급은%d점 이므로 %s입니다.", kor, grade);
		
		}
}
