package mymain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.PersonVo;

public class TestMap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �̸� PersonVo
		Map<String, PersonVo> personMap = new HashMap<String, PersonVo>();
		List<PersonVo> p_list = new ArrayList<PersonVo>();

		for (int i = 1; i <= 100; i++) {

			String name = String.format("�浿_%03d", i);
			int age = 20 + i % 11;
			String addr = String.format("���� ���� ��ö%d��", i % 3 + 1);

			PersonVo p = new PersonVo(name, age, addr);
			// Map�߰�
			personMap.put(name, p);
			// ArrayList�߰�
			p_list.add(p);
		}

		// Map�̿��� �˻�
		String find_name = "�浿_088";
		PersonVo find_p = personMap.get(find_name);
		System.out.println(find_p);

		// ArrayList�̿��� �˻�
		int count = 0;
		for (PersonVo p : p_list) {
			count++;
			if (p.getName().equals(find_name)) {
				System.out.println(count + "��° �˻��Ϸ�");
				System.out.println(p);
				break;
			}
		}

	}

}
