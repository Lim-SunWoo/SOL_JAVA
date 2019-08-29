package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.omg.PortableInterceptor.ObjectIdHelper;

import vo.PersonVo;

public class MyMain_직렬화 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 직렬화 처리
		PersonVo p = new PersonVo("홍길동", 30, "서울 종로구 종각");
		FileOutputStream fos = new FileOutputStream("person.dat");
		// 직렬화처리 객체
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// 저장
		oos.writeObject(p);

		/*
		 * // 화일닫기 (역순) oos.close(); fos.close();
		 */
		FileInputStream fis = new FileInputStream("person.dat");
		// 역직렬화객체
		ObjectInputStream ois = new ObjectInputStream(fis);

		PersonVo p1 = (PersonVo) ois.readObject();
		
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getAddr());


		// 화일닫기 (역순)
		oos.close();
		fos.close();
		
		// 직렬화가 가능한 객체는 impliment ~ 가 붙어있음.
		
		

		
		
	}

}
