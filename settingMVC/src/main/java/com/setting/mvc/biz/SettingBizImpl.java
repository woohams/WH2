package com.setting.mvc.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setting.mvc.dao.SettingDao;
import com.setting.mvc.dto.SettingDto;


@Service
public class SettingBizImpl implements SettingBiz {

	@Autowired
	private SettingDao dao;
	
	@Override
	public List<SettingDto> selectList() {
		return dao.selectList();
	}

	@Override
	public SettingDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(SettingDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(SettingDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return dao.delete(seq);
	}

	@Override
	public SettingDto login(String id, String pw) {
		// TODO Auto-generated method stub
		return dao.login(id, pw);
	}

}
