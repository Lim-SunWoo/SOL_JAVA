package ex; //  re

import java.util.Scanner;

public class _3마름모 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--마름모 찍기--");
		int n=0;
		int center = n / 2;
		String yn = "n";
		Scanner scan = new Scanner(System.in);
		//System.out.println("y".toUpperCase());

		do {
			System.out.println("원하는 차수를 입력하십시오.");
			n = scan.nextInt();
			
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					if (i <= center) { // 상단
						if (k >= center - i && k <= center + i) {
							System.out.print("*");
						} else
							System.out.print("-");
					}else {
						int a=n-i-1;
						if(k>=center-a&&k<=center+a) System.out.print("*");
						else System.out.print("-");
					}
				}
				System.out.println();

			}
			System.out.println("또할래?");
			yn= scan.next();

		} while (yn.equalsIgnoreCase("y")); // 대소문자 구분 안하고 ~

		System.out.println("프로그램 끝");
	}
}