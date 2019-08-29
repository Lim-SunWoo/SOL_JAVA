package mymain;

/*	final 상수: 
		메소드: 더이상 재정의 X
		클래스: 더이상 상속하지 말아라.*/

class A{
	public void sub() {
		
	}
	final public void sub1() { // final > 더이상 이 메소드로 오버라이딩을 하지 마시오.
		
	}
}

class B extends A{
	public void sub() {
		// 재정의. sub은 재정의가 불가함.
	}
}

public class MyMain_Final {
	public final static double PI = 3.14;
	
	
	public static void main (String[] args) {
		
	}
}
