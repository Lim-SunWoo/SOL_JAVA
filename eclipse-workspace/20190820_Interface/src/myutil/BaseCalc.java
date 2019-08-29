package myutil;

public interface BaseCalc {
	// ���� ������ ��� + �߻� �޼ҵ常 ���� �� ����.
	// double PI = 3.14; ->����� �ƴ����� interface�ȿ����� �ڵ����� ��� ���.
	public final static double PI = 3.14;

	public abstract int plus(int a, int b);

	int minus(int a, int b); // public abstract�� �����ص� �ڵ����� �νĵ�.

	// void sub() {} // -> �߻�޼ҵ��̸� �ٵ� ���� �� ��� ����.(Abstract methods do not specify
	// a body)

}
