package mymain.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class _2_Neteork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// InputStream is = System.in;// ����Ʈ ������ ���� -> 2����Ʈ ������ �ѱ��� ����.

		// InputStreamReader isr = new InputStreamReader(is); // ch������ ����. -> 2����Ʈ�� �ѱ۵�
		// �ȱ���.
		// ��Ʈ��ũ�� ���ڵ��� �ȸ����� �����⵵ ��. (ex UTF)

		try {
			String str_url = "https://www.naver.com/";
			URL url = new URL(str_url);

			InputStream is = url.openStream();

			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			// ��Ʈ��ũ�κ��� �о����

			while (true) {
				try {

					int ch = isr.read();
					if (ch == -1)
						break;// Network ���� ������ -1
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
