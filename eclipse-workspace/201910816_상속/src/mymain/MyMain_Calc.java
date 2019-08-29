package mymain;

import myutil.AdvancedCalc;
import myutil.BaseCalc;

public class MyMain_Calc {

	static void useBaseCalc(BaseCalc bc) {
		// 참조변수를 제한해서 넘기게 되면 참조변수가 제한되어서 넘어감.
		// bc.찍어도 hap 은 안나옴. 순수하게
		int x = 10, y = 3, res;

		res = bc.multyply(x, y);

		System.out.printf("-useBaseCalc: %d * %d = %d\n", x, y, res);
	}

	static void useDownCast(Object ob) {

		if (ob instanceof BaseCalc) {
			System.out.println("-ob는 BaseCalc를 포함하고 있다. -");
			BaseCalc bc = (BaseCalc) ob;
			int res = bc.divide(10, 3);
			System.out.printf("use Down Cast BaseCalc: 10/3 = %d\n", res);
		}
		
		System.out.println();

		if (ob instanceof AdvancedCalc) {
			System.out.println("ob는 AdvanceCalc를 포함하고 있다.");
			AdvancedCalc ac = (AdvancedCalc) ob;
			int res = ac.hap(10);
			System.out.printf("use Down Cast AdvancedCalc: 1~10 hap = %d\n", res);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10, b = 5, res;

		AdvancedCalc ac = new AdvancedCalc();

		// 메소드를 이용해서 ac를 넘김. 결과적으로 useBaseCalc의 bc=ac
		useBaseCalc(ac);
		System.out.println();
		// ac라는 참조변수를 ㅣ용하여 1,2,3,의 매개변수를 사용 가능.
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
		System.out.printf("%d's %d제곱 = %.0f\n", x, y, res1);

	}
}
