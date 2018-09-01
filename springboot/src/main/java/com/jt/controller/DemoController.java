package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.User;
@Component
@RestController
public class DemoController {
	@Value("${users.id}")
	private int id ; 
	@Autowired
	private User user;
	@RequestMapping("demo1")
	//返回字符串
	public String demo1(){
		return " 你好老大";
	}
	//返回对象
	@RequestMapping("user")
	public User returnUser(){
		User user = new User();
		user.setName("wanglaoshi");
		user.setAge(id);
		user.setId(id);
		return user;
	}
	@RequestMapping("user1")
	public User demo03(){
		
		return user;
	}
	
	
	
}
