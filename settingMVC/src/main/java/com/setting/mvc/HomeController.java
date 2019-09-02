package com.setting.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.setting.mvc.biz.SettingBiz;
import com.setting.mvc.dto.SettingDto;

@Controller
public class HomeController {

	@Autowired
	private SettingBiz biz;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String selectList(Model model) {

		model.addAttribute("list", biz.selectList());
		return "list";
	}

	@RequestMapping(value = "/selectone.do", method = RequestMethod.GET)
	public String selectOne(int seq, Model model) {

		model.addAttribute("dto", biz.selectOne(seq));
		
		return "selectone";
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {

		return "insert";
	}

	@RequestMapping(value = "/insertres.do", method = RequestMethod.POST)
	public String insertRes(SettingDto dto, Model model) {

		int res = biz.insert(dto);

		if (res > 0) {
			model.addAttribute("list", biz.selectList());
			return "list";
		} else {
			return "insert";
		}
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update(SettingDto dto, int seq, Model model) {

		model.addAttribute("dto", biz.selectOne(seq));

		return "update";
	}

	@RequestMapping(value = "/updateres.do", method = RequestMethod.POST)
	public String updateRes(SettingDto dto, Model model) {

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
	public String delete(int seq, Model model) {

		int res = biz.delete(seq);

		if (res > 0) {
			model.addAttribute("dto", biz.delete(seq));
			model.addAttribute("list", biz.selectList());
			return "list";
		} else {
			return "list";
		}

	}

	@RequestMapping(value = "/loginform.do", method = RequestMethod.GET)
	public String loginform(String id, String pw, Model model) {

		return "loginform";
	}
	
	@RequestMapping("/loginajax.do")
	@ResponseBody
	public Map<String, Boolean> loginAjax(String id, String pw, HttpSession session) {

		SettingDto dto = biz.login(id, pw);
		boolean loginchk = false;

		if (dto.getId() != null) { 
			session.setAttribute("dto", dto);
			loginchk = true; 
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("loginchk", loginchk);

		return map;
	}

}
