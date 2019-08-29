package ex;

public class _5이진논리연산자 {
	public static void main(String[] args) {
	
		int birth=0x19901225;
		int year;
		int month;
		int day;
		
		// 출생년도
		year = birth >>> 16 /*16기준 4개를 미뤄야하나 비트 기준이므로 *4*/;
		System.out.printf("년: %x\n", year); // 출력에 주의, &가 안되는 이유는 뒤에 0이 계속 붙기 때문
		month = (birth >>8) & 0xff; // 000000ff,&를 이용하면 값이 남아있는 f(1111)부분만 남음. 제거할 때는 &,^,|이용
		System.out.printf("월: %x\n", month); // 출력에 주의
		day = birth & 0xff;
		System.out.printf("일: %x\n", day); // 출력에 주의
		// 지우기
		birth = birth ^ 0x00001200;
		System.out.printf("%x\n", birth);
		// 채우기
		birth = birth | 0x00000800;
		System.out.printf("%x\n", birth);
	}
	
}
