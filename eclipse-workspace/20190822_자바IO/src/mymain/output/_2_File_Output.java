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

			out.println("ȭ������");
			out.printf("�̸�: %s\n","ȫ�浿");
			out.printf("����: %d(��)",22);
			out.printf("Ű: %.1f(cm)",180.5);
			out.printf("��ȥ����: %B\n", true);

			// CSV
			out.printf("%s, %d, %.1f \n", "ȫ�浿", 33, 19.2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
