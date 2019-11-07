package com.biz.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * network 환경에서 서버의 역활
 * 1. 프로세스가 시작되서 client의 접속이 있을때까지 무한정 기다림.
 *  가.ServerSocket 생성
 *  ㄴ.accept(): 접속대기
 *  ㄷ. Client의 접속이 오면 그에따른 응답 수행.
 */
public class SingleServer {

	public static void main(String[] args) throws IOException {
		//현재 클래스를 서버로 사용하기 위해 네트워크 layer의 전송계층의
		//접속정보를 생성
		//localhost를 기반으로 8085 port에서 클라이언트의 응답을 기다리기 위해 객체 생성
		ServerSocket server=new ServerSocket(8085);
		System.out.println("server wait...");
		
		//클라이언트의 응답을 기다리기 
		//blokcing이 되면서 누군가 네트워크를 통해서 접속하기를 기다리기
		//클라이언트가 접속을하면 클라이언트 정보가 담긴 또다른 socket 객체를 return 하도록 되어있다.
		//client 객체에는 접속한 client에 대한 여러가지 정보가 담겨있다.
		Socket client=server.accept();
		String clientAddr=client.getInetAddress().toString();
		String clientPort=client.getLocalPort()+"";
		System.out.println("Client IP: "+clientAddr);
		System.out.println("Client Port: "+clientPort);
	}
}
