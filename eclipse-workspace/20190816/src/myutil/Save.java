package myutil;

public class Save {
	String name;
	int money ;
	public static double rate; // 이율 != 이자
	public Save(String name, int money) { // 오버로드 생성 알트 쉬프트 에스
		//new Save ("일길동", 1000000);
		super();
		this.name = name;
		this.money = money;
	}
	
	public void display() {
		System.out.printf("%10s=%10d-%10.2f-%10d\n", name, money, rate, (int)(money*rate));
	}
}
