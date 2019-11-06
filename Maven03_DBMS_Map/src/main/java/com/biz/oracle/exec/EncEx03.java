package com.biz.oracle.exec;

import java.util.Map;
import java.util.Set;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> systemENV=System.getenv();
		Set<String> keys=systemENV.keySet();
		for(String s:keys) {
			System.out.printf("%s=%s\n",s,systemENV.get(s));
		}
		
		String user = "iolist2";
		String password = "iolist2";
		String salt = systemENV.get("USERNAME");

		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();

		// MD5 또는 DES형식의 암호화 타입
		// jasypt 만으로 암호화 시키는 방법
		String encType = "PBEWithMD5AndDES";
		pbEnc.setAlgorithm(encType);
		pbEnc.setPassword(salt);
		String encUser = pbEnc.encrypt(user);
		String encPassword = pbEnc.encrypt(password);
		System.out.printf("%s -> %s\n", user, encUser);
		System.out.printf("%s -> %s", password, encPassword);
		/*
		 * iolist2 -> QR6+kFoFV63LNkkpgLKfDQ==
iolist2 -> UmUPM883cuv29jOBtgMwIw==
		 */
	}

}
