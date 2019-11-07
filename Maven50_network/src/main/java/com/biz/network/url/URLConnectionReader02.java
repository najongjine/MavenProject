package com.biz.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConnectionReader02 {
	public static void main(String[] args) throws IOException {
		//일부 site는 주소를 직접 url로 요청하면 주소변환 과정등 문제로 접속이 불가능하다.
		//이때는 주소를 utf-8로 encoding을 수행해 주어야 한다.
		String naverURL="https://naver.com/";
		String encNaverURL=URLEncoder.encode(naverURL,"UTF-8");
		URL naver=new URL(naverURL);
		URLConnection naverOpen=naver.openConnection();
		
		//url에 설정된 url문자열을 사용하지 말고
		//outputstream으로 전송된 encoding url 문자열을 사용하여 서버에 접속하라
		naverOpen.setDoOutput(true);
		
		//살제로 사용하지 않아도 xxStream이 작동될때마다 내부적으로 자동으로 수행되는 코드
		naverOpen.connect();
		
		//URL Encoding에ㅐ 문제가 있을경우ㅠ Encoding된 url string outputstreamwriter로 재 전송.
		OutputStreamWriter out=new OutputStreamWriter(naverOpen.getOutputStream());
		out.write(encNaverURL);
		out.close();
		BufferedReader buffer=new BufferedReader(new InputStreamReader(naverOpen.getInputStream()));
		String reader="";
		while(true) {
			reader=buffer.readLine();
			if(reader==null) break;
			System.out.println(reader);
		}
		buffer.close();
	}
}
