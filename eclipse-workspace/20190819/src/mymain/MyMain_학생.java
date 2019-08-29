package mymain;

import myutil.고등학생;
import myutil.중학생;
import myutil.초등학생;
import myutil.학생;

public class MyMain_학생 {
	
	static void 엄마왈 (학생 [] student_array) {
		// 개선 loop
		for (학생 student: student_array) {
			student.공부한다(); // 학생정보
			// 명령은 하나인데 명령에 따라서 처리하는 과정은 다양함 -> 다형성. 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		학생 st1 = new 초등학생();
		학생 st2 = new 중학생();
		학생 st3 = new 고등학생();

		// 혹은 학생[]로 받아도 됨.
		학생[] student_array = { new 초등학생(), new 중학생(), new 고등학생() };
		
		엄마왈(student_array);
	}
}
