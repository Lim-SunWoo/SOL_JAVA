package ex;

public class MyMainArray222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2019;

		String[][] ganji = { { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" },
				{ "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" } };

		System.out.printf("%d���� %s%s���Դϴ�. \n", year, ganji[0][year%10], ganji[1][year%12]);
		// 10�� year%10=0~9
		// ���� ���� ���� ��� �Ӱ�
		// 12�� year%12= 0~11
		// ���� �ι� ���� ���� ���� ����
		
		

	}

}
