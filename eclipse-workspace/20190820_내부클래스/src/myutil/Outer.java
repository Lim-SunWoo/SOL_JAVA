package myutil;

public class Outer {
	private int a = 1;

	class Inner1 { // ����ν��� ���� Ŭ����: Outer$Inner
		void sub() {
			a = 10;
		}
	}

	public Outer() {
		class Inner2 { // Local ���� Ŭ����
			void sub2() {
				a = 20;
			}
		}
	}
	
}
