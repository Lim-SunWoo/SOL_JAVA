package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vo.PersonVo2;

public class MyMain_����ȭ2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//����ȭ ó��
		PersonVo2 p = new PersonVo2("ȫ�浿", 30, "���� ���α� ����");
		FileOutputStream  fos = new FileOutputStream("person2.dat");
		//����ȭó�� ��ü
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//����
		oos.writeObject(p);
		
		//ȭ�ϴݱ�(����)
		oos.close();
		fos.close();
		
		
		//������ȭ(�о����)
		FileInputStream fis = new FileInputStream("person2.dat");
		//������ȭ ��ü
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//�о����
		PersonVo2 p1 = (PersonVo2) ois.readObject();
		
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getAddr());
		
		
		//�ݱ�(����)
		ois.close();
		fis.close();
		
		
		
		
		
	}

}
