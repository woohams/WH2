package com.mvc.fuck;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.model.MVCBoardDto;
import com.mvc.model.MVCBoardBizImpl;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MVCBoardBizImpl biz;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/boardlist.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "boardlist";
	}
	
	@RequestMapping("/selectone.do")
	public String selectOne(@RequestParam("seq") int seq, Model model) {
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "selectone";
	}
	
	@RequestMapping(value = "/insertform.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String insertFrom() {
		
		return "insertform";
	}
	
	// insert, update, delete => update !!!
	@RequestMapping(value = "/insertres.do", method = RequestMethod.POST)
	public String insertRes(@ModelAttribute MVCBoardDto dto, Model model) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			model.addAttribute("list", biz.selectList());	// 성공했으면 boardlist를 보여주기 위해 갖고 감
			return "boardlist";
		} else {
			return "insertform";
		}
	}
	
	@RequestMapping(value = "/updateform.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateFrom(MVCBoardDto dto, int seq, Model model) {
		
		model.addAttribute("dto", biz.selectOne(seq));
			
		return "updateform";
	}
		
	@RequestMapping(value = "/updateres.do", method = RequestMethod.POST)
	public String updateRes(MVCBoardDto dto, Model model) {
		
		int res = biz.update(dto);
		
		if(res > 0) {
			model.addAttribute("dto", biz.update(dto));
			model.addAttribute("list", biz.selectList());
			return "boardlist";
		} else {
			return "updateform";
		}
		
	}
	
	@RequestMapping(value = "/delete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(int seq, Model model) {
		
		int res = biz.delete(seq);
		
		if(res > 0) {
			model.addAttribute("dto", biz.delete(seq));
			model.addAttribute("list", biz.selectList());
			return "boardlist";
		} else {
			return "boardlist";
		}

	}
	
	
}
