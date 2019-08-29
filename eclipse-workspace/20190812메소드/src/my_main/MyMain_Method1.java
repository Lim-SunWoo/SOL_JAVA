package my_main;

public class MyMain_Method1 {
	
	public static int plus(int a, int b) {
		
		int c= a+b;
		return c;
	}
	
	public static int hap (int n) {
		int sum = 0;
		
		for (int i=0; i<=n; i++) {
			sum += i;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x=10, y=5, res;
		res = MyMain_Method1.plus(x, y); // 같은 클래스 내의 메소드이므로 plus(x,y) 가능
		
		System.out.printf("%d + %d = %d\n", x, y, res);
		
		res = hap(x);
		System.out.printf("%d까지의 합= %d\n", x, res);
	}

}
