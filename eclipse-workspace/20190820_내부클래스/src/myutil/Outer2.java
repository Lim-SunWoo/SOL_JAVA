package myutil;

interface Inter {
	void sub();
}

abstract class AbsTest {
	public abstract void sub1();
} // inter 와 AbsTest의 공통점 : 객체X

public class Outer2 {

	/*
	 * class interImpl implements inter1{ //이렇게 하면 inter객체 생성이 가능. }
	 */
	// 익명 내부 클래스
	public Outer2() {
		// 1회성객체
		class InterImpl implements Inter {

			@Override
			public void sub() {
				// TODO Auto-generated method stub

			}
		}
		Inter inter = new InterImpl();

		// 익명객체 생성(Anonymous)
		Inter inter1 = new Inter() { // 객체 생성과 동시에 재정의

			@Override
			public void sub() {
				// TODO Auto-generated method stub

			}
		};
		AbsTest test0 = new MyAbsTest();

		// -------추상클래스 익명객체로...
		AbsTest test = new AbsTest() {

			@Override
			public void sub1() {
				// TODO Auto-generated method stub

			}
		};

	}
}
