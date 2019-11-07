package com.biz.network.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLReaderV2 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL callor=new URL("https://callor.com:12200/main?name=korea");
		
		System.out.println("protocol: "+callor.getProtocol());
		System.out.println("authority: "+callor.getAuthority());
		System.out.println("host: "+callor.getHost());
		System.out.println("port: "+callor.getPort());
		System.out.println("path: "+callor.getPath());
		System.out.println("Query: "+callor.getQuery());
		System.out.println("file: "+callor.getFile());
		System.out.println("reference: "+callor.getRef());
	}

}
