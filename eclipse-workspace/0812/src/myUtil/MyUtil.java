package myUtil;

import java.util.*;

public class MyUtil {

	// �� ���� �� ��
	public static final int[] month_array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31 };

	// ���� ���
	public static boolean isYoon(int year) {

		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}

	public static void make_calendar(int year, int month) {
		// �ش�� 1�� ���� �����ΰ�?

		// week��� yoil��
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, 1);

		int yoil = c.get(Calendar.DAY_OF_WEEK) - 1; // ������ 1���� ����, ���� 0���� ����
		System.out.println("���ۿ���"+yoil);

		int week = 0; // ��÷��

		int[][] cal_array = new int[6][7];

		// �����̸� 2���� �� �� �ٲٱ�
		if (isYoon(year))
			month_array[1] = 29;
		else
			month_array[1] = 28;

		// ������ �޷� , ������ �Ͽ����̸�
		int prev_yoil = (yoil == 0) ? 6 : yoil - 1;

		int prev_month_index = (month - 2) < 0 ? 11 : month - 2; // 2�� �� ���� ������ 12�� (=11)
		int prev_month_last_day = month_array[prev_month_index];
		for (int i = prev_month_last_day; i > 0; i--) {
			cal_array[week][prev_yoil] = i;
			prev_yoil--;
			if (prev_yoil < 0)
				break;
		}

		if (yoil == 0)
			week++;
		
		// �̹��� �޷� ä���
		for (int i = 1; i <= month_array[month - 1]; i++) {
			// System.out.print(i+" ");
			cal_array[week][yoil] = i;
			yoil++;
			if (yoil > 6) {
				week++;
				yoil = 0;
			}
		}


		// ������ �޷�
		for (int i = 1; i < 20; i++) {
			cal_array[week][yoil] = i;
			yoil++;
			if (yoil > 6) {
				yoil = 0;
				week++;
				if (week > 5) // ������� �Ѿ.
					break;
			}
		}


		//title ���
		System.out.printf("\n%14d��%d��\n",year,month);
		String [] str_yoil = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		
		System.out.println("----------------------------");
		for(int i=0;i<str_yoil.length;i++) {
			System.out.printf("%4s",str_yoil[i]);
		}
		System.out.println();
		System.out.println("----------------------------");
		
		// �̹��� �޷�����ϱ�
		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < 7; k++) {
				System.out.printf("%4d", cal_array[i][k]);
			}
			System.out.println();
		}System.out.println();
	}
}
