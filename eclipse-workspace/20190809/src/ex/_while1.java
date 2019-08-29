package ex;

public class _while1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < 3) {
			System.out.println(i);
			i++;
		}

		// 1~10±îÁö ÇÕ
		while (i < 10) {
			i = 0;
			int sum = 0;
			while (i <= 10) {
				sum += i;
				i++;
			}
			System.out.println(sum);
		}

	}
}