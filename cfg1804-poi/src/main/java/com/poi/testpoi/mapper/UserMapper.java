package com.poi.testpoi.mapper;

import com.poi.testpoi.pojo.User;

import java.util.List;

public interface UserMapper {


	List<User> selectUsers();

	void updateUserByName(User user);

	void addUser(User user);

	int selectByName(String name);


}
