package ex;

public class _04관계연산자 {

	public static void main(String[] args) {
		int a=5, b=3;
		System.out.printf("%d > %d 는 %b\n", a, b, a>b);
		System.out.printf("%d >= %d 는 %b\n", a, b, a>=b);
		System.out.printf("%d < %d 는 %b\n", a, b, a<b);
		System.out.printf("%d <= %d 는 %b\n", a, b, a<=b);
		System.out.printf("%d == %d 는 %b\n", a, b, a==b);
		System.out.printf("%d != %d 는 %b\n", a, b, a!=b);
		
		if (a>b) System.out.printf("%d가 %d보다 큽니다.", a, b);
		else if (a==b) System.out.printf("%d와 %d는 같습니다.",a , b);
		else System.out.printf("%d는 %d보다 작습니다.", a, b);
	}
}
