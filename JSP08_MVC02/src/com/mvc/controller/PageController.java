package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dto.PageDto;

@WebServlet("/PageController")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PageDto dto = new PageDto();
		String command = request.getParameter("command"); 
		int curPage = 1;
		
		if(command.equals("paging")) {
			dto.makeBlock(curPage);
			dto.makeLastPageNum();
			
			int blockStartNum = dto.getBlockStartNum();
			int blockLastNum = dto.getBlockLastNum();
			int lastPageNum = dto.getLastPageNum();
			
			request.setAttribute("curPageNum", curPage);
			request.setAttribute("blockStartNum", blockStartNum);
			request.setAttribute("blockLastNum", blockLastNum);
			request.setAttribute("lastPageNum", lastPageNum);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("page.jsp");
			dispatcher.forward(request, response);
		}
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
