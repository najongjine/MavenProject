package com.biz.sec.exec;

import org.apache.ibatis.session.SqlSession;

import com.biz.sec.config.DBConnectionSec;

public class IolistEx01 {

	public static void main(String[] args) {
		SqlSession sqlSession=DBConnectionSec.getSqlSessionFactory().openSession(true);

	}

}
