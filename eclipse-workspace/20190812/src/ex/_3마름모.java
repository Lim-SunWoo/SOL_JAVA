package ex; //  re

import java.util.Scanner;

public class _3������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--������ ���--");
		int n=0;
		int center = n / 2;
		String yn = "n";
		Scanner scan = new Scanner(System.in);
		//System.out.println("y".toUpperCase());

		do {
			System.out.println("���ϴ� ������ �Է��Ͻʽÿ�.");
			n = scan.nextInt();
			
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					if (i <= center) { // ���
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
			System.out.println("���ҷ�?");
			yn= scan.next();

		} while (yn.equalsIgnoreCase("y")); // ��ҹ��� ���� ���ϰ� ~

		System.out.println("���α׷� ��");
	}
}