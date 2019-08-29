package mymain.serial;

// 컨쉬o안쓰는 임포트 없애기
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.omg.PortableInterceptor.ObjectIdHelper;

import vo.PersonVo;

public class MyMain_직렬화_배열 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PersonVo[] p_array = new PersonVo[100];

		// [] 100개의 배열은 PersonVo배열이 아니라 이걸 담을 수 있는 참조객체 배열이다.ㅔ_ㅁ

		// p_array[0].getName();

		for (int i = 0; i < p_array.length; i++) {
			String name = String.format("길동_%03d", i + 1); // 길동 001
			int age = i % 10 + 20; // 나머지 0~9 -> 결과값은 20~29

			String addr = String.format("서울 종로 %d동", i % 5 + 1);
			PersonVo p = new PersonVo(name, age, addr);

			p_array[i] = p;

			// System.out.println(p);
		}
		/*
		 * PersonVo pp = new PersonVo("길동", 11, "ㄴㄴ");
		 * System.out.println(pp.toString());
		 */

		/*
		 * // 직렬화
		 * 
		 * FileOutputStream fos = new FileOutputStream("person_array.dat");
		 * ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * 
		 * // 저장, 배열도 직렬화 대상 oos.writeObject(p_array);
		 * 
		 * // 화일닫기 (역순) oos.close(); fos.close();
		 */
		// 역직렬화
		FileInputStream fis = new FileInputStream("preson_array.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// 데이터 읽어오기
		PersonVo[] p_array_restore = (PersonVo[]) ois.readObject();

		System.out.println("복원 데이터");
		for(PersonVo p: p_array_restore) {
			System.out.println(p);
		}
		// 닫기
		ois.close();
		fis.close();
		
		// 직렬화애서 제외시키고 싶을 때 
		
		

	}

}
