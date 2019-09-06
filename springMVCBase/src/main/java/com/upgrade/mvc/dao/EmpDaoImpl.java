package com.upgrade.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upgrade.mvc.dto.EmpDto;

@Repository
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;


	@Override
	public List<EmpDto> selectList() {
		List <EmpDto> list = new ArrayList<EmpDto>();
		
		try {
			list = sqlSession.selectList(namespace + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECT LIST ERROR");
		}
		
		return list;
	}

	@Override
	public EmpDto selectOne(int empno) {

		EmpDto dto = new EmpDto();
		
		try {
			dto = sqlSession.selectOne(namespace + "selectOne", empno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SELECT ONE ERROR");
		}
		
		return dto;
	}

	@Override
	public int insert(EmpDto dto) {
		
		int res = 0;

		try {
			res = sqlSession.insert(namespace + "insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert error");
		}
		
		return res;
	}

	@Override
	public int update(EmpDto dto) {
		
		int res = 0;	
		
		try {
			res = sqlSession.update(namespace + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("update error");
		}
		
		return res;
	}

	@Override
	public int delete(int empno) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(namespace + "delete", empno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error");
		}
		
		return res;
	}

}
