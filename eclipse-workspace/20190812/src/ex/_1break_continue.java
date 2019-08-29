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
		for (int a = 0; a < 5; a++) { // a가 0, 1, 2, 3, 4
			for (int b = 0; b < 5; b++) { // b가 0, 1, 2, 3, 4
				// System.out.printf("%d", b);
				// if (b>a) break; // break 현재의 반복문만 탈출함 , 직각삼각형
//				if (b==2) break OUT_FOR ;// 2*5직사각형
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
