package myutil;

public class Outer {
	private int a = 1;

	class Inner1 { // 멤버로써의 내부 클래스: Outer$Inner
		void sub() {
			a = 10;
		}
	}

	public Outer() {
		class Inner2 { // Local 내부 클래스
			void sub2() {
				a = 20;
			}
		}
	}
	
}
