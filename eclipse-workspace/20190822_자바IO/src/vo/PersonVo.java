package vo;

import java.io.Serializable;

public class PersonVo implements Serializable /*1.*/ {

	// Vo (Valur Object)값을 저장관리하는 객체
	// DTO Data Trancefer Object 전달객체

	// VO==DTO

	// 직렬화가능 객체로 설정
	// 1. Seriallizable interface 추가, 직렬화 가능한 객체를 알려주는 상징적인 의미
	// 2. 생성자는 생략하던지 기본생성자는 무조건 정의 한다. 
	// 3. ㄴ
	String name;
	int age;
	String addr;
	
	/*개터새터 필수*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = String.format("[%s-%d-%s]", name,age,addr);
		return str;
	}
	
	/*2. 오버로드 된 생성자 zjstnlㅇ wpsjfpdlxm djWjrn dbwld*/
	// 이 상태에서는 에러가 안 뜨나 직렬화 된 애들을 복구하느 과정에서 오류가 남.
	public PersonVo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}


}
