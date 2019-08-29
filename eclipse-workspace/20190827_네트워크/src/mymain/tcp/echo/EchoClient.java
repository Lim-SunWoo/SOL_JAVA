package mymain.tcp.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 연결요청
		Socket client = new Socket("172.16.7.100", 7000);

		String msg = "";

		// 전송 스트림 얻기
		OutputStream os = client.getOutputStream();

		// String -> Byte배열로 [] 변환해서 전송
		os.write(msg.getBytes());

		// 데이터 수신
		InputStream is = client.getInputStream();
		byte[] buff = new byte[100];
		// len : 읽어온 byte수
		int len = is.read(buff);

		String readStr = new String(buff, 0, len); // "hello"
		System.out.printf("서버측 다시 넘어온 데이터 : %s\n", readStr);

	}

}
