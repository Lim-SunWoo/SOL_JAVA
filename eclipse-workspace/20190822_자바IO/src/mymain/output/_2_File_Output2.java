package mymain.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class _2_File_Output2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			OutputStream os = new FileOutputStream("a.txt");

			os.write("æ»≥Á«œººø‰\n".getBytes());

			os.write(String.valueOf(123).getBytes());

			os.write('\n');

			os.write(String.valueOf(true).getBytes());

			os.write('\n');

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
