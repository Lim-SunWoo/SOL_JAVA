package ex;

public class _7삼항연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a= 10, b= 5, c;
		
		c= (a>b) ? a : b;
		System.out.printf("%d와 %d중에 더 큰 값은 %s입니다.\n", a, b, c);

		int n= -100;
		int m;
		
		m= (n<0) ? -n:n;
		
		System.out.printf("%d", m);
	
	}

}
