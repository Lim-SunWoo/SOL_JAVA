package my_main;

import my_util.MyMath;

public class MyMain_MyMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x= 5, y= 5;
		int res = MyMath.max(x, y);
		System.out.printf("%d�� %d�߿� ū ���� %d�Դϴ�.\n",x, y, res);
		
	//	System.out.printf("%d������ ���� %d�� ����� ���� %d�Դϴ�.",x, y, MyMath.hap(x,y));
		
		System.out.printf("%d������ ���� �Ҽ��� ���� %d�Դϴ�.\n",x, MyMath.hap_sosu(x));

		
	}

}
