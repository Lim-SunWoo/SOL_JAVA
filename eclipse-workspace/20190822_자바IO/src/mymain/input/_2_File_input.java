package mymain.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class _2_File_input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = null;
		try {
			is = new FileInputStream("src/mymian/input._2_File_input.java");
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
