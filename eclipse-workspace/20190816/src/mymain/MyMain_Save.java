package mymain;

import myutil.Save;

public class MyMain_Save {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Save.rate = 0.1; // static이지만 접근 제한자가 있음.
		// 클래스명, 변수명, 값 -> static 전역변수는 아님.
		// _1Save.name= 은 X
		
		
		// static변수나 메소드 1.생성시기 프로그램 시작 시에
		// static 변수는 각 개체가 공유하는 변수(사용)
		// 표현방식 클래스명, 변수명 = 값: 
		// cf) 객체 생성 후 표현
		//     참조변수명, 변수명 = 값;
		
		
		Save[] s_array = { new Save("일길동", 1000000), new Save("이길동", 2000000), new Save("삼길동", 3000000) };
		
		
		System.out.printf("====rate: %.2f=====\n", Save.rate);
		for (int i = 0; i < s_array.length; i++) {
			s_array[i].display();
		}
		
		int [] su_array = {1, 2, 3, 4};
		System.out.println("----첨자이용----");
		for(int i=0; i<su_array.length; i++) {
			System.out.println(su_array[i]);
		}
		System.out.println();
		
		System.out.println("---개선 loop이용---");
		for (int su: su_array) {
			System.out.println(su);
		}
		System.out.println();

		
		System.out.println("---개선 loop이용2---");
		for (Save s : s_array) {
			s.display();
		}
		System.out.println();

		// 이율변경: 객체 생성 후
		// s_array[0].rate=0.2;

	}
}
