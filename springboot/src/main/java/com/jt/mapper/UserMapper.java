package com.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jt.pojo.TbUser;
@Mapper                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
public interface UserMapper {
	public List<TbUser> queryUsers();
}
