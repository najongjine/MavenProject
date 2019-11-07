package com.biz.network.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * 네웤에서 클라이언트의 개념:
 * 필요에 따라 서버에게 무엇인가를 요청을하고 결과를 기다리는 구조
 * 
 */
public class SingleClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String serverIP="192.168.123.45"; //접속하고자 하는 서버ip
		int serverPort=8085; //접속하고자하는 서버 port
		Socket mySocket=new Socket(serverIP,serverPort);
		Scanner scanner=new Scanner(System.in);
		
		//server에서 전송되어올 메시지를 수신하기 위해서
		InputStream is=mySocket.getInputStream();
		DataInputStream data=new DataInputStream(is);
		
		//server에게 메시지를 전송하기 위해서 서버랑 파이프 같은거 연결
		// new Socket(x,y)에서 이미 서버정보 입력 받았음
		OutputStream os=mySocket.getOutputStream(); 
		
		String msg="";
		while(true) {
			System.out.print(">>");
			String sendMsg=scanner.nextLine();
			
			//server에게 보낼 문자열을 byte형식의 배열값을 변환하기위해
			//임시로 사용할 메모리 버퍼 선언
			//키보드에서 입력된 문자열을 UTF-8 방식으로 encoding하여 buffer 배열변수에 저장
			byte[] buffer=sendMsg.getBytes("UTF-8");
			os.write(buffer);
			//msg=data.readUTF();
			//System.out.println("server: "+msg);
		}
	}

}
