package ex;

import myUtil.MyArray2;

public class ����1 {
	
	static int[][] rotate_right_90(int [][] src){
		
		int rows = src.length;
		int cols = src[0].length;
		
		//���� �迭�� ������ ũ���� �迭�� ����
		int [][] dest = new int [rows][cols];
		for (int i=0; i<rows; i++) {
			for (int k=0; k<cols; k++) {
				dest [i][k] = src[(rows-1)-k][i]; // 4���� 5X5������ �ȵ�.
			}
		}
		return dest;
	}
	static int[][] rotate_left_90(int [][] src){
		
		int rows = src.length;
		int cols = src[0].length;
		
		//���� �迭�� ������ ũ���� �迭�� ����
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
		System.out.println("---����---");
		MyArray2.displayArray(src);
		
		int [][] res = rotate_right_90(src);
		System.out.println("--rotate right 90--");
		MyArray2.displayArray(res);

		int [][] res2 = rotate_left_90(src);
		System.out.println("--rotate left 90--");
		MyArray2.displayArray(res2);
	}
}
