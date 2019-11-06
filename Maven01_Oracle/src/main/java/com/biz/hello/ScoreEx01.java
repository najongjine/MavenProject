package com.biz.hello;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.hello.config.DBConnection;
import com.biz.hello.dao.ScoreDao;
import com.biz.hello.persistence.ScoreDTO;

public class ScoreEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession sqlSession=DBConnection.getSqlSessionFactory().openSession(true);
		ScoreDao scoreDao=sqlSession.getMapper(ScoreDao.class);
		
		List<ScoreDTO> scList=scoreDao.selectAll();
		for(ScoreDTO dto:scList) {
			System.out.println(dto.toString());
		}
	}

}
