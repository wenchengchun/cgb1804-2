package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.TbUser;
import com.jt.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//查询user表
	@RequestMapping("queryAll")
	@ResponseBody
	public List<TbUser> queryUsers(){
		return userService.queryUsers();
	}
}
