package ex;

public class _1if {
	public static void main (String args[]) {
		int eng = 70;
		String res ="���հ�";
		if (eng >= 60)  res = "�հ�";
		
		System.out.printf("%d���̰� %s �Դϴ�.\n", eng, res);
		
		
		//#3
		
		int su = 5;
		
		if(su%2==0 && su%3==0) { // ; ���� 
			System.out.printf("%d�� 2�� ���\n", su);
			System.out.printf("%d�� 3�� ���\n", su);
		}
		else System.out.println("������ ���� �ʽ��ϴ�. \n");
		
		
		// #4
		
		int kor = 80;
		String grade = "F";
		
		if (kor>=90&&kor<=100) grade= "A";
		else if (kor>=80&&kor<90) grade= "B";
		else if (kor>=70&&kor<80) grade= "C";
		else if (kor>=60&&kor<70) grade= "D"; // ���� if, else�� ������ �� �ʿ��� ������ ���� �� ����. >> else if �� ��.
		
		System.out.printf("[%d]�� ���: %s\n", kor, grade);
	
	
	}
	
	
	
	
}
