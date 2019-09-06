package com.hello.mvc03;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hello.mvc03.dto.CustomerDto;
import com.hello.mvc03.biz.CustomerBiz;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerBiz biz;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
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
