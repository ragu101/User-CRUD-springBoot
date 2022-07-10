package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;

@Controller
public class IndexServletController {
	
	@RequestMapping("index")
	public String index() {
		return "index.jsp";
	}
	
	@Autowired
	UserDAO userdao;
	
	@RequestMapping("addUser")
	public String addUser(User user) {
		userdao.save(user);
		return "index.jsp";
	}	
	
	@RequestMapping("getUser")
	public ModelAndView getUser(@RequestParam int id) {
		
		ModelAndView mav = new ModelAndView("showUser.jsp");
		User user = userdao.findById(id).orElse(new User());
		mav.addObject(user);
		return mav;
	}
	
	@RequestMapping("updateUser")
	public ModelAndView updateUser(User user) {
		
		ModelAndView mav = new ModelAndView("updateUser.jsp");
		user = userdao.findById(user.getId()).orElse(new User());
		userdao.deleteById(user.getId());
		mav.addObject(user);
		return mav;
	}
}
