package mymain.tcp.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// �����û
		Socket client = new Socket("172.16.7.100", 7000);

		String msg = "";

		// ���� ��Ʈ�� ���
		OutputStream os = client.getOutputStream();

		// String -> Byte�迭�� [] ��ȯ�ؼ� ����
		os.write(msg.getBytes());

		// ������ ����
		InputStream is = client.getInputStream();
		byte[] buff = new byte[100];
		// len : �о�� byte��
		int len = is.read(buff);

		String readStr = new String(buff, 0, len); // "hello"
		System.out.printf("������ �ٽ� �Ѿ�� ������ : %s\n", readStr);

	}

}
