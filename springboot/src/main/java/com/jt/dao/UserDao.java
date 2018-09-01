package com.jt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.pojo.TbUser;

public interface UserDao extends JpaRepository<TbUser, Integer>{

}
