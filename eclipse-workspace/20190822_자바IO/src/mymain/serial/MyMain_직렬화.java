package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.omg.PortableInterceptor.ObjectIdHelper;

import vo.PersonVo;

public class MyMain_����ȭ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// ����ȭ ó��
		PersonVo p = new PersonVo("ȫ�浿", 30, "���� ���α� ����");
		FileOutputStream fos = new FileOutputStream("person.dat");
		// ����ȭó�� ��ü
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// ����
		oos.writeObject(p);

		/*
		 * // ȭ�ϴݱ� (����) oos.close(); fos.close();
		 */
		FileInputStream fis = new FileInputStream("person.dat");
		// ������ȭ��ü
		ObjectInputStream ois = new ObjectInputStream(fis);

		PersonVo p1 = (PersonVo) ois.readObject();
		
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getAddr());


		// ȭ�ϴݱ� (����)
		oos.close();
		fos.close();
		
		// ����ȭ�� ������ ��ü�� impliment ~ �� �پ�����.
		
		

		
		
	}

}
