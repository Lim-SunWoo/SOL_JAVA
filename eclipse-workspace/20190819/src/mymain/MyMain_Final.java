package mymain;

/*	final ���: 
		�޼ҵ�: ���̻� ������ X
		Ŭ����: ���̻� ������� ���ƶ�.*/

class A{
	public void sub() {
		
	}
	final public void sub1() { // final > ���̻� �� �޼ҵ�� �������̵��� ���� ���ÿ�.
		
	}
}

class B extends A{
	public void sub() {
		// ������. sub�� �����ǰ� �Ұ���.
	}
}

public class MyMain_Final {
	public final static double PI = 3.14;
	
	
	public static void main (String[] args) {
		
	}
}
