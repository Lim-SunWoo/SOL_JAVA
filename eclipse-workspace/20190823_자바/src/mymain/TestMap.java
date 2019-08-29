package mymain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class TestMap {
	/*
	 * HashMap TreeMap HashTable(예전에 사용
	 * 
	 * 1. key.value한 쌍으로 저장관리하는 객체
	 * 
	 * 2. key집합 -> Set
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
		System.out.printf("단축번호 %d = %s\n", short_number, tel);

		// Map 의 모든 요소 출력
		Set<Integer> numberSet = telMap.keySet();
		for (Integer key : numberSet) {

			String tel1 = telMap.get(key);
			System.out.printf("단축번호 %d -> %s\n", key, tel1);
		}

	}

}
