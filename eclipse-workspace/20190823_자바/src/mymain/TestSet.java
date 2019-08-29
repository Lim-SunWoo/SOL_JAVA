package mymain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set ���� ������� ����, �����ϴ� ��ü
		// ���� �� ���� �ȵ�.
		// Hash Set �������� ����
		// Tree Set ����� ����
		// �ڹ��� ��� ��ü ������� (��ü�� ����)
		// Map: key, Value

		// interface = calss ����
		Set set1 = new HashSet();
		Set set2 = new TreeSet();

		// set1�̶�� �ٱ��Ͽ� set2��� �ٱ���
		set1.add(3);
		set2.add(3);

		set1.add(8);
		set2.add(8);

		set1.add(20);
		set2.add(20);

		set1.add(3);
		set2.add(3);

		set1.add(8);
		set2.add(8);

		set1.add(2);
		set2.add(2);

		set1.add(14);
		set2.add(14);

		set1.add(9);
		set2.add(9);

		set1.add(47);
		set2.add(47);

		set1.add(25);
		set2.add(25);

		set1.add(74);
		set2.add(74);

		set1.add(5);
		set2.add(5);

		set1.add(37);
		set2.add(37);

		set1.add(100); // (X)
		// Auto-Boxing : �⺻���ڷ����� ��ü������ ����(JKD 5.0)
		set1.add(new Integer(100));
		// set1.add(new Double(1.5));//set1.add(1.5);
		// set1.add(new String("�ȳ�"));

		System.out.println(set1.toString());
		System.out.println(set2.toString());

		// ��ü�� �ȵ����� ����䤡�̵Ǿ ���⵵ ��.
		// �⺻ �ڷ����� ��ü������ ����.

		// ������ ���(Element)����
		// ���1 : ���� loop
		for (Object ob : set1) {
			Integer n = (Integer) ob;
			System.out.print(n + " ");
		}
		System.out.println();

		// ���2 : iterator :��(Ž)����
		Iterator it = set1.iterator(); // Collection�� ���� ��ü������ Object Type���� ����
		while (it.hasNext()) {
			Object ob = it.next();// ���� �����´�
			Integer n = (Integer) ob;
			System.out.println(n + "");

		}System.out.println();		
		//Generic �÷����� ���� Ÿ���� ����
		
		Set <Integer> lottoSet = new TreeSet<Integer>();
		//lottoSet.add("����ǳ�?"); // ���̤���������aks tkdydgkehfhr tjfwjd
		
		
		Random rand = new Random();
		int count=6;
	
		while (count>0) {
			int su= rand.nextInt(45)+1;
			if (lottoSet.add(su)==false) continue; // ������ ���� ������ �ٽ��ض�.
		}
	}

}
