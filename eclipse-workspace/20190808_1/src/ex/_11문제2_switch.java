package ex;

import java.util.Scanner;

public class _11문제2_switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 나이랑 띠 구하기 
		// 자 축 인 묘 진 가 오 미 신 유 술 해
		// 쥐 소 범 토 용 뱀 말 양 원 닭 개 돼
		// 4   5  6   7  8  9  10 11 12 1  2   3
		// 출생 년도를 %12로 나눈다. > 0~11이 나옴.
		
		int year= 1990;
		int age;
		
		String tti;
		int n_tti;
		
		System.out.println("출생년도를 입력하세요 ex. 1990");
		Scanner scan = new Scanner(System.in);
		
		year= scan.nextInt();
		
		n_tti= year%12;
		age= 2019-year+1;
		

		switch (n_tti){
		case 4:
			tti= "쥐띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);
			break;
		case 5:
			tti= "소띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);
			break;
		case 6:
			tti= "호랑이띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);
			break;
		case 7:
			tti= "토끼띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);
			break;
		case 8:
			tti= "용띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);
			break;
		case 9:
			tti= "뱀띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);
			break;
		case 10:
			tti= "말띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);
			break;
		case 11:
			tti= "양띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);
			break;
		case 12:
			tti= "원숭이띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);
			break;
		case 1:
			tti= "닭띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);
			break;
		case 2:
			tti= "개띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);

			break;
		case 3:
			tti= "돼지띠";
			System.out.printf("당신은 %d년생이므로 %d살이고  %s 입니다.", year, age, tti);

			break;
		}

	}
}
