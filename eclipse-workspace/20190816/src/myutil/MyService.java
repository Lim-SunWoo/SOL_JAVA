package myutil;

public class MyService {
	
	//design Pattern 설계 방법론
	// single-tin pattern :  객체 1개만 생성해서 지속적으로 서비스 하도록 설계
	
	static MyService single =null; 
	public static MyService getInstance() {
		if (single == null) single = new MyService();
		return single;
	}
	
	public MyService() {
		// TODO Auto-generated constructor stub
		System.out.println("--MyService()--");
	}
	
	// 투입금액의 두배를 반환
	public int double_money(int money) {
		return money*2;
		
	}	
}
