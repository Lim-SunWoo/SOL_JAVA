package mymain.input;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class _2_Neteork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String str_url = "https://www.naver.com/";
			URL  url = new URL(str_url);
			
			InputStream is = url.openStream();
			
			//��Ʈ��ũ�κ��� �о����
			while(true) {
				try {
					
					int ch = is.read();
					if(ch==-1)break;// Network ���� ������ -1
					System.out.printf("%c",ch);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					break;
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
