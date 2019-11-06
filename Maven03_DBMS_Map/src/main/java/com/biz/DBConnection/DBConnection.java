package com.biz.DBConnection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnection {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String configFile="com/biz/mybatis/config/mybatis-config.xml";
		InputStream is;
		String encType = "PBEWithMD5AndDES";
		String encUser = "Rt5HbSvDr0JBAV5oGPgHaQ==";
		String encPassword = "3dk0Z6yRhouZd95LkprDgg==";
		
		//암호화된 encUser, encPassword를 복호화하기 위한 준비
		Map<String,String> systemENV=System.getenv();
		StandardPBEStringEncryptor pbEnc=new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm(encType);
		pbEnc.setPassword(systemENV.get("USERNAME"));
		
		//복호환된 문자열을 mybatis-config에 전달하기 위한 절차
		Properties pros=new Properties();
		pros.put("username", pbEnc.decrypt(encUser));
		pros.put("password", pbEnc.decrypt(encPassword));
		try {
			is=Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
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
