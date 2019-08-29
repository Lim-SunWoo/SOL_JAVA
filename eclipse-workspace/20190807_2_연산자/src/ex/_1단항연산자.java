package ex;

public class _1단항연산자 {
	public static void main (String args[]) {
		//단항연산자: ~!, ++, -- (csat), -(부호)
		
		// ~:  이진논리 Not 연산자 (tilde)
		// 		 1의 보수를 취한다. 
		//		 ~11110000 >> 00001111
		
		int n = 0x0f0f0f0f;
		System.out.printf("n=%08x\n", n);
		int m = ~n;
		System.out.printf("n=%08x\n", m);
		
		boolean b0k = !(3>2);
		System.out.println(b0k);
		
		// 실제 기능과 무관
		b0k = !("파리" == "새");
		System.out.println(b0k);
		
		System.out.println(!true);
		System.out.println(!false);
		
		int res;
		int b=10;
		int c=20;
		res = ++b + c--;
		System.out.println(res);
		
		
	}
}
