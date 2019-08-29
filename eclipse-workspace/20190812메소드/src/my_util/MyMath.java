package my_util;

public class MyMath {
	// 두 수 중에 큰 수
	public static int max(int a, int b) {
		int max = (a > b) ? a : b;// 숫자 두개를 비교해서 더 큰 값을 저장한다.
		return max;
	}

	// 세 수 중에 큰 수
	public static int max(int a, int b, int c) {

		int max = (a > b) ? a : b;
		max = c > max ? c : max;// 숫자 두 개를 비교한 결과 값과 나머지 숫자를 비교한다.

		return max;
	}

	/*
	 * // n까지의 합중에서 M의 배수의 합 public static int hap(int a, int b) {
	 * for (int i=0;i<=n; i+=m) sum+=i;
	 * return sum; } }
	 */
	// n이하 소수의 합 // /2gotj rm dksdprjtaks rngoeh ehla.(2의 배수)
	public static int hap_sosu(int n) {
		int sum = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 3; j <= n; j++) {
				if (i >= j) {
					if (!(i % j == 0)) {
						sum = sum + i;// i를 2말고 나누어지지 않으면
						System.out.println(i);
					} else break;
				}
			}
		}
		return sum;
	}
}