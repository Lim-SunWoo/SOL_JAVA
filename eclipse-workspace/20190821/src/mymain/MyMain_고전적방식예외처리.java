package mymain;

public class MyMain_고전적방식예외처리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10, b = 0, res;
		res = a / b;

		if (b != 0) { // 사전에 에러발생 요인 체크
			res = a / b; //
		}

		String str = null;
		int len = str.length();

		int[] mr = { 1, 2, 3 };
		int i = 10;
		if (mr != null && i >= 0 && i < mr.length) {
			mr[10] = 100;
		}
	}

}
