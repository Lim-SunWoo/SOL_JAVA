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
		res = MyMain_Method1.plus(x, y); // ���� Ŭ���� ���� �޼ҵ��̹Ƿ� plus(x,y) ����
		
		System.out.printf("%d + %d = %d\n", x, y, res);
		
		res = hap(x);
		System.out.printf("%d������ ��= %d\n", x, res);
	}

}
