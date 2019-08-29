package mymain.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class _2_Neteork3 {

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

			BufferedReader br = new BufferedReader(isr);

			// ��Ʈ��ũ�κ��� �о����

			while (true) {
				try {

					String readStr = br.readLine(); // ���� ������ �о����
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
