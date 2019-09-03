package com.setting.mvc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.setting.mvc.dto.SettingDto;

@Repository
public class SettingDaoImpl implements SettingDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<SettingDto> selectList() {

		List<SettingDto> list = new ArrayList<SettingDto>();
		
		try {
			list = sqlSession.selectList(namespace + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("selectlist error");
		}
		
		return list;
	}

	@Override
	public SettingDto selectOne(int seq) {
		
		SettingDto dto = new SettingDto();
		
		try {
			dto = sqlSession.selectOne(namespace + "selectOne", seq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("selectone error");
		}
		
		return dto;
	}

	@Override
	public int insert(SettingDto dto) {

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
	public int update(SettingDto dto) {

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
	public int delete(int seq) {
		int res = 0;
		
		try {
			res = sqlSession.delete(namespace + "delete", seq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error");
		}
	
		
		return res;
	}

	@Override
	public SettingDto login(String id, String pw) {

		SettingDto dto = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		
		try {
			dto = sqlSession.selectOne(namespace + "login", map);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("login error");
		}
		
		
		return dto;
	}

	@Override
	public String test() {
		
		return null;
	}

}







