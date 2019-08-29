package mymain.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class _2_Neteork3 {

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

			BufferedReader br = new BufferedReader(isr);

			// 네트워크로부터 읽어오기

			while (true) {
				try {

					String readStr = br.readLine(); // 한줄 단위로 읽어오기
					if (readStr == null)
						break;
					System.out.println(readStr);

					Thread.sleep(500);

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
