package myutil;

import java.util.Arrays;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Lotto {

	int[] user_no;
	int[] win_no;

	Random rand = new Random();

	int count = 0; // ���� ����
	int rank = 0;

	// ��÷��ȣ�� �̿��� ��� ���
	public void setUser_no(int[] user_no) {
		this.user_no = user_no; // ��Ʈ ����Ʈ ���� Generate Getter setter
		calc_rank();

	}

	private void calc_rank() { // private �ܺο��� ȣ��Ǵ� ���� �ƴ϶� ����
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
		} // ���� ����

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

	// �ζǹ�ȣ ����
	public void make_win_no() {

		win_no = new int[7]; // ��÷��ȣ(6) + ���ʽ�(1)
		OUT_FOR: for (int i = 0; i < 7; i++) {
			int su = rand.nextInt(45) + 1;// 1~45
			// �ߺ��� üũ
			for (int k = 0; k < i; k++) {
				if (su == win_no[k]) {
					i--;// �����Ŀ��� ���� (�������)
					continue OUT_FOR;
				}
			}
			win_no[i] = su;
		}
	}

	public void display() {

		Arrays.sort(user_no);
		Arrays.sort(user_no, 0, 0 + 6); // ���� �����ϱ����ؼ� ����

		System.out.println("----��÷���----");
		System.out.print("��÷��ȣ:");
		for (int i = 0; i < win_no.length; i++) {
			if (i < 6)
				System.out.printf("%3d", win_no[i]);
			else
				System.out.printf(" [%3d]", win_no[i]);
		}
		System.out.println();
		System.out.print("������ȣ:");
		for (int i = 0; i < user_no.length; i++) {
			System.out.printf("%3d", user_no[i]);
		}
		System.out.println();

		System.out.printf("��������:%d(��)\n", count);
		System.out.printf("��÷���:%d(��)\n", rank);

	}

}
