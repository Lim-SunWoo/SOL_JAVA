package mymain;

import myutil.BaseCalc;
import myutil.BaseCalcImpl;

public class myMain_BaseCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 설명서 변수 = new 설명서();
		// interface 변수 = new class()
		// BaseCalc calc = new BaseCalcImpl();
		// BaseCalc calc = new BaseCalcFactory().createBaseCalc(); // // 팩토리패턴
		// 공장을 만들고 공장에서 제품을 만들음.
		// 제품 하나 당 공장하나가 아닌 공장 하나를 짓고 제품을 계속 생산하기 위한 작업.
		BaseCalc calc = new BaseCalcFactory().getInstance().createBaseCalc(); // 싱글톤패턴: 객체를 하나만 생성한 후 사용
		// 메소드 체이닝 방식

		/*
		 * 디자인패턴: 1. 팩토리 패턴: 해당 객체만 전문적으로 생산하는 클래스를 운영하자. 2. 싱글톤 패턴: 서비스 객체 하나만 생성해서
		 * 운영하자.
		 */

		/*
		 * ^위에꺼를 나눈 것 BaseCalcFactory factory = new BaseCalcFactory().getInstance();
		 * BaseCalc calc = factory.createBaseCalc();
		 */

		int a = 10, b = 5, res;
		res = calc.plus(a, b);
		System.out.printf("%d + %d = %d\n", a, b, res);
		res = calc.minus(a, b);
		System.out.printf("%d - %d = %d\n", a, b, res);

	}

}
