package mymain;

public class MyMain_예외처리적용 {

	// if 개발자가 예외관리 catch 자바가 예외관리 //코드수정

	static int plus(int a, int b) {
		return a + b;
	}

	static double plus(double a, double b) {
		return a + b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		plus(1, 2);
		plus(1.0, 2.0);
		int a = 10, b = 0, res;
		String str = null;
		// Stirng str = "abc" -> 자동 객체생성 단 null은 노생성 . length가 안됨.
		int[] mr = { 1, 2, 3 };

		int i = 1;
		mr[i] = 100;

		System.out.printf("%d", 10.5);

		// while (true) {
		try {
			// 정상적인 코드 처리구문
			if (b == 0)
				throw new ArithmeticException();

			res = a / b;

			if (str == null)
				throw new NullPointerException();
			int len = str.length(); // lenght는 문자의 길이를 구함. -> instance메소드
			// ststic 메소드 프로그램 시작하면
			/// lengt같은 인스턴스 -> 객체 생성시 생성
			// Thread.sleep(10000);
		} catch (ArithmeticException e) {
			// 예외발생시 코드처리
			// e.printStackTrace();
			System.out.println("0으로 나누지 못합니다.");
			b = 1;
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("객체생성을 해주십시오.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("---예외---");
		}
		// }

	}

}
