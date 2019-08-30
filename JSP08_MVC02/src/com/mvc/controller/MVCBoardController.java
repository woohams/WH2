package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.dto.MVCBoardDto;

@Controller
public class MVCBoardController {

	@Autowired
	private MVCBoardBizImpl biz;
	
	
	@RequestMapping("/boardlist.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "/WEB-INF/views/boardlist.jsp";
	}
	
	@RequestMapping("/selectone.do")
	public String selectOne(@RequestParam("seq") int seq, Model model) {
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "/WEB-INF/views/selectone.jsp";
	}
	
	@RequestMapping(value = "/insertform.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String insertFrom() {
		
		return "/WEB-INF/views/insertform.jsp";
	}
	
	// insert, update, delete => update !!!
	@RequestMapping(value = "/insertres.do", method = RequestMethod.POST)
	public String insertRes(@ModelAttribute MVCBoardDto dto, Model model) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			model.addAttribute("list", biz.selectList());	// 성공했으면 boardlist를 보여주기 위해 갖고 감
			return "/WEB-INF/views/boardlist.jsp";
		} else {
			return "/WEB-INF/views/insertform.jsp";
		}
	}
	
	@RequestMapping(value = "/updateform.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateFrom(MVCBoardDto dto, int seq, Model model) {
		
		model.addAttribute("dto", biz.selectOne(seq));
			
		return "/WEB-INF/views/updateform.jsp";
	}
		
	@RequestMapping(value = "/updateres.do", method = RequestMethod.POST)
	public String updateRes(MVCBoardDto dto, Model model) {
		
		int res = biz.update(dto);
		
		if(res > 0) {
			model.addAttribute("dto", biz.update(dto));
			model.addAttribute("list", biz.selectList());
			return "/WEB-INF/views/boardlist.jsp";
		} else {
			return "/WEB-INF/views/updateform.jsp";
		}
		
	}
	
	@RequestMapping(value = "/delete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(int seq, Model model) {
		
		int res = biz.delete(seq);
		
		if(res > 0) {
			model.addAttribute("dto", biz.delete(seq));
			model.addAttribute("list", biz.selectList());
			return "/WEB-INF/views/boardlist.jsp";
		} else {
			return "/WEB-INF/views/boardlist.jsp";
		}

	}
		
}






