package mymain;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test_InetAddress {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// 도메인 구하는 법
		String host = "www.naver.com"; // =210.89.160.88

		InetAddress ia = InetAddress.getByName(host);
		
		String ip_address = ia.getHostAddress();
		
		System.out.printf("[%s] : %s\n" ,host, ip_address);
		

	}

}
