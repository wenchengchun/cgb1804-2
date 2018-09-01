package com.jt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper.UserMapper;
import com.jt.pojo.TbUser;
import com.jt.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	public List<TbUser> queryUsers() {
		
		return userMapper.queryUsers();
	}
	
}
