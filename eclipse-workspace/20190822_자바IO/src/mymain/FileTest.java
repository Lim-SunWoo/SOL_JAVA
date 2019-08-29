package mymain;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\Soldesk\\eclipse-workspace");
		
		File create_f = new File("C:\\Users\\Soldesk\\eclipse-workspace\\MyFolder");
		if(!create_f.exists()) // �����ϳ� -> ����?
			create_f.mkdir();
		
		if(create_f.exists()) // �����ϳ� -> ����?
				create_f.delete();

		// �ش� ���� ���� ���� ������ �����ϴ� ���� ����.
		File[] f_array = f.listFiles(); // ���� ���� ���� ����� ������.

		for (File ff : f_array) { // f_array�� ������ �����ͼ� ff���� �Ѱ���.
			String type = "";
			if (ff.isDirectory())
				type = "D";
			else if (ff.isHidden())
				type = "H";
			else if (ff.isFile())
				type = "F";
			else if (ff.isAbsolute())
				type = "A";

			// ���ϸ�
			String filename = ff.getName();

			// ũ��
			long size = ff.length(); // byte����

			System.out.printf("[%s] %s(%d)\n", type, filename, size);

		}
	}

}
