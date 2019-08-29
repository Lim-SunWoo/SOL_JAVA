package mymain;

import java.net.InetAddress;

public class Test_InetAddress {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        String host = "www.naver.com";
		//String host = "www.daum.net";
		//String host = "172.168.0.100";
		InetAddress ia = InetAddress.getByName(host);
		String ip_address = ia.getHostAddress(); 
		
		System.out.printf("[%s] : %s\n", host , ip_address);
		
		
		
	}

}
