package com.jt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.User;

@RestController
public class DemoController02 {
	@RequestMapping("adduser")
	public User addUser(User user){
		
		return user;
	}
	@RequestMapping("deleteuser")
	public void deleteController(){
		
	}
}
