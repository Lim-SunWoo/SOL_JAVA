package mymain;

import myutil.BaseCalc;
import myutil.BaseCalcImpl;

public class myMain_BaseCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ���� ���� = new ����();
		// interface ���� = new class()
		// BaseCalc calc = new BaseCalcImpl();
		// BaseCalc calc = new BaseCalcFactory().createBaseCalc(); // // ���丮����
		// ������ ����� ���忡�� ��ǰ�� ������.
		// ��ǰ �ϳ� �� �����ϳ��� �ƴ� ���� �ϳ��� ���� ��ǰ�� ��� �����ϱ� ���� �۾�.
		BaseCalc calc = new BaseCalcFactory().getInstance().createBaseCalc(); // �̱�������: ��ü�� �ϳ��� ������ �� ���
		// �޼ҵ� ü�̴� ���

		/*
		 * ����������: 1. ���丮 ����: �ش� ��ü�� ���������� �����ϴ� Ŭ������ �����. 2. �̱��� ����: ���� ��ü �ϳ��� �����ؼ�
		 * �����.
		 */

		/*
		 * ^�������� ���� �� BaseCalcFactory factory = new BaseCalcFactory().getInstance();
		 * BaseCalc calc = factory.createBaseCalc();
		 */

		int a = 10, b = 5, res;
		res = calc.plus(a, b);
		System.out.printf("%d + %d = %d\n", a, b, res);
		res = calc.minus(a, b);
		System.out.printf("%d - %d = %d\n", a, b, res);

	}

}
