package my_main;

import my_util.MyLine;

public class MyMain_Method2 {

	public static void main(String[] args) {
		
		int line_len= 30;
		
		// TODO Auto-generated method stub
		
			System.out.printf("%21s", "---��������---\n");
			//System.out.println("------------------");
			MyLine.draw_line(line_len,"="); // �������̽� �ڵ� ����Ʈ
			System.out.println("��ȣ �̸�    ���� ���� ����   ����");
			System.out.println("  1  �ϱ浿    99   88    77    234");
			System.out.println("  2  �̱浿    89   98    57    224");
			MyLine.draw_line(line_len, "-");
			System.out.println(" ��              188  186  134   508");
			
			//+���ο� �������� ���߱�
			int n1=1, n2=2;
			MyLine.draw_line(line_len,n1, "-",n2,"*");

	}
}
