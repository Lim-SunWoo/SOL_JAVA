package ex;

import myUtil.MyArray2;

public class 문제1 {
	
	static int[][] rotate_right_90(int [][] src){
		
		int rows = src.length;
		int cols = src[0].length;
		
		//원본 배열과 동일한 크기의 배열을 생성
		int [][] dest = new int [rows][cols];
		for (int i=0; i<rows; i++) {
			for (int k=0; k<cols; k++) {
				dest [i][k] = src[(rows-1)-k][i]; // 4면은 5X5같은건 안됨.
			}
		}
		return dest;
	}
	static int[][] rotate_left_90(int [][] src){
		
		int rows = src.length;
		int cols = src[0].length;
		
		//원본 배열과 동일한 크기의 배열을 생성
		int [][] dest = new int [rows][cols];
		for (int i=0; i<rows; i++) {
			for (int k=0; k<cols; k++) {
				dest [i][k] = src[k][(rows-1)-i]; 
			}
		}
		return dest;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] src = new int [5][5];
		MyArray2.setArray(src);
		System.out.println("---원본---");
		MyArray2.displayArray(src);
		
		int [][] res = rotate_right_90(src);
		System.out.println("--rotate right 90--");
		MyArray2.displayArray(res);

		int [][] res2 = rotate_left_90(src);
		System.out.println("--rotate left 90--");
		MyArray2.displayArray(res2);
	}
}
