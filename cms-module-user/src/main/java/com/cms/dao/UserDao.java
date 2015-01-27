package com.cms.dao;

import java.util.List;

import com.cms.po.User;

public interface UserDao {

	public boolean addUser(User user);
	
	public List<User> getUserList();
}
