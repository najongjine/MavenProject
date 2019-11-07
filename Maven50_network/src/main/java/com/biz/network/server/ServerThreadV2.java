package com.biz.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThreadV2 implements Runnable {
	ServerSocket server;
	
	public ServerThreadV2(ServerSocket server) {
		super();
		// TODO Auto-generated constructor stub
		this.server=server;
	}

	public void run() {
		Socket client=null;
		try {
			int id=0;
			while(true) {
				//int id=(int)Math.random()*100;
				client=this.server.accept();
				ServerSubThreadV1 ss=new ServerSubThreadV1(client, ++id);
				Thread tRun=new Thread(ss);
				tRun.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
