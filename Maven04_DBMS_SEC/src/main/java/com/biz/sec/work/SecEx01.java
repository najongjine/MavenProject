package com.biz.sec.work;

import java.util.Map;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class SecEx01 {

	public static void main(String[] args) {
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
		String planeText1="iolist2";
		String planeText2="iolist2";
		
		String encText1="";
		String encText2="";
		
		pbEnc.setAlgorithm("PBEwithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		encText1=pbEnc.encrypt(planeText1);
		encText2=pbEnc.encrypt(planeText2);
		
		System.out.printf("plane: %s, enc: %s\n",planeText1,encText1);
		System.out.printf("plane: %s, enc: %s\n",planeText2,encText2);
		
		String decText1=pbEnc.decrypt(encText1);
		String decText2=pbEnc.decrypt(encText2);
		
		System.out.printf("enc: %s, dec: %s \n",encText1,decText1);
		System.out.printf("enc: %s, dec: %s \n",encText2,decText2);
	}

}
