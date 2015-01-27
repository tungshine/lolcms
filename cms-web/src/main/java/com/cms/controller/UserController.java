package com.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.po.User;
import com.cms.service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "getUserList")
	public ModelAndView getUserList() {
		ModelAndView mav = new ModelAndView();
		List<User> userList = userService.getUserList();
		mav.addObject("userList", userList);
		mav.setViewName("userList");
		return mav;
	}
}
