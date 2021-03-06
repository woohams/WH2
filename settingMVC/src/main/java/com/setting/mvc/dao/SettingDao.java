package com.setting.mvc.dao;

import java.util.List;

import com.setting.mvc.dto.SettingDto;


public interface SettingDao {
	
	String namespace = "setting.";
	
	public List<SettingDto> selectList();
	public SettingDto selectOne(int seq);
	public int insert(SettingDto dto);
	public int update(SettingDto dto);
	public int delete(int seq);
	public SettingDto login(String id, String pw);
	public String test();
}
