package com.mvc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.model.MVCBoardDaoImpl;
import com.mvc.model.MVCBoardDto;

@Service
public class MVCBoardBizImpl implements MVCBoardBiz {
	
	@Autowired
	private MVCBoardDaoImpl dao = new MVCBoardDaoImpl();
	
	@Override
	public List<MVCBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(MVCBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MVCBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		return dao.delete(seq);
	}

}
