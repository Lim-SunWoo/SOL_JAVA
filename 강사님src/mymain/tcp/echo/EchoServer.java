package mymain.tcp.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        
		//서버(리슨)소켓 생성
		ServerSocket server = new ServerSocket(7000);
		
		System.out.println("--서버 대기중...--");
		while(true) {
			
			//접속대기->대기큐접속정보 가져오기->자소켓생성->연결
			Socket child = server.accept();
			
			//상대방 주소 알아내기
			//InetAddress ia = child.getInetAddress();
			//System.out.printf("[%s]님 접속\n", ia.getHostAddress());
			
			//child ->데이터 수신
			InputStream is = child.getInputStream();
			byte []  buff = new byte[100];
			//  len : 읽어온 byte수
			int len = is.read(buff);
			
			String readStr = new String(buff,0,len); // "hello"
			System.out.printf("서버측 읽어온 데이터 : %s\n",readStr);
			
			//수신데이터를 반환(Echo)
			OutputStream os = child.getOutputStream();
			os.write(readStr.getBytes());
			
			
			
		}
        
		
		
	}

}
