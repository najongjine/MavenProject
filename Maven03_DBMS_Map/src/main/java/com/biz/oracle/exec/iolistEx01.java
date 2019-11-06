package com.biz.oracle.exec;

import org.apache.ibatis.session.SqlSession;

import com.biz.DBConnection.DBConnection;
import com.biz.mybatis.mapper.IolistDao;
import com.biz.oracle.service.IolistServiceV1;

public class iolistEx01 {
	public static void main(String[] args) {
		IolistServiceV1 is=new IolistServiceV1();
		is.selectMapListView();
	}
}
