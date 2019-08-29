package vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/*
   VO(Value Object) : 값 저장관리하는 객체
   DTO(Data Transfer Object) : 전달객체
   
   VO == DTO
 */

/*
    직렬화가능객체로 설정
    1.Serializable interface 추가 
    2.생성자 생략하던지
    3.중복정의된 생성자는 정의시 기본생성자는 무조건 정의
 */

public class PersonVo3 implements Externalizable {

	String name;
	int age;
	transient String addr; // 직렬화 제외대상

	public PersonVo3() {
		// TODO Auto-generated constructor stub
	}

	// Overload 생성자
	public PersonVo3(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

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
		String str = String.format("[%s-%d-%s]", name, age, addr);
		return str;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(name);
		out.writeInt(age);

	}

	@Override // 직렬화셋팅
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		name = (String) in.readObject();
		age = in.readInt();

	}

}
