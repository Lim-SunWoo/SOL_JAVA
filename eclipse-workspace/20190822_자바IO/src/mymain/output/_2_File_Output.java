package mymain.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class _2_File_Output {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			OutputStream os = new FileOutputStream("a.txt");

			PrintStream out = new PrintStream(os);

			out.println("화일저장");
			out.printf("이름: %s\n","홍길동");
			out.printf("나이: %d(살)",22);
			out.printf("키: %.1f(cm)",180.5);
			out.printf("결혼유무: %B\n", true);

			// CSV
			out.printf("%s, %d, %.1f \n", "홍길동", 33, 19.2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
