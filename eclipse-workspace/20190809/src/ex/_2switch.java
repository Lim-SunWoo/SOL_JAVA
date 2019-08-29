package ex;

import java.util.Scanner;

public class _2switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		String data;
		String res;
		
		System.out.println("과일을 입력하시오");

		data = scan.nextLine();
		
		switch(data) {
		
		case "포도" : res = "달다";
				break;
		case "수박" : res = "시원하다";
				break;
		case "딸기" : res = "맛있다";
				break;
		case "참외" : res = "노랗다";
				break;
		}
		
		// System.out.printf("당신이 입력한 과일은 %s이고 %s는 %s\n", data, data, res);
	}

}
