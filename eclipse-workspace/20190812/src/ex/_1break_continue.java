package ex;

public class _1break_continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (i > 5)
				break;
			System.out.println(i);
		}

		System.out.println();
		for (int a = 0; a < 5; a++) { // a�� 0, 1, 2, 3, 4
			for (int b = 0; b < 5; b++) { // b�� 0, 1, 2, 3, 4
				// System.out.printf("%d", b);
				// if (b>a) break; // break ������ �ݺ����� Ż���� , �����ﰢ��
//				if (b==2) break OUT_FOR ;// 2*5���簢��
				System.out.print('*');
			}
			System.out.println();
		}

		System.out.println();

		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 5; b++) {
				if (b==2) {
				System.out.printf("(%d, %d)", a, b);
				}
			}
			System.out.println();
		}

	}

}
