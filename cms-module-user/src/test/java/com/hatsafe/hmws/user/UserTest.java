package com.hatsafe.hmws.user;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cms.dao.UserDao;
import com.cms.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:sys-db.xml", "classpath:sys-core.xml" })
public class UserTest {

	@Resource
	private Integer pk;
	
	@Resource 
	private UserDao userDao;

	@Test
	public void testUserList() {
		List<User> list = userDao.getUserList();
		for(User user : list) {
			System.out.println(user.getUserName());
		}
		
	}

}
