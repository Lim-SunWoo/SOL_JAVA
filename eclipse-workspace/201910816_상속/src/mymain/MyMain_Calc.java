package mymain;

import myutil.AdvancedCalc;
import myutil.BaseCalc;

public class MyMain_Calc {

	static void useBaseCalc(BaseCalc bc) {
		// ���������� �����ؼ� �ѱ�� �Ǹ� ���������� ���ѵǾ �Ѿ.
		// bc.�� hap �� �ȳ���. �����ϰ�
		int x = 10, y = 3, res;

		res = bc.multyply(x, y);

		System.out.printf("-useBaseCalc: %d * %d = %d\n", x, y, res);
	}

	static void useDownCast(Object ob) {

		if (ob instanceof BaseCalc) {
			System.out.println("-ob�� BaseCalc�� �����ϰ� �ִ�. -");
			BaseCalc bc = (BaseCalc) ob;
			int res = bc.divide(10, 3);
			System.out.printf("use Down Cast BaseCalc: 10/3 = %d\n", res);
		}
		
		System.out.println();

		if (ob instanceof AdvancedCalc) {
			System.out.println("ob�� AdvanceCalc�� �����ϰ� �ִ�.");
			AdvancedCalc ac = (AdvancedCalc) ob;
			int res = ac.hap(10);
			System.out.printf("use Down Cast AdvancedCalc: 1~10 hap = %d\n", res);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10, b = 5, res;

		AdvancedCalc ac = new AdvancedCalc();

		// �޼ҵ带 �̿��ؼ� ac�� �ѱ�. ��������� useBaseCalc�� bc=ac
		useBaseCalc(ac);
		System.out.println();
		// ac��� ���������� �ӿ��Ͽ� 1,2,3,�� �Ű������� ��� ����.
		useDownCast(ac);
		System.out.println();

		useDownCast(new Object());
		System.out.println();

		useDownCast(new BaseCalc());
		System.out.println();

		res = ac.plus(a, b);

		System.out.printf("%d + %d = %d\n", a, b, res);

		int x = 2, y = 10;
		double res1 = ac.pow(x, y);
		System.out.printf("%d's %d���� = %.0f\n", x, y, res1);

	}
}
