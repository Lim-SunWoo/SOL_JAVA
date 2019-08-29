package myutil;

public class BaseCalc { // extends Object 보통 생략되어있음.
	// 자바의 모든 클래스는 objesct를 상속받음.

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
