package ex;

public class _2����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--��ü ���--");
		for (int i = 0; i < 5; i++) { // ��÷�� 0, 1, 2, 3, 4,
			for (int k = 0; k < 5; k++) { // ��÷�� 0, 1, 2, 3, 4,
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--�ﰢ�� ���--");
		for (int i = 0; i < 5; i++) { // ��÷�� 0, 1, 2, 3, 4,
			for (int k = 0; k < 5; k++) { // ��÷�� 0, 1, 2, 3, 4,
				if (k < i)
					System.out.print("*");
				else
					System.out.print("^");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--�ﰢ�� ���2--");
		for (int i = 0; i < 5; i++) { // ��÷�� 0, 1, 2, 3, 4,
			for (int k = 5; k >= 0; k--) {
				if (k < i)
					System.out.print("*");
				else
					System.out.print("^");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--���ﰢ�� ���--");
		for (int i = 0; i < 5; i++) { // ��÷�� 0, 1, 2, 3, 4,
			for (int k = 0; k < 5; k++) { // ��÷�� 0, 1, 2, 3, 4,
				if (k > i)
					System.out.print("*");
				else
					System.out.print("^");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--���ﰢ�� ���2--");
		for (int i = 0; i < 5; i++) { // ��÷�� 0, 1, 2, 3, 4,
			for (int k = 5; k >= 0; k--) {
				if (k > i)
					System.out.print("*");
				else
					System.out.print("^");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--������ ���--");
		int n = 5;
		int center = n / 2;
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (i <= center) { // ���
					if (k >= center - i && k <= center + i) {
						System.out.print("*");
					} else
						System.out.print("-");
				}else {
					int a=n-i-1;
					if(k>=center-a&&k<=center+a) System.out.print("*");
					else System.out.print("-");
				}
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("--�ٶ����� ���--");
		for (int i = 0; i < 5; i++) { // ��÷�� 0, 1, 2, 3, 4,
			for (int k = 0; k < 5; k++) { // ��÷�� 0, 1, 2, 3, 4,
				if (i == k || i == 4 - k) // ��������
					System.out.print("   ");
				else
					System.out.print("*");
			}
			System.out.println();
		}

	}

}
