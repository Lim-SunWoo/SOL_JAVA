package myutil;

public class AdvancedCalc extends BaseCalc {

	// Type~ = F4
	public int hap(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum = sum + i;
		}

		return sum;

	}

	// n's m���� ��*��*��*��*... n��
	public double pow(double n, double m) {

		double result = 1.0; // 0���� ���� �ʵ��� ����.

		for (int i = 0; i < m; i++) {
			// result = result * n;
			// result = super.multyply(result, n);
			// ��result * nŸ���� ���� �ʾƼ� ����� �Ұ���. (DOUBLE) > �������̵� �ʿ�
			result = super.multyply(result, n); // << souble �������̵�	
		}

		return result;
	}

}
