package mymain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestArrayList {

	// List <- Interface*** 임포트시 주의
	// ArrayList
	// Linked List
	// Stack/ Vecter
	/*
	 * 순서가 있는 저장관리 객체 동적으로 요소가 증감
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> fruit_list = new ArrayList<String>();

		System.out.printf("fruit_list's size = %d\n", fruit_list.size());

		fruit_list.add("사과");
		fruit_list.add("배");
		fruit_list.add("참외");
		fruit_list.add("수박");

		System.out.printf("fruit_list's size2 = %d\n", fruit_list.size());

		// 출력방법1
		for (int i = 0; i < fruit_list.size(); i++) { // i= 0,1,2,3
			String fruit = fruit_list.get(i);
			System.out.print(fruit + " ");
		}
		System.out.println();

		// 제거 참외2
		fruit_list.remove(2);

		// 출력 방법2

		for (String fruit : fruit_list) {
			System.out.print(fruit + " ");
		}
		System.out.println();

		// 모두 제거
		fruit_list.clear();
		System.out.printf("fruit_list's size3 = %d\n", fruit_list.size());
		System.out.println();

		// ArrayList이용한 로또

		List<Integer> total_list = new ArrayList<Integer>();
		for (int i = 1; i <= 45; i++)
			total_list.add(i);

		// 추첨
		List<Integer> lotto_list = new ArrayList<Integer>();
		Random rand = new Random();
		int count = 6;
		while (count > 0) {
			// 남아있는 것들 중에서 인덱스 추출 -> 중복체크 X
			int index = rand.nextInt(total_list.size());
			lotto_list.add(total_list.get(index));
			total_list.remove(index);
			count--;
		}
		Collections.sort(lotto_list);// 순서대로
		System.out.println(lotto_list);
	}
}
