package mymain.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _2_File_input2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = null;

		try {

			is = new FileInputStream("src/mymain/input/_2_File_Input2.java");

			// InputStream -> InputStreamReader filter
			// byte -> char
			InputStreamReader isr = new InputStreamReader(is);

			// 화일읽기
			while (true) {
				try {

					int ch = isr.read();
					if (ch == -1)
						break;// File EOF(End of File)=> -1
					System.out.printf("%c", ch);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					break;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}