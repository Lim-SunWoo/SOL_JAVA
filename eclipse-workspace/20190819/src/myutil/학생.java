package myutil;

public abstract class 학생 { // public 과 abstract의 순서는 바뀌어도 상관 없음.
	int 학년;
	int 학번;
	
	abstract public void 공부한다();
	// 구체적 표현이 불가능한 추상화 메소드(abstract)
	// 메소드 바디가 없는 메소드
	// 상위에 있는 클래스도 추상화. 
}
