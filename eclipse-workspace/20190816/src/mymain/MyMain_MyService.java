package mymain;

import java.util.Calendar;
import java.util.Random;

import myutil.*;;

public class MyMain_MyService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();

		while (true) {
			// MyService ms = new MyService(); // �ѹ����� ������ ��� ������ �Ҹ��� �ݺ���. ȿ�������� ���ϰ� �Ҹ�����.
			MyService ms = MyService.getInstance(); // ��ü �ѹ��� ����, �������� ��� ����.
			// int money = 100;
			int money = (rand.nextInt(10) + 1) * 100;
			int res_money = ms.double_money(money);
			System.out.printf("���ڱݾ�: %d, ȸ���ݾ�: %d\n", money, res_money);

			
			// Thread.sleep(2000);

			Calendar.getInstance(); // getInatance�� ��������� ��� �ֵ��� �̱�


		}

	}

}
