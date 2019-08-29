package mymain;

import myutil.MyMath;

public class MyMain_Math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10, y = 5, res;

		MyMath mm = new MyMath(); // 객체 생성시 인스턴트 메솓가 만들어짐 -> 사용가능해짐.

		// res = _2MyMath.plus(x,y); >> 오류
		res = mm.plus(x, y);

		// minus는 static 메소드라 만들어져있음 -> 객체생성은 거치지 않고서도 사용이 가능함.
		res = MyMath.minus(x, y);
		res = mm.minus(x, y); // 객체 생성후에도 사용이 가능하긴 하나 권장하지 않음.

		// 기본 API분석
		
		// Math m = new Math();
		res = Math.max(x, y);  // Math클래슨데 생성자 정의 -> private(외부에서 접근 불가 = 객체 생성할 필요가 없음.)

	}

}
