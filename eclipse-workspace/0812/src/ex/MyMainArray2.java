package ex;

import myUtil.MyArray;
import myUtil.MyArray2;

public class MyMainArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mm = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		MyArray2.displayArray(mm);

		int[][] block1 = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };

		int[][] block2 = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 1, 0 } };

		System.out.println("--block--");
		MyArray2.displayArray(block2);

		// 고정길이 배열: 열의 개수가 동일한 배열
		// 가변길이 배열: 열의 개수가 가변적인(다른)배열

		// 가변길애 배열 할당
		int[][] mm2 = new int[3][];
		mm2[0] = new int[] { 1, 2 };
		// mm2[1]={3,4,5}; X
		mm2[1] = new int[] { 3, 4, 5 };
		mm2[2] = new int[] { 6, 7, 8, 9 };

		MyArray2.displayArray(mm2);

		int[][] mm3 ={ { 11, 22, }, { 33, 44, 55 }, { 66, 77, 88, 99 } }; // 초기화라 new int 없어도 됨.

	}
}
