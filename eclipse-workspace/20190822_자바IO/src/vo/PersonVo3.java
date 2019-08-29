package vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/*
   VO(Value Object) : �� ��������ϴ� ��ü
   DTO(Data Transfer Object) : ���ް�ü
   
   VO == DTO
 */

/*
    ����ȭ���ɰ�ü�� ����
    1.Serializable interface �߰� 
    2.������ �����ϴ���
    3.�ߺ����ǵ� �����ڴ� ���ǽ� �⺻�����ڴ� ������ ����
 */

public class PersonVo3 implements Externalizable {

	String name;
	int age;
	transient String addr; // ����ȭ ���ܴ��

	public PersonVo3() {
		// TODO Auto-generated constructor stub
	}

	// Overload ������
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

	@Override // ����ȭ����
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		name = (String) in.readObject();
		age = in.readInt();

	}

}
