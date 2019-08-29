package mymain;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\Soldesk\\eclipse-workspace");
		
		File create_f = new File("C:\\Users\\Soldesk\\eclipse-workspace\\MyFolder");
		if(!create_f.exists()) // 존재하냐 -> 없냐?
			create_f.mkdir();
		
		if(create_f.exists()) // 존재하냐 -> 없냐?
				create_f.delete();

		// 해당 폴더 내의 파일 정보를 추출하는 것이 가능.
		File[] f_array = f.listFiles(); // 폴더 내의 파일 목록을 가져옴.

		for (File ff : f_array) { // f_array가 정보를 가져와서 ff에게 넘겨줌.
			String type = "";
			if (ff.isDirectory())
				type = "D";
			else if (ff.isHidden())
				type = "H";
			else if (ff.isFile())
				type = "F";
			else if (ff.isAbsolute())
				type = "A";

			// 파일명
			String filename = ff.getName();

			// 크기
			long size = ff.length(); // byte단위

			System.out.printf("[%s] %s(%d)\n", type, filename, size);

		}
	}

}
