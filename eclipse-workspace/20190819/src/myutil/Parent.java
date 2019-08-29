package myutil;

public class Parent {
	public void sub(int n) { // protected 면 O public이면 Parent를 Protected이면 안됨.
		System.out.println("--Parent.sub()--");
	}
	
	public void sub() {
		
	} // 둘은 오버로드 관계

}
