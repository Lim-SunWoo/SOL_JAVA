package mymain.serial;

// ����o�Ⱦ��� ����Ʈ ���ֱ�
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.omg.PortableInterceptor.ObjectIdHelper;

import vo.PersonVo;

public class MyMain_����ȭ_�迭 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PersonVo[] p_array = new PersonVo[100];

		// [] 100���� �迭�� PersonVo�迭�� �ƴ϶� �̰� ���� �� �ִ� ������ü �迭�̴�.��_��

		// p_array[0].getName();

		for (int i = 0; i < p_array.length; i++) {
			String name = String.format("�浿_%03d", i + 1); // �浿 001
			int age = i % 10 + 20; // ������ 0~9 -> ������� 20~29

			String addr = String.format("���� ���� %d��", i % 5 + 1);
			PersonVo p = new PersonVo(name, age, addr);

			p_array[i] = p;

			// System.out.println(p);
		}
		/*
		 * PersonVo pp = new PersonVo("�浿", 11, "����");
		 * System.out.println(pp.toString());
		 */

		/*
		 * // ����ȭ
		 * 
		 * FileOutputStream fos = new FileOutputStream("person_array.dat");
		 * ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * 
		 * // ����, �迭�� ����ȭ ��� oos.writeObject(p_array);
		 * 
		 * // ȭ�ϴݱ� (����) oos.close(); fos.close();
		 */
		// ������ȭ
		FileInputStream fis = new FileInputStream("preson_array.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// ������ �о����
		PersonVo[] p_array_restore = (PersonVo[]) ois.readObject();

		System.out.println("���� ������");
		for(PersonVo p: p_array_restore) {
			System.out.println(p);
		}
		// �ݱ�
		ois.close();
		fis.close();
		
		// ����ȭ�ּ� ���ܽ�Ű�� ���� �� 
		
		

	}

}
