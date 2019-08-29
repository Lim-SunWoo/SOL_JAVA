package vo;

public class PersonVo {
	String name;
	int age;
	String addr;

	public PersonVo() {
		// TODO Auto-generated constructor stub
	}

	public PersonVo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("이름: %s 나이: %d 주소: %s", name, age, addr);
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

}
