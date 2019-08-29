package ex1;

public class 자료형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 논리형 자료형 : boolean
		// True or false
		// 변수: boolean bOK; nNumber
		// 기본값은 false
		// cnffur tjtlr: %b, %B >> 결과 출력 대소문자 차이
		
		// 출력방법 
		System.out.print("내용만 출력");
		System.out.println("출력 후 줄바꿈"); // line next
		System.out.printf("원하는 포맷과 형식대로 출력\n"); // 
		
		System.out.printf("%b\n", 3>2); // true
		
		int n= 100;
		System.out.printf("10진 %d\n", n); // 
		System.out.printf("  8진 0%o\n", n); // 
		System.out.printf("16진 0x%h\n", n); // 

		// 10진수를 8진수로 출력
		System.out.printf("0%o >> %d", 0144, 0144);
		
		// 서식 자릿수 지정 출력 (들여쓰기 같은 것)
		System.out.printf("[%10d]\n", 123); // 오른쪽 정렬
		System.out.printf("[%-10d]\n", 123); // 왼쪽 정렬
		System.out.printf("%010d", 123); // 빈 공간은 0으로
		
		double pi = 3.14;
		System.out.printf("원주율: %f\n", pi); // 
		System.out.printf("원주율: %g\n", pi); // 
		System.out.printf("원주율: %e\n", pi); // 
		System.out.printf("원주율: %e\n", pi*100); // 
		
		System.out.printf("원주율: [%10.2f]\n", pi); // 
		System.out.printf("원주율: [%3.5f]\n", 3.141592); // 
		System.out.printf("반올림: [%3.5f]\n", 3.1498754);
		
		char ch= 'A';
		System.out.printf("%c의 아스키 코드= %d\n", ch, (int)ch);
		
		ch= '가';
		System.out.printf("%c의 아스키 코드= %d\n", ch, (int)ch);
		System.out.printf("44032의 문자 = %c\n", 44032);
		
		
		System.out.printf("A\r\nB\n");
		System.out.printf("A\tB\tC\n");
		System.out.printf("ABC\b\bx\n");
		
		System.out.println("\\");
		System.out.println("\"점심 맛있게 드세요.\"라고 말했다.");
		
		double rate= 0.3;
		System.out.printf("할인율: %.0f(%%)\n", 0.3*100);

		String name="홍길동";
		System.out.printf("내 이름은 [%s]\n", name);
		String str="우리나라대한민국";
		System.out.printf("%.2s\n",str);
		
		System.out.println("--각 자료형의 사용범위--");
		System.out.printf("byte: %d ~ %d \n", Byte.MIN_VALUE, Byte.MAX_VALUE);
		System.out.printf("int: %d ~ %d \n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.printf("short: %d ~ %d \n", Short.MIN_VALUE, Short.MAX_VALUE);
		
	}
	

}
