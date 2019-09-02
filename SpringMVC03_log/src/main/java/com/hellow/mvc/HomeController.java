package com.hellow.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hellow.mvc.dto.CustomerDto;
import com.hellow.mvc.model.biz.CustomerBiz;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerBiz biz;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		return "boardlist";
	}
	
	@RequestMapping(value = "/selectone.do")
	public String selectOne(String id, Model model) {
		
		model.addAttribute("dto", biz.selectOne(id));
		System.out.println(biz.selectOne(id).getPassword());
		return "selectone";
	}
	
	@RequestMapping(value = "/insert.do", method=RequestMethod.GET)
	public String insert() {
		
		return "insert";
	}
	
	@RequestMapping(value = "/insertres.do", method = RequestMethod.POST)
	public String insertRes(CustomerDto dto, Model model) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "boardlist";
		} else {
			return "insert";
		}
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update(CustomerDto dto, String id, Model model) {
		
		model.addAttribute("dto", biz.selectOne(id));
		
		return "update";
	}
	
	@RequestMapping(value = "/updateres.do", method = RequestMethod.POST)
	public String updateRes(CustomerDto dto, Model model) {
		
		int res = biz.update(dto);
		
		if(res > 0) {
			model.addAttribute("dto", biz.update(dto));
			model.addAttribute("list", biz.selectList());
			return "boardlist";
		} else {
			return "update";
		}
		
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(String id, Model model) {
		
		int res = biz.delete(id);
		
		if(res > 0) {
			model.addAttribute("dto", biz.delete(id));
			model.addAttribute("list", biz.selectList());
			return "boardlist";
		} else {
			return "boardlist";
		}
		
	}

}









