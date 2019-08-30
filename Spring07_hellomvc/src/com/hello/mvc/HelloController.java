package com.hello.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloBiz;

@Controller
public class HelloController {
	@Autowired
	private HelloBiz biz;

	// TODO: 004. controller
	@RequestMapping("/hello.ho")
	public String getHello(Model model) {
		// TODO: 009.return 받은 값을 model 객체에 담기(ModelAndView)
		model.addAttribute("message", biz.getHello());

		return "/WEB-INF/views/hello.jsp";

	}

	@RequestMapping("/bye.ho")
	public ModelAndView getBye(@RequestParam("name") String name) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message","Bye,"+name );
		
		return mav;

	}

}

/**
 * @RequestMapping
 * @RequestMapping Annotation 은  url을 class 또는 method와 mapping시키는 역할을 한다.
 * 
 * @RequestParam
 * @RequestParam Annotation은 key=value 형태로 화면에서 넘어오는 파라미터를 주로, get 방식으로 들어오는 request에서 사용된다.
 * 
 * @ModelAttribute
 * @ModelAttribute Annotation 은 화면의 form속성으로 넘어온 model을 mapping된 method 의 파라미터에 전달해준다.
 * 주로, post방식으로 들어오는 request에서 사용된다.
 * (get/post 모두 사용가능)
 * 
 * @SessionAttribute
 * @SessionAttribute Annotation은 session에서 model 의 정보를 유지하고 싶을때 사용한다.
 * 
 * 
 */
