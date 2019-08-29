package mymain.tcp.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 서버(리슨)소켓 생성
		ServerSocket server = new ServerSocket(7000);

		System.out.println("--서버 대기중...--");
		
		while (true) {

			// 접속대기->대기큐접속정보 가져오기->자소켓생성->연결
			Socket child = server.accept();

			// 상대방 주소 알아내기 -> 데이터를 받을 때는 하지 말기
			// InetAddress ia = child.getInetAddress();
			// System.out.printf("[%s]님이 접속하셨습니다.\n", ia.getHostAddress()); // ip
			
			// child -> 데이터 수신
			InputStream is = child.getInputStream();
			// 버퍼 : 어떤 값이 임시로 저장되는 장소
			byte[] buff = new byte[100];
			int len = is.read(buff); // len: 읽어온 byte 수
			
			String readStr = new String(buff, 0, len); // hello만 가지고 있음. 0,len을 빼면 이 뒤에 95개의 빈 공간이 생김.
			
			System.out.printf("서버측 읽어온 데이터: %s\n", readStr);
			
			//수신 데이터를 바로 전송한다. (Echo)
			OutputStream os = child.getOutputStream();
			os.write(readStr.getBytes());
			
			
			
		}

	}

}
