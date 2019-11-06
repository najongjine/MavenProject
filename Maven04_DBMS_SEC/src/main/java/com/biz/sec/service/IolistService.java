package com.biz.sec.service;

import java.util.List;
import java.util.Map;

import com.biz.sec.config.DBConnectionSec;
import com.biz.sec.mapper.IolistDao;

public class IolistService {
	protected IolistDao ioDao;
	
	//생성자보다 먼저 실행됨. 인스턴스 생성자
	{
		ioDao=DBConnectionSec.getSqlSessionFactory().openSession(true).getMapper(IolistDao.class);
	}
	
	public void viewIoList() {
		List<Map<String,Object>> ioList=ioDao.selectAllMap();
		for(Map<String,Object> io:ioList) {
			System.out.print(io.get("IO_SEQ")+"\t");
			System.out.print(io.get("IO_SEQ")+"\t");
			System.out.print(io.get("IO_DATE")+"\t");
			System.out.print(io.get("IO_INOUT")+"\t");
			System.out.print(io.get("IO_QTY")+"\t");
			System.out.print(io.get("IO_PRICE")+"\t");
			System.out.print(io.get("IO_TOTAL")+"\t");
			System.out.print(io.get("IO_PCODE")+"\t");
			System.out.print(io.get("IO_DCODE")+"\n");
		}
	}
}
