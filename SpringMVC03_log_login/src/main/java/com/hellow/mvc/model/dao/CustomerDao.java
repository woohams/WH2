package com.hellow.mvc.model.dao;

import java.util.List;

import com.hellow.mvc.dto.CustomerDto;

public interface CustomerDao {
	
	String namespace = "customer.";
	
	public List<CustomerDto> selectList();
	public CustomerDto selectOne(String id);
	public int insert(CustomerDto dto);
	public int update(CustomerDto dto);
	public int delete(String id);
	public CustomerDto login(String id, String password);
	
}
