package ex;

public class _3for {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * // #1
		 * 
		 * for (int i=0; i<3; i++) { System.out.println("안녕");
		 * 
		 * }
		 * 
		 * //#2 int sum=0; int n=100;
		 * 
		 * for ( int i=1 ;i<=n; i++) { sum = sum +i;
		 * 
		 * System.out.print(i); if (i<n) System.out.println("+"); else
		 * System.out.print("="); Thread.sleep(300); // 1/1000 초 }
		 * System.out.println(sum); }
		 */

		// #3

		int sum = 0;
		int n = 10;

		for (int i = 1; i <= n; i++) { // 짝수의 합

			if (i % 2 == 0)
				sum = sum + i;
		}
		System.out.printf("1-%d까지의 수 중에서 짝수의 합은 %d 입니다.", n, sum);
	}
}
