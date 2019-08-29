package ex1;
import java.util.*;

public class 문제_원 {
	public static void main(String[] args) {
		
		// 반지름이 주어지면 그걸 이용해서 원의 넓이/둘레를 구한다.
		// 원체적: 4/3*파이*반지름^3
		
		final double PI= 3.14;
		// (Math.PI)
		
		double r;
		double l;
		double s;
		double v;
		
		System.out.println("원의 반지름을 입력하시오.");
		Scanner scan = new Scanner(System.in);
		r= scan.nextDouble();
		l= 2*r*PI;
		s= r*r*PI;
		v= r*r*r*PI*4/3;
		
		
		System.out.println("반지름이 "+r+"인 원의 둘레는 "+l+", 넓이는 "+s+"이며 구의 부피는 "+v+"입니다.");
		
		System.out.println(4/3);
		System.out.println(4.0/3);
		
	}
}
