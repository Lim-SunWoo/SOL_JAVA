package myutil;

public class MyService {
	
	//design Pattern ���� �����
	// single-tin pattern :  ��ü 1���� �����ؼ� ���������� ���� �ϵ��� ����
	
	static MyService single =null; 
	public static MyService getInstance() {
		if (single == null) single = new MyService();
		return single;
	}
	
	public MyService() {
		// TODO Auto-generated constructor stub
		System.out.println("--MyService()--");
	}
	
	// ���Աݾ��� �ι踦 ��ȯ
	public int double_money(int money) {
		return money*2;
		
	}	
}
