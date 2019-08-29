package myutil;

public class 초등학생 extends 학생{
	//추상메소드를 하나 이상 포함한 클래스는 반드시 재 정의가 필요하다.
	@Override
	public void 공부한다() {
		// TODO Auto-generated method stub
		System.out.println("초등학생: 구구단 공부");
	}

}
