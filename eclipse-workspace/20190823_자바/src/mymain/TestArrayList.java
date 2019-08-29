package mymain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestArrayList {

	// List <- Interface*** ����Ʈ�� ����
	// ArrayList
	// Linked List
	// Stack/ Vecter
	/*
	 * ������ �ִ� ������� ��ü �������� ��Ұ� ����
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> fruit_list = new ArrayList<String>();

		System.out.printf("fruit_list's size = %d\n", fruit_list.size());

		fruit_list.add("���");
		fruit_list.add("��");
		fruit_list.add("����");
		fruit_list.add("����");

		System.out.printf("fruit_list's size2 = %d\n", fruit_list.size());

		// ��¹��1
		for (int i = 0; i < fruit_list.size(); i++) { // i= 0,1,2,3
			String fruit = fruit_list.get(i);
			System.out.print(fruit + " ");
		}
		System.out.println();

		// ���� ����2
		fruit_list.remove(2);

		// ��� ���2

		for (String fruit : fruit_list) {
			System.out.print(fruit + " ");
		}
		System.out.println();

		// ��� ����
		fruit_list.clear();
		System.out.printf("fruit_list's size3 = %d\n", fruit_list.size());
		System.out.println();

		// ArrayList�̿��� �ζ�

		List<Integer> total_list = new ArrayList<Integer>();
		for (int i = 1; i <= 45; i++)
			total_list.add(i);

		// ��÷
		List<Integer> lotto_list = new ArrayList<Integer>();
		Random rand = new Random();
		int count = 6;
		while (count > 0) {
			// �����ִ� �͵� �߿��� �ε��� ���� -> �ߺ�üũ X
			int index = rand.nextInt(total_list.size());
			lotto_list.add(total_list.get(index));
			total_list.remove(index);
			count--;
		}
		Collections.sort(lotto_list);// �������
		System.out.println(lotto_list);
	}
}
