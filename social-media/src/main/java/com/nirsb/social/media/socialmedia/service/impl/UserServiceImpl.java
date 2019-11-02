package com.nirsb.social.media.socialmedia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirsb.social.media.socialmedia.dao.UserDAO;
import com.nirsb.social.media.socialmedia.model.User;
import com.nirsb.social.media.socialmedia.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	@Override
	public List<User> getUsersList() {
		return userDao.getUsers();
	}

	@Override
	public User deleteUser(String id) {
		return userDao.delete(id);
	}

	@Override
	public User getUserById(String id) {
		return userDao.getUserById(id);
	}

	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

}
