package myutil;

public class Save {
	String name;
	int money ;
	public static double rate; // ���� != ����
	public Save(String name, int money) { // �����ε� ���� ��Ʈ ����Ʈ ����
		//new Save ("�ϱ浿", 1000000);
		super();
		this.name = name;
		this.money = money;
	}
	
	public void display() {
		System.out.printf("%10s=%10d-%10.2f-%10d\n", name, money, rate, (int)(money*rate));
	}
}
