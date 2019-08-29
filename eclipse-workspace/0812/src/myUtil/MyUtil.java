package myUtil;

import java.util.*;

public class MyUtil {

	// 각 월별 일 수
	public static final int[] month_array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31 };

	// 윤년 평년
	public static boolean isYoon(int year) {

		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}

	public static void make_calendar(int year, int month) {
		// 해당년 1이 무슨 요일인가?

		// week행과 yoil열
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, 1);

		int yoil = c.get(Calendar.DAY_OF_WEEK) - 1; // 요일은 1부터 시작, 달은 0부터 시작
		System.out.println("시작요일"+yoil);

		int week = 0; // 행첨자

		int[][] cal_array = new int[6][7];

		// 윤년이면 2월의 일 수 바꾸기
		if (isYoon(year))
			month_array[1] = 29;
		else
			month_array[1] = 28;

		// 저번달 달력 , 요일이 일요일이면
		int prev_yoil = (yoil == 0) ? 6 : yoil - 1;

		int prev_month_index = (month - 2) < 0 ? 11 : month - 2; // 2를 뺀 값이 음수면 12월 (=11)
		int prev_month_last_day = month_array[prev_month_index];
		for (int i = prev_month_last_day; i > 0; i--) {
			cal_array[week][prev_yoil] = i;
			prev_yoil--;
			if (prev_yoil < 0)
				break;
		}

		if (yoil == 0)
			week++;
		
		// 이번달 달력 채우기
		for (int i = 1; i <= month_array[month - 1]; i++) {
			// System.out.print(i+" ");
			cal_array[week][yoil] = i;
			yoil++;
			if (yoil > 6) {
				week++;
				yoil = 0;
			}
		}


		// 다음달 달력
		for (int i = 1; i < 20; i++) {
			cal_array[week][yoil] = i;
			yoil++;
			if (yoil > 6) {
				yoil = 0;
				week++;
				if (week > 5) // 토요일을 넘어감.
					break;
			}
		}


		//title 출력
		System.out.printf("\n%14d년%d월\n",year,month);
		String [] str_yoil = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		
		System.out.println("----------------------------");
		for(int i=0;i<str_yoil.length;i++) {
			System.out.printf("%4s",str_yoil[i]);
		}
		System.out.println();
		System.out.println("----------------------------");
		
		// 이번달 달력출력하기
		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < 7; k++) {
				System.out.printf("%4d", cal_array[i][k]);
			}
			System.out.println();
		}System.out.println();
	}
}
