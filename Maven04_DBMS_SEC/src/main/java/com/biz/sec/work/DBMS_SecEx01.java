package com.biz.sec.work;

import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBMS_SecEx01 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Map<String,String> envList=System.getenv();
		/*
		 * java에서 암호화, 복호화 수행해줌.
		 * 
		 * 양방향 암호화에선 salt key가 노출되면 의미가 없음.
		 * jasypt는 양방향 암호화.
		 * jdbc에서 DBMS로 userid와 password를 전송하는 과정에서
		 * 평문으로 해당 데이터를 보내야 하기 때문에 암호화된 문자열을 다시 평문으로 복호화 해야한다.
		 */
		StandardPBEStringEncryptor pbEnc=new StandardPBEStringEncryptor();
		String saltPass=envList.get("BIZ"); // key
		pbEnc.setAlgorithm("PBEwithMD5AndDES");
		pbEnc.setPassword(envList.get("BIZ"));
		System.out.print("username >> ");
		String planeUserName=scanner.nextLine();
		System.out.print("password >> ");
		String planePassword=scanner.nextLine();
		
		String encUserName=pbEnc.encrypt(planeUserName);
		String encPassword=pbEnc.encrypt(planePassword);
		
		System.out.printf("planeUserName: %s, encUserName: %s \n",planeUserName,encUserName);
		System.out.printf("planePassword: %s, encPassword: %s \n",planePassword,encPassword);
		/*
		 * planeUserName: , encUserName: GIxAOoDQ+Lkt0QWLDg0yHA== 
			planePassword: , encPassword: 9kXllrVs5Mf7ZyGsyJQSYA== 
		 */
	}

}
