package myUtil;

import java.util.Arrays;

public class MyArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mr = new int[/* ���� */] { 1, 2, 3, 4, 5 }; // ����� �����κ��� ����

		System.out.println("mr�迭�� ����" + mr.length);
		MyArray.displayArray(mr);

		// 1���� �迭 Ȱ��
		int[] month_array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int year = 1990; // ����⵵
		int tti_index = year % 12;
		int month = 5;
		System.out.printf("%d���� %d�ϱ��� �ֽ��ϴ�.", month, month_array[month - 1]);


		String[] tti_array = { "������", "��", "��", "����", "��", "��", "ȣ����", "�䳢", "��", "��", "��", "��" };
		System.out.printf("%d��� %S��\n", year, tti_array[tti_index]);
		
		int [] mr1= {6, 4, 5, 1, 2, 3};
		MyArray.displayArray(mr1);
		// �ڹ� ����  API�� arrays class
		Arrays.sort(mr1); // �⺻������ ��������
		MyArray.displayArray(mr1);
	}
		
		//Ascending (��->��): asc
		//Sedending (��->��): desc
		
		// ����� �𼾵�  ����
/*		if )mr [i]> mr[k]){
			nr[i]= mr[k]*/
		
		
		//��������
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
			
			for(int i=0;i<mm.length;i++) {       //��÷�� i= 0 1 2 ...
				for(int k=0;k<mm[i].length;k++) {//��÷�� k= 0 1 2 ...
					System.out.printf("%4d",mm[i][k]);
				}
				System.out.println();//�ٹٲٱ�
			}
		}
		
		public static void setArray(int [][] mm) {
			
			int su = 1;
			for(int i=0;i<mm.length;i++) {       //��÷�� i= 0 1 2 ...
				for(int k=0;k<mm[i].length;k++) {//��÷�� k= 0 1 2 ...
					mm[i][k] = su++;
				}
			}
		}
		

}
