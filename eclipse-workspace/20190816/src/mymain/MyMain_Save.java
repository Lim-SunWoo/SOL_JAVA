package mymain;

import myutil.Save;

public class MyMain_Save {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Save.rate = 0.1; // static������ ���� �����ڰ� ����.
		// Ŭ������, ������, �� -> static ���������� �ƴ�.
		// _1Save.name= �� X
		
		
		// static������ �޼ҵ� 1.�����ñ� ���α׷� ���� �ÿ�
		// static ������ �� ��ü�� �����ϴ� ����(���)
		// ǥ����� Ŭ������, ������ = ��: 
		// cf) ��ü ���� �� ǥ��
		//     ����������, ������ = ��;
		
		
		Save[] s_array = { new Save("�ϱ浿", 1000000), new Save("�̱浿", 2000000), new Save("��浿", 3000000) };
		
		
		System.out.printf("====rate: %.2f=====\n", Save.rate);
		for (int i = 0; i < s_array.length; i++) {
			s_array[i].display();
		}
		
		int [] su_array = {1, 2, 3, 4};
		System.out.println("----÷���̿�----");
		for(int i=0; i<su_array.length; i++) {
			System.out.println(su_array[i]);
		}
		System.out.println();
		
		System.out.println("---���� loop�̿�---");
		for (int su: su_array) {
			System.out.println(su);
		}
		System.out.println();

		
		System.out.println("---���� loop�̿�2---");
		for (Save s : s_array) {
			s.display();
		}
		System.out.println();

		// ��������: ��ü ���� ��
		// s_array[0].rate=0.2;

	}
}
