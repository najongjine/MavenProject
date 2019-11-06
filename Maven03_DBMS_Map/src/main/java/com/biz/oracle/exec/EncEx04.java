package com.biz.oracle.exec;

import java.util.Map;
import java.util.Set;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> systemENV=System.getenv();
		Set<String> keys=systemENV.keySet();
		for(String s:keys) {
			System.out.printf("%s=%s\n",s,systemENV.get(s));
		}
		String encUser = "Rt5HbSvDr0JBAV5oGPgHaQ==";
		String encPassword = "3dk0Z6yRhouZd95LkprDgg==";
		String user = "";
		String password = "";
		String salt = systemENV.get("USERNAME");

		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();

		// MD5 또는 DES형식의 암호화 타입
		// jasypt 만으로 암호화 시키는 방법
		String encType = "PBEWithMD5AndDES";
		pbEnc.setAlgorithm(encType);
		pbEnc.setPassword(salt);
		user = pbEnc.decrypt(encUser);
		password = pbEnc.decrypt(encPassword);
		System.out.printf("%s -> %s\n", encUser, user);
		System.out.printf("%s -> %s", encPassword, password);
		/*
		 */
	}

}
