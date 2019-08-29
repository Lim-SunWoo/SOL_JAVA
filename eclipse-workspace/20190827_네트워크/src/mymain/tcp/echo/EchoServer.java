package mymain.tcp.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// ����(����)���� ����
		ServerSocket server = new ServerSocket(7000);

		System.out.println("--���� �����...--");
		
		while (true) {

			// ���Ӵ��->���ť�������� ��������->�ڼ��ϻ���->����
			Socket child = server.accept();

			// ���� �ּ� �˾Ƴ��� -> �����͸� ���� ���� ���� ����
			// InetAddress ia = child.getInetAddress();
			// System.out.printf("[%s]���� �����ϼ̽��ϴ�.\n", ia.getHostAddress()); // ip
			
			// child -> ������ ����
			InputStream is = child.getInputStream();
			// ���� : � ���� �ӽ÷� ����Ǵ� ���
			byte[] buff = new byte[100];
			int len = is.read(buff); // len: �о�� byte ��
			
			String readStr = new String(buff, 0, len); // hello�� ������ ����. 0,len�� ���� �� �ڿ� 95���� �� ������ ����.
			
			System.out.printf("������ �о�� ������: %s\n", readStr);
			
			//���� �����͸� �ٷ� �����Ѵ�. (Echo)
			OutputStream os = child.getOutputStream();
			os.write(readStr.getBytes());
			
			
			
		}

	}

}
