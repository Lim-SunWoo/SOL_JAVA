package ex1;
import java.util.*;

public class 입출력 {
	public static void main(String[] args) {
		//이름 나이 결혼 유무 키 주소
		String name;
		int age;
		boolean bMarried;
		double ki;
		String adr;
		Scanner scan = new Scanner(System.in);
		
		//이름입력받기 
		System.out.println("이름을 입력하시오. >> ");
		name = scan.nextLine();
		System.out.println("나이를 입력하시오. >> ");
		age = scan.nextInt();
		System.out.println("결혼 유무 true/false >> ");
		bMarried = scan.nextBoolean();
		System.out.println("키를 입력하시오. >> ");
		ki = scan.nextDouble();
		
		scan.nextLine(); // 버퍼에 남아있는 엔터제거
		
		System.out.println("주소를 입력하시오. >> ");
		adr= scan.nextLine();

		
		System.out.println("--개인정보--");
		System.out.printf("이름: %s\n", name);
		System.out.printf("나이: %d\n", age);
		System.out.printf("결혼: %b\n", bMarried);
		System.out.printf("   키: %.1f\n", ki);
		System.out.printf("주소: % s", adr);

		
	}
}