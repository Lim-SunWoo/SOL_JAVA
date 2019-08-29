package ex;

import java.util.Random;

class _01자동형변환 {
	public static void main (String args[]) {
		int x = 10, y =3 ;
		int res;
		
		res = x+y;
		System.out.printf("%d + %d = %d\n", x, y , res);
		
		res = x-y;
		System.out.printf("%d - %d = %d\n", x, y , res);
		
		res = x/y;
		System.out.printf("%d / %d = %d\n", x, y , res);
		
		res = x%y;
		System.out.printf("%d %% %d = %d\n", x, y , res);
	
		double res1 = 10 / 3.0;
		System.out.println(res1);
		System.out.println((int)res1);
		//*****
		
		int su = 10;
		
		Random rand = new Random(/* 나올 수 있는 경우의 수 */);// 난수발생객체
		
		su = rand.nextInt(3); // 정수 범위 내의 난수 
		
		if (su%2==0) {
			System.out.printf("%d은(는) 짝수\n",su);
		}
		else System.out.printf("%d은(는) 홀수\n", su);

	}
	
}
