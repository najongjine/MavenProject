package com.biz.sec.work;

import java.util.Map;
import java.util.Set;

public class SystemEnv01 {
	public static void main(String[] args) {
		//java에서 os에 설정한 환경변수 가져오기
		Map<String,String> envList=System.getenv();
		Set<String> keys=envList.keySet();
		for(String key: keys) {
			System.out.printf("key:%s,  value:%s\n",key,envList.get(key));
		}
		
		System.out.println(envList.get("BIZ"));
		System.out.println(envList.get("korea"));
	}
}
