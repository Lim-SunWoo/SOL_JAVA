package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vo.PersonVo3;

public class MyMain_직렬화3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 직렬화 처리
		PersonVo3 p = new PersonVo3("홍길동", 30, "서울 종로구 종각");
		FileOutputStream fos = new FileOutputStream("person2.dat");
		// 직렬화처리 객체
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// 저장
		oos.writeObject(p);

		// 화일닫기(역순)
		oos.close();
		fos.close();

		// 역직렬화(읽어오기)
		FileInputStream fis = new FileInputStream("person2.dat");
		// 역직렬화 객체
		ObjectInputStream ois = new ObjectInputStream(fis);

		// 읽어오기
		PersonVo3 p1 = (PersonVo3) ois.readObject();

		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getAddr());

		// 닫기(역순)
		ois.close();
		fis.close();

	}

}
