package ex;

public class _04���迬���� {

	public static void main(String[] args) {
		int a=5, b=3;
		System.out.printf("%d > %d �� %b\n", a, b, a>b);
		System.out.printf("%d >= %d �� %b\n", a, b, a>=b);
		System.out.printf("%d < %d �� %b\n", a, b, a<b);
		System.out.printf("%d <= %d �� %b\n", a, b, a<=b);
		System.out.printf("%d == %d �� %b\n", a, b, a==b);
		System.out.printf("%d != %d �� %b\n", a, b, a!=b);
		
		if (a>b) System.out.printf("%d�� %d���� Ů�ϴ�.", a, b);
		else if (a==b) System.out.printf("%d�� %d�� �����ϴ�.",a , b);
		else System.out.printf("%d�� %d���� �۽��ϴ�.", a, b);
	}
}
