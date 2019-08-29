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

	// n's m제곱 ㅜ*ㅜ*ㅜ*ㅜ*... n번
	public double pow(double n, double m) {

		double result = 1.0; // 0으로 하지 않도록 주의.

		for (int i = 0; i < m; i++) {
			// result = result * n;
			// result = super.multyply(result, n);
			// ㄴresult * n타입이 맞지 않아서 사용이 불가함. (DOUBLE) > 오버라이드 필요
			result = super.multyply(result, n); // << souble 오버라이드	
		}

		return result;
	}

}
