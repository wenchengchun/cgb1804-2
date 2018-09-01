package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.dao.UserDao;
import com.jt.pojo.TbUser;
import com.jt.pojo.User;

@RestController
public class Demo03Contorller {
	//案例5利用jpa操作数据库
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("findAll")
	public List<TbUser> getUsers(){
		List<TbUser> userList = userDao.findAll();
		return userList;
	}
	
	@RequestMapping("jpaAddUser")
	public String addJpaUser(@Validated TbUser user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			//将错误的信息传递出去
			return bindingResult.getFieldError().getDefaultMessage();
		}
		userDao.save(user);
		return "新建成功";
	}
}
