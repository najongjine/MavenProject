package com.biz.oracle.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "USERID";
		String password = "PASSWORD";
		String salt = "com.biz.oracle";

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
		 * iolist2 -> 8D30X+HEUOckxpuCGTU/7g== iolist2 -> cERH/j7I0nREq1Npyblldg==
		 */
	}

}
