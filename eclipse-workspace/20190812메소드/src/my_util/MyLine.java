package my_util;

public class MyLine {
	// TODO Auto-generated method stub
	public static void draw_line(int a, String b) {
		for (int i = 0; i < a; i++)
			System.out.print(b);
		
		System.out.println();

		return;
	}
	
	public static void draw_line(int n, int n1, String a, int n2, String b) {
		for(int j=0; j<n; j++) {
			for (int i = 0; i < n1; i++)
				System.out.print(a);
			for (int q = 0; q < n2; q++)
				System.out.print(b);
			if(n<=j*(n1+n2)) break;
			
			// ���ļ� while������ ����, count�� break����(���ʿ� �Է��ؼ� ��� �κп����� ���� �� �ֵ��� ��.
			/*
			 * for (int i = 0; i < n1; i++){
			 *    System.out.print(a);
			 *    count++;
			 *    if(count==n) break OUT_WHILE
			 * }
			 * for (int q = 0; q < n2; q++) {
			 *    System.out.print(b); 
			 *    count++;
			 *    if(count==n) break OUT_WHILE
			 * }
			 */
		
		}
		System.out.println();
		return;
	}
}
