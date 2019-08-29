package vo;

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



public class PersonVo2 implements Serializable{
   
	String name;
    int    age;
    transient String addr; //����ȭ ���� ���
    
    public PersonVo2() {
		// TODO Auto-generated constructor stub
	}
    
    //Overload ������
	public PersonVo2(String name, int age, String addr) {
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
		String str = String.format("[%s-%d-%s]", name,age,addr);
		return str;
	}
	
	
	
        
    
}



