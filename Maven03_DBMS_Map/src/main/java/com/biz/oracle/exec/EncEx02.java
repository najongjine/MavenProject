package com.biz.oracle.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "";
		String password = "";
		String salt = "com.biz.oracle";

		String encUser = "8D30X+HEUOckxpuCGTU/7g==";
		String encPassword = "cERH/j7I0nREq1Npyblldg==";
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
