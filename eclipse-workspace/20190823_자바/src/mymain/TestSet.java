package mymain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set 순서 상관없이 저장, 관리하는 객체
		// 동일 값 저장 안됨.
		// Hash Set 순서없이 추출
		// Tree Set 추출시 정렬
		// 자바의 모든 객체 저장관리 (객체만 저장)
		// Map: key, Value

		// interface = calss 생성
		Set set1 = new HashSet();
		Set set2 = new TreeSet();

		// set1이라는 바구니와 set2라는 바구니
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
		// Auto-Boxing : 기본형자료형을 객체형으로 포장(JKD 5.0)
		set1.add(new Integer(100));
		// set1.add(new Double(1.5));//set1.add(1.5);
		// set1.add(new String("안녕"));

		System.out.println(set1.toString());
		System.out.println(set2.toString());

		// 갱체는 안들어가지만 오토밥ㄱ싱되어서 들어가기도 함.
		// 기본 자료형을 객체형으로 포장.

		// 각각의 요소(Element)추출
		// 방법1 : 개선 loop
		for (Object ob : set1) {
			Integer n = (Integer) ob;
			System.out.print(n + " ");
		}
		System.out.println();

		// 방법2 : iterator :검(탐)색자
		Iterator it = set1.iterator(); // Collection은 몯ㄴ 객체정보를 Object Type으로 저장
		while (it.hasNext()) {
			Object ob = it.next();// 값을 가져온다
			Integer n = (Integer) ob;
			System.out.println(n + "");

		}System.out.println();		
		//Generic 컬랙션의 저장 타입을 지정
		
		Set <Integer> lottoSet = new TreeSet<Integer>();
		//lottoSet.add("저장되나?"); // ㅑㅜㅅㄷㅎㄷㄱaks tkdydgkehfhr tjfwjd
		
		
		Random rand = new Random();
		int count=6;
	
		while (count>0) {
			int su= rand.nextInt(45)+1;
			if (lottoSet.add(su)==false) continue; // 동일한 수가 있으면 다시해라.
		}
	}

}
