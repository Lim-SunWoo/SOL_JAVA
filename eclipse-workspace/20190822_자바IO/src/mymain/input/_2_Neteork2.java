package mymain.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class _2_Neteork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// InputStream is = System.in;// 바이트 단위로 읽음 -> 2바이트 단위인 한글은 깨짐.

		// InputStreamReader isr = new InputStreamReader(is); // ch단위로 읽음. -> 2바이트인 한글도
		// 안깨짐.
		// 네트워크는 인코딩이 안맞으면 깨지기도 함. (ex UTF)

		try {
			String str_url = "https://www.naver.com/";
			URL url = new URL(str_url);

			InputStream is = url.openStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			// 네트워크로부터 읽어오기

			while (true) {
				try {

					int ch = isr.read();
					if (ch == -1)
						break;// Network 끝을 만나면 -1
					System.out.printf("%c", ch);

					Thread.sleep(10);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					break;
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
