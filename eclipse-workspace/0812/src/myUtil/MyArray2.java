package myUtil;

import java.util.Arrays;

public class MyArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mr = new int[/* 갯수 */] { 1, 2, 3, 4, 5 }; // 요소의 갯수부분을 생략

		System.out.println("mr배열의 길이" + mr.length);
		MyArray.displayArray(mr);

		// 1차원 배열 활용
		int[] month_array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int year = 1990; // 출생년도
		int tti_index = year % 12;
		int month = 5;
		System.out.printf("%d월은 %d일까지 있습니다.", month, month_array[month - 1]);


		String[] tti_array = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양" };
		System.out.printf("%d년생 %S띠\n", year, tti_array[tti_index]);
		
		int [] mr1= {6, 4, 5, 1, 2, 3};
		MyArray.displayArray(mr1);
		// 자바 기존  API에 arrays class
		Arrays.sort(mr1); // 기본적으로 오름차순
		MyArray.displayArray(mr1);
	}
		
		//Ascending (소->대): asc
		//Sedending (대->소): desc
		
		// 어센딩과 디센딩  차이
/*		if )mr [i]> mr[k]){
			nr[i]= mr[k]*/
		
		
		//선택정렬
		public static void sort_desc(int [] mr){
			for (int i=0; i<mr.length-1; i++) {
				for (int k=i+1; k<mr.length; k++){
					if (mr[i]> mr[k]) {
						int im= mr[i];
						mr[i] = mr[k];
						mr[k]= im;
					}
				}
			}
		}
		
		public static void sort_desc() {
			
	}
		
		public static void displayArray(int [][] mm) {
			
			for(int i=0;i<mm.length;i++) {       //행첨자 i= 0 1 2 ...
				for(int k=0;k<mm[i].length;k++) {//열첨자 k= 0 1 2 ...
					System.out.printf("%4d",mm[i][k]);
				}
				System.out.println();//줄바꾸기
			}
		}
		
		public static void setArray(int [][] mm) {
			
			int su = 1;
			for(int i=0;i<mm.length;i++) {       //행첨자 i= 0 1 2 ...
				for(int k=0;k<mm[i].length;k++) {//열첨자 k= 0 1 2 ...
					mm[i][k] = su++;
				}
			}
		}
		

}
