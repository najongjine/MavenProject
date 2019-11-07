package com.biz.network.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerThreadEx02 {
	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket();
		InetSocketAddress iSocket=new InetSocketAddress(8085);
		server.bind(iSocket);
		ServerThreadV2 tServer=new ServerThreadV2(server);
		Thread tRun=new Thread(tServer);
		
		tRun.start();
		
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.print(">>");
			String strSend=scanner.nextLine();
		}
		
	}
}
