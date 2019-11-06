package com.biz.Maven05_NetWork.exec;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetEx01 {

	public static void main(String[] args) throws IOException {
		/*
		 * Inet.getByName()
		 * www.naver.com: domain name을
		 * dns에게 조회하여 ip Adress를 가져오는 method 
		 */
		InetAddress naver=InetAddress.getByName("www.naver.com");
		System.out.println(naver);
		
		InetAddress daum=InetAddress.getByName("www.daum.net");
		System.out.println(daum);
		
		System.out.println(naver.getHostAddress());
		System.out.println(naver.getHostName());
		
		//내 컴퓨터 NIC(Network Interface Card, 랜카드)
		//에 설정된 IP
		InetAddress local=InetAddress.getLocalHost();
		
		//내 컴퓨터 내부의 App들이 서로 통신을 하거나
		//통신 test용으로 만들어진 특별한 IP
		InetAddress loopBack=InetAddress.getLoopbackAddress();
		
		System.out.println("local: "+local);
		System.out.println("loopBack: "+loopBack);
		
		/*
		 * port
		 * TCP/IP 프로토콜에서 1개의 IP주소에 다수의 어플리케이션이
		 * 통신할수 있도록 하는 구조
		 * 0~65535 까지 사용할수 있고
		 * 그중 0~1023까지는 임의로 사용할수 없도록 정해져 있다.
		 * 사용자가 port를 임의로 설정하여 사용하면 1개의 컴퓨터에서 여러개의 통신 어플을
		 * 작동시킬수 있다.
		 */
	}

}
