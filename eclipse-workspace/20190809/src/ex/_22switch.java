package ex;

import java.util.Scanner;

public class _22switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor = 80;
		String grade = "F";
		
		Scanner scan = new Scanner(System.in);
		System.out.print("국어: ");
		kor = scan.nextInt();
/*		if (kor >=0 && kor <=100) {
			switch(kor/10) {
			case 10:
			case 9: grade = "A"; break;
			case 8: grade = "B"; break;
			case 7: grade = "C"; break;
			case 6: grade = "D"; break;*/
			if (kor >=0 && kor <=100) {
				switch(kor/5) {
				case 20:
				case 19: grade = "A+"; break;
				case 18: grade = "A"; break;
				case 17: grade = "B+"; break;
				case 16: grade = "B"; break;
				case 15: grade = "C+"; break;
				case 14: grade = "C"; break;
				case 13: grade = "D+"; break;
				case 12: grade = "D"; break;
			}
			System.out.printf(" 등급: %s", grade);
		}
		else System.out.println("1-100사이의 점수를 입력해 주십시오.");
	}
}
