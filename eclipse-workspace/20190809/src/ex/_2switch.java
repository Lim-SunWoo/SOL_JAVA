package ex;

import java.util.Scanner;

public class _2switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		String data;
		String res;
		
		System.out.println("������ �Է��Ͻÿ�");

		data = scan.nextLine();
		
		switch(data) {
		
		case "����" : res = "�޴�";
				break;
		case "����" : res = "�ÿ��ϴ�";
				break;
		case "����" : res = "���ִ�";
				break;
		case "����" : res = "�����";
				break;
		}
		
		// System.out.printf("����� �Է��� ������ %s�̰� %s�� %s\n", data, data, res);
	}

}
