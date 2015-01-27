package com.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.dao.UserDao;
import com.cms.po.User;
import com.cms.service.UserService;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

}
