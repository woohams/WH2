package com.upgrade.mvc;

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


import com.upgrade.mvc.biz.EmpBiz;
import com.upgrade.mvc.dto.EmpDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private EmpBiz biz;
	
	
	@RequestMapping(value = "/", method = {RequestMethod.GET ,RequestMethod.POST})
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("list", biz.selectList());
		
		return "list";
	}
	
	@RequestMapping(value = "/list.do", method = {RequestMethod.GET ,RequestMethod.POST})
	public String selectList(Model model) {

		model.addAttribute("list", biz.selectList());
		return "list";
	}
	
	@RequestMapping(value = "/selectone.do", method = RequestMethod.GET)
	public String selectOne(int empno, Model model) {

		model.addAttribute("dto", biz.selectOne(empno));
		
		return "selectone";
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {

		return "insert";
	}

	@RequestMapping(value = "/insertres.do", method = RequestMethod.POST)
	public String insertRes(EmpDto dto, Model model) {

		int res = biz.insert(dto);

		if (res > 0) {
			model.addAttribute("list", biz.selectList());
			return "list";
		} else {
			return "redirect:insert.do";
		}
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update(EmpDto dto, int empno, Model model) {

		model.addAttribute("dto", biz.selectOne(empno));

		return "update";
	}

	@RequestMapping(value = "/updateres.do", method = RequestMethod.POST)
	public String updateRes(EmpDto dto, Model model) {

		int res = biz.update(dto);

		if (res > 0) {
			model.addAttribute("dto", biz.update(dto));
			model.addAttribute("list", biz.selectList());
			return "list";
		} else {
			return "update";
		}

	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(int empno, Model model) {

		int res = biz.delete(empno);

		if (res > 0) {
			model.addAttribute("dto", biz.delete(empno));
			model.addAttribute("list", biz.selectList());
			return "list";
		} else {
			return "list";
		}

	}
}


