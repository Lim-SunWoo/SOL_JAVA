package mymain.output;

import java.io.IOException;
import java.io.OutputStream;

public class _1_Moniter_Output {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			OutputStream os = System.out;

			os.write(65);
			String str_double = "10.5";
			// String -> Byte
			os.write(str_double.getBytes());
			os.write("123".getBytes());
			
			os.write(String.valueOf(123).getBytes());
			os.write(String.valueOf(true).getBytes());
			
			// 버퍼내용을 출력장치로 전송
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
