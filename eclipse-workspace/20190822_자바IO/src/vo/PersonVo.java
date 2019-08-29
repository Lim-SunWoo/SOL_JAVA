package vo;

import java.io.Serializable;

public class PersonVo implements Serializable /*1.*/ {

	// Vo (Valur Object)���� ��������ϴ� ��ü
	// DTO Data Trancefer Object ���ް�ü

	// VO==DTO

	// ����ȭ���� ��ü�� ����
	// 1. Seriallizable interface �߰�, ����ȭ ������ ��ü�� �˷��ִ� ��¡���� �ǹ�
	// 2. �����ڴ� �����ϴ��� �⺻�����ڴ� ������ ���� �Ѵ�. 
	// 3. ��
	String name;
	int age;
	String addr;
	
	/*���ͻ��� �ʼ�*/
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
	
	/*2. �����ε� �� ������ zjstnl�� wpsjfpdlxm djWjrn dbwld*/
	// �� ���¿����� ������ �� �߳� ����ȭ �� �ֵ��� �����ϴ� �������� ������ ��.
	public PersonVo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}


}
