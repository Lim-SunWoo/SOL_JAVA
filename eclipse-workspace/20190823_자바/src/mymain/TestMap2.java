package mymain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.PersonVo;

public class TestMap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 이름 PersonVo
		Map<String, PersonVo> personMap = new HashMap<String, PersonVo>();
		List<PersonVo> p_list = new ArrayList<PersonVo>();

		for (int i = 1; i <= 100; i++) {

			String name = String.format("길동_%03d", i);
			int age = 20 + i % 11;
			String addr = String.format("서울 종로 관철%d동", i % 3 + 1);

			PersonVo p = new PersonVo(name, age, addr);
			// Map추가
			personMap.put(name, p);
			// ArrayList추가
			p_list.add(p);
		}

		// Map이용한 검색
		String find_name = "길동_088";
		PersonVo find_p = personMap.get(find_name);
		System.out.println(find_p);

		// ArrayList이용한 검색
		int count = 0;
		for (PersonVo p : p_list) {
			count++;
			if (p.getName().equals(find_name)) {
				System.out.println(count + "번째 검색완료");
				System.out.println(p);
				break;
			}
		}

	}

}
