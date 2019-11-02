package com.nirsb.social.media.socialmedia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirsb.social.media.socialmedia.dao.UserDAO;
import com.nirsb.social.media.socialmedia.dao.impl.UserRepository;
import com.nirsb.social.media.socialmedia.model.User;

@Service
public class UserRepositoryService {

	@Autowired
	UserDAO userDao;
	
	@Autowired
	UserRepository userRepository;
	

	public List<User> getUsersList() {
		return userRepository.findAll();
	}


	public void deleteUser(User user) {
		userRepository.delete(user);;
	}


	public User getUserById(String id) {
		return userRepository.findById(id).get();
	}


	public boolean update(User user) {
		return userDao.update(user);
	}


	public User save(User user) {
		return userRepository.save(user);
	}

}
