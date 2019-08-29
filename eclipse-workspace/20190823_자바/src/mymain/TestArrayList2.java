package mymain;

import java.util.ArrayList;
import java.util.List;

import vo.PersonVo;

public class TestArrayList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<PersonVo> p_list = new ArrayList<PersonVo>();

		p_list.add(new PersonVo("일길동", 21, "서울 종로 관철1"));
		p_list.add(new PersonVo("이길동", 22, "서울 종로 관철2"));
		p_list.add(new PersonVo("삼길동", 23, "서울 종로 관철3"));
		p_list.add(new PersonVo("사길동", 24, "서울 종로 관철4"));
		p_list.add(new PersonVo("오길동", 25, "서울 종로 관철5"));

		// 개선 loop

		for (PersonVo p : p_list) {
			System.out.println(p);
		}

		// 첨자이용
		System.out.println("---첨자이용---");
		for (int i = 0; i < p_list.size(); i++) {
			PersonVo p = p_list.get(i);
			System.out.println(p);
		}
	}
}
