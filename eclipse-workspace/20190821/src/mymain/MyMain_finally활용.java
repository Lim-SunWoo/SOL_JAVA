package mymain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyMain_finallyȰ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		try {
			fr = new FileReader("src/mymain/MyMain_finallyȰ��.java");
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		} finally { // �巡�� + Alt+Shift+z > Try Catch������ ���α�
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ������ ���� ���� �ֱ⶧���� ������. ������ ����ó�� ���ָ� �����.
		}
	}

}
