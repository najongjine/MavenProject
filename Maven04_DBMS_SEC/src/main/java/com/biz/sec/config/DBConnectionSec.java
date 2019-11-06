package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnectionSec {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		String saltPass=System.getenv().get("BIZ");
		String configFile="com/biz/sec/config/mybatis-config.xml";
		InputStream is;
		StandardPBEStringEncryptor pbEnc=new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		String username="6suxtBcQYx9bc9kRgQJYTQ==";
		String password="017DbCwxwCFizCe6ZkMS1w==";
		
		/*
		 * java에서 어떤 setting값들을 모아서 어떤 설정을 하는 용도로 사용.
		 * setting값들을 쉽게 관리할수 있도록 도와주는 class
		 */
		Properties pros=new Properties();
		pros.put("username", pbEnc.decrypt(username));
		pros.put("password", pbEnc.decrypt(password));
		try {
			is=Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			if(sqlSessionFactory==null)
				sqlSessionFactory=builder.build(is,pros);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
