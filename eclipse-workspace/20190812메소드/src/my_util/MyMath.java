package my_util;

public class MyMath {
	// �� �� �߿� ū ��
	public static int max(int a, int b) {
		int max = (a > b) ? a : b;// ���� �ΰ��� ���ؼ� �� ū ���� �����Ѵ�.
		return max;
	}

	// �� �� �߿� ū ��
	public static int max(int a, int b, int c) {

		int max = (a > b) ? a : b;
		max = c > max ? c : max;// ���� �� ���� ���� ��� ���� ������ ���ڸ� ���Ѵ�.

		return max;
	}

	/*
	 * // n������ ���߿��� M�� ����� �� public static int hap(int a, int b) {
	 * for (int i=0;i<=n; i+=m) sum+=i;
	 * return sum; } }
	 */
	// n���� �Ҽ��� �� // /2gotj rm dksdprjtaks rngoeh ehla.(2�� ���)
	public static int hap_sosu(int n) {
		int sum = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 3; j <= n; j++) {
				if (i >= j) {
					if (!(i % j == 0)) {
						sum = sum + i;// i�� 2���� ���������� ������
						System.out.println(i);
					} else break;
				}
			}
		}
		return sum;
	}
}