package ex;

import java.util.Random;

class _01�ڵ�����ȯ {
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
		
		Random rand = new Random(/* ���� �� �ִ� ����� �� */);// �����߻���ü
		
		su = rand.nextInt(3); // ���� ���� ���� ���� 
		
		if (su%2==0) {
			System.out.printf("%d��(��) ¦��\n",su);
		}
		else System.out.printf("%d��(��) Ȧ��\n", su);

	}
	
}
