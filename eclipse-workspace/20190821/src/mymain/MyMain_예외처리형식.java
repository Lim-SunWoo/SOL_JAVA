package mymain;

public class MyMain_����ó������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nr = { 1, 2, 3 };

		for (int i = 0; i <= nr.length; i++) {
			try {
				System.out.println(nr[i]);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("---���ܹ߻�---");
			} finally {
				System.out.println("---������ ����---");
			}
		}
	}

}
