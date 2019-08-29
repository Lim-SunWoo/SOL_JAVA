package mymain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyMain_finally활용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		try {
			fr = new FileReader("src/mymain/MyMain_finally활용.java");
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		} finally { // 드래그 + Alt+Shift+z > Try Catch블럭으로 감싸기
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 파일이 없을 수가 있기때문에 오류뜸. 없을시 예외처리 해주면 사라짐.
		}
	}

}
