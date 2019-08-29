package myutil;

public interface BaseCalc {
	// 내부 구성은 상수 + 추상 메소드만 들어올 수 있음.
	// double PI = 3.14; ->상수가 아니지만 interface안에서는 자동으로 상수 취급.
	public final static double PI = 3.14;

	public abstract int plus(int a, int b);

	int minus(int a, int b); // public abstract을 생략해도 자동으로 인식됨.

	// void sub() {} // -> 추상메소드이면 바디가 잇을 수 없어서 에러.(Abstract methods do not specify
	// a body)

}
