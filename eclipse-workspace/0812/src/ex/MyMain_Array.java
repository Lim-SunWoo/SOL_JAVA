package ex;

import myUtil.MyArray;
import myUtil.MyArray2;

public class MyMain_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mr = new int[4];
		mr[0] = 1;
		mr[1] = 2;
		mr[2] = 3;
		mr[3] = 4;

		int len = mr.length;
		System.out.println("배열의 길이>>" + len);

		for (int i = 0; i < mr.length; i++) {

			mr[i] = i + 1;
			System.out.printf("mr[%d] = %d\n", i, mr[i]);
		}
		MyArray.setArray(mr);
		MyArray.displayArray(mr);
		MyArray.fill(mr, 0);
		MyArray.displayArray(mr);
		MyArray.fill(mr, 1, 3, 8);
		MyArray.displayArray(mr);

		int[][] mm = new int[3][4];

		// 0 행
		mm[0][0] = 1;
		mm[0][1] = 2;
		mm[0][2] = 3;
		mm[0][3] = 4;

		// 1 행
		mm[1][0] = 5;
		mm[1][1] = 6;
		mm[1][2] = 7;
		mm[1][3] = 8;

		// 2 행
		mm[2][0] = 9;
		mm[2][1] = 10;
		mm[2][2] = 11;
		mm[2][3] = 12;
		/*
		 * MyArray.setArray(mr2);//mm MyArray.displayArray(mr2);//mm
		 * System.out.println("---after 0 clear---");
		 */

	}
}
