package myutil;

interface Inter {
	void sub();
}

abstract class AbsTest {
	public abstract void sub1();
} // inter �� AbsTest�� ������ : ��üX

public class Outer2 {

	/*
	 * class interImpl implements inter1{ //�̷��� �ϸ� inter��ü ������ ����. }
	 */
	// �͸� ���� Ŭ����
	public Outer2() {
		// 1ȸ����ü
		class InterImpl implements Inter {

			@Override
			public void sub() {
				// TODO Auto-generated method stub

			}
		}
		Inter inter = new InterImpl();

		// �͸�ü ����(Anonymous)
		Inter inter1 = new Inter() { // ��ü ������ ���ÿ� ������

			@Override
			public void sub() {
				// TODO Auto-generated method stub

			}
		};
		AbsTest test0 = new MyAbsTest();

		// -------�߻�Ŭ���� �͸�ü��...
		AbsTest test = new AbsTest() {

			@Override
			public void sub1() {
				// TODO Auto-generated method stub

			}
		};

	}
}
