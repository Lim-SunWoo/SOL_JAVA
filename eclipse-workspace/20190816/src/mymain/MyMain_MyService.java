package mymain;

import java.util.Calendar;
import java.util.Random;

import myutil.*;;

public class MyMain_MyService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();

		while (true) {
			// MyService ms = new MyService(); // 한번쓰고 버리는 모드 생성과 소멸을 반복함. 효율적이지 못하고 소모적임.
			MyService ms = MyService.getInstance(); // 객체 한번만 생성, 지속적인 사용 가능.
			// int money = 100;
			int money = (rand.nextInt(10) + 1) * 100;
			int res_money = ms.double_money(money);
			System.out.printf("투자금액: %d, 회수금액: %d\n", money, res_money);

			
			// Thread.sleep(2000);

			Calendar.getInstance(); // getInatance로 만들어지는 모든 애들은 싱글


		}

	}

}
