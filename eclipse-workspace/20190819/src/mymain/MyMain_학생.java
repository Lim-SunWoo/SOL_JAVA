package mymain;

import myutil.����л�;
import myutil.���л�;
import myutil.�ʵ��л�;
import myutil.�л�;

public class MyMain_�л� {
	
	static void ������ (�л� [] student_array) {
		// ���� loop
		for (�л� student: student_array) {
			student.�����Ѵ�(); // �л�����
			// ����� �ϳ��ε� ��ɿ� ���� ó���ϴ� ������ �پ��� -> ������. 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		�л� st1 = new �ʵ��л�();
		�л� st2 = new ���л�();
		�л� st3 = new ����л�();

		// Ȥ�� �л�[]�� �޾Ƶ� ��.
		�л�[] student_array = { new �ʵ��л�(), new ���л�(), new ����л�() };
		
		������(student_array);
	}
}
