package mymain;

import java.util.ArrayList;
import java.util.List;

import vo.PersonVo;

public class TestArrayList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<PersonVo> p_list = new ArrayList<PersonVo>();

		p_list.add(new PersonVo("�ϱ浿", 21, "���� ���� ��ö1"));
		p_list.add(new PersonVo("�̱浿", 22, "���� ���� ��ö2"));
		p_list.add(new PersonVo("��浿", 23, "���� ���� ��ö3"));
		p_list.add(new PersonVo("��浿", 24, "���� ���� ��ö4"));
		p_list.add(new PersonVo("���浿", 25, "���� ���� ��ö5"));

		// ���� loop

		for (PersonVo p : p_list) {
			System.out.println(p);
		}

		// ÷���̿�
		System.out.println("---÷���̿�---");
		for (int i = 0; i < p_list.size(); i++) {
			PersonVo p = p_list.get(i);
			System.out.println(p);
		}
	}
}
