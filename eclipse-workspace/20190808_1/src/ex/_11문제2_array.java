package ex;

import java.util.Calendar;
import java.util.Scanner;

public class _11문제2_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 나이랑 띠 구하기 
		// 자 축 인 묘 진 가 오 미 신 유 술 해
		// 쥐 소 범 토 용 뱀 말 양 원 닭 개 돼
		// 4   5  6   7  8  9  10 11 12 1  2   3
		// 출생 년도를 %12로 나눈다. > 0~11이 나옴.
		
		int year= 1990;
		int age;
		String[] tti = {"닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양","원숭이"};		
		int n_tti;
		
		System.out.println("출생년도를 입력하세요 ex. 1990");
		Scanner scan = new Scanner(System.in);
		
		year= scan.nextInt();
		
		n_tti= year%12;
		// age= 2019-year+1;
		// 시스템 날짜를 구하기:
		Calendar c = Calendar.getInstance();
		int current_year= c.get(Calendar.YEAR);
		age=current_year-year+1;
		
		System.out.printf("당신은 %d살(%d년생)이며 %s띠 입니다.", age, year, tti[n_tti-1]);
	}
}
