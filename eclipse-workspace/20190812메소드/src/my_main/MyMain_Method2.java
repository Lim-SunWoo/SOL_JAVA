package my_main;

import my_util.MyLine;

public class MyMain_Method2 {

	public static void main(String[] args) {
		
		int line_len= 30;
		
		// TODO Auto-generated method stub
		
			System.out.printf("%21s", "---성적관리---\n");
			//System.out.println("------------------");
			MyLine.draw_line(line_len,"="); // 컨스페이스 자동 임포트
			System.out.println("번호 이름    국어 영어 수학   총점");
			System.out.println("  1  일길동    99   88    77    234");
			System.out.println("  2  이길동    89   98    57    224");
			MyLine.draw_line(line_len, "-");
			System.out.println(" 계              188  186  134   508");
			
			//+새로운 패턴으로 선긋기
			int n1=1, n2=2;
			MyLine.draw_line(line_len,n1, "-",n2,"*");

	}
}
