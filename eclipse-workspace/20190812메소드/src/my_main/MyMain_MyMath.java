package my_main;

import my_util.MyMath;

public class MyMain_MyMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x= 5, y= 5;
		int res = MyMath.max(x, y);
		System.out.printf("%d와 %d중에 큰 수는 %d입니다.\n",x, y, res);
		
	//	System.out.printf("%d까지의 수중 %d의 배수의 합은 %d입니다.",x, y, MyMath.hap(x,y));
		
		System.out.printf("%d까지의 수중 소수의 합은 %d입니다.\n",x, MyMath.hap_sosu(x));

		
	}

}
