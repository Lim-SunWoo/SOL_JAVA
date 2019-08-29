package ex;

public class _1if {
	public static void main (String args[]) {
		int eng = 70;
		String res ="불합격";
		if (eng >= 60)  res = "합격";
		
		System.out.printf("%d점이고 %s 입니다.\n", eng, res);
		
		
		//#3
		
		int su = 5;
		
		if(su%2==0 && su%3==0) { // ; 주의 
			System.out.printf("%d는 2의 배수\n", su);
			System.out.printf("%d는 3의 배수\n", su);
		}
		else System.out.println("조건이 맞지 않습니다. \n");
		
		
		// #4
		
		int kor = 80;
		String grade = "F";
		
		if (kor>=90&&kor<=100) grade= "A";
		else if (kor>=80&&kor<90) grade= "B";
		else if (kor>=70&&kor<80) grade= "C";
		else if (kor>=60&&kor<70) grade= "D"; // 전부 if, else로 묶으면 불 필요한 연산을 줄일 수 있음. >> else if 가 됨.
		
		System.out.printf("[%d]점 등급: %s\n", kor, grade);
	
	
	}
	
	
	
	
}
