package myutil;

public class BaseCalc { // extends Object ���� �����Ǿ�����.
	// �ڹ��� ��� Ŭ������ objesct�� ��ӹ���.

	public int plus(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}

	public int multyply(int a, int b) {
		return a * b;
	}
	
	public double multyply(double a, double b) {
		return a * b;
	}


	public int divide(int a, int b) {
		return a / b;
	}

	/*
	 * public int plus(int a, int b) { return b == 0 ? 0 : a / b; }
	 */

}
