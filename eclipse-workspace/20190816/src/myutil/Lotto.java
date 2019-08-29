package myutil;

import java.util.Arrays;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Lotto {

	int[] user_no;
	int[] win_no;

	Random rand = new Random();

	int count = 0; // 맞은 개수
	int rank = 0;

	// 당첨번호를 이용한 등수 계산
	public void setUser_no(int[] user_no) {
		this.user_no = user_no; // 알트 쉬프트 에스 Generate Getter setter
		calc_rank();

	}

	private void calc_rank() { // private 외부에서 호출되는 것이 아니라서 가능
		// TODO Auto-generated method stub
		count = 0;
		boolean special = false;
		rank = 0;
		for (int i = 0; i < user_no.length; i++) {
			for (int k = 0; k < win_no.length - 1; k++) {
				if (user_no[i] == win_no[k])
					count++;
			}
			if (count >= 5) {
				for (int l = 0; l < win_no.length - 1; l++) {
					if (user_no[i] == win_no[win_no.length]) {
						special = true;
					}
				}
			}
		} // 맞은 개수

		switch (count) {
		case 0:
		case 1:
		case 2:
			rank = 0;
			break;
		case 3:
			rank = 5;
			break;
		case 4:
			rank = 4;
			break;
		case 5:
			if (special == false)
				rank = 3;
			else
				rank = 2;
			break;
		case 6:
			rank = 1;
			break;

		}
	}

	// 로또번호 생성
	public void make_win_no() {

		win_no = new int[7]; // 당첨번호(6) + 보너스(1)
		OUT_FOR: for (int i = 0; i < 7; i++) {
			int su = rand.nextInt(45) + 1;// 1~45
			// 중복수 체크
			for (int k = 0; k < i; k++) {
				if (su == win_no[k]) {
					i--;// 증감식에서 증가 (현재취소)
					continue OUT_FOR;
				}
			}
			win_no[i] = su;
		}
	}

	public void display() {

		Arrays.sort(user_no);
		Arrays.sort(user_no, 0, 0 + 6); // 보기 좋게하기위해서 정렬

		System.out.println("----추첨결과----");
		System.out.print("추첨번호:");
		for (int i = 0; i < win_no.length; i++) {
			if (i < 6)
				System.out.printf("%3d", win_no[i]);
			else
				System.out.printf(" [%3d]", win_no[i]);
		}
		System.out.println();
		System.out.print("유저번호:");
		for (int i = 0; i < user_no.length; i++) {
			System.out.printf("%3d", user_no[i]);
		}
		System.out.println();

		System.out.printf("맞은갯수:%d(개)\n", count);
		System.out.printf("당첨등수:%d(등)\n", rank);

	}

}
