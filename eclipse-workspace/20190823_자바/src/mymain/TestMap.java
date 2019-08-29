package mymain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class TestMap {
	/*
	 * HashMap TreeMap HashTable(������ ���
	 * 
	 * 1. key.value�� ������ ��������ϴ� ��ü
	 * 
	 * 2. key���� -> Set
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> telMap = new HashMap<Integer, String>(); // < KeY, VALUE >
		telMap.put(1, "010-1111-1234");
		telMap.put(2, "010-2222-1234");
		telMap.put(3, "010-3333-1234");
		telMap.put(4, "010-4444-1234");
		telMap.put(5, "010-5555-1234");

		int short_number = 3;
		String tel = telMap.get(short_number);
		System.out.printf("�����ȣ %d = %s\n", short_number, tel);

		// Map �� ��� ��� ���
		Set<Integer> numberSet = telMap.keySet();
		for (Integer key : numberSet) {

			String tel1 = telMap.get(key);
			System.out.printf("�����ȣ %d -> %s\n", key, tel1);
		}

	}

}
