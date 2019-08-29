package mymain;

import java.io.FileReader;

public class MyMain_5_예외처리위임 {
	static void set(int[] mr, int i, int val) throws NullPointerException, ArrayIndexOutOfBoundsException {
		//
		try { // 1.서비스 제공
			
			if (mr == null) { // 해당메솓를 처리하는 측에서 예외처리해라
				throw new NullPointerException("---배열없어---");
			}
			
			String message = String.format("--첨자범위를 벗어났습니다.: 0~%d사이--", mr.length - 1, i);
			if (mr == null || i < 0 || i >= mr.length)
				throw new ArrayIndexOutOfBoundsException(message); // 반드시 받게되어있음.위임을 해놓아서 catch하란 이야기라고 함.
			mr[i] = val; // 내부의 문제...?
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	// catch작성 순서
	/*
	 * 가계도F4에서 큰쪽 > 작은쪽 순으로 작성
	 * 
	 */
	public static void main(String[] args) {
		int[] mr = new int[3];

		try {
			set(mr, 0, 10);
			set(mr, 1, 20);
			set(mr, 2, 30);
			// 밑으로 에러
			set(mr, 3, 40);
		} catch (Exception e) { // 2.이런 문제가 잇어
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000); // static메소드(객체생성 없이 사용할 수 있는 메소드, 메인이 종료되는 시점이 프로그램이 끝나는 시점.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileReader fr = new FileReader("ssss"); // 이 생성자 안에서 throw함. 찾다가 못찾으면 throw해서 알려줌
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 츠라이캐치를 하던 메인에 위임을 하던 둘 중 하나의 방법이 있음.

	}
}
