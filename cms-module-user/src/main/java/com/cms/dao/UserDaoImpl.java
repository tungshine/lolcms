package com.cms.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.cms.po.User;

@Component
public class UserDaoImpl implements UserDao {

	@Resource
	private SqlSessionFactory sqlSessionFactory;

	@Resource
	private SqlSessionTemplate sessionTemplate;

	@Override
	public boolean addUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		int i1 = session.insert("addUser", user);
		session.close();
		return i1 != 0;
	}

	@Override
	public List<User> getUserList() {
		return sessionTemplate.selectList("select");
	}
}
