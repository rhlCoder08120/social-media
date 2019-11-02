package com.nirsb.social.media.socialmedia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nirsb.social.media.socialmedia.model.User;

@Service
public interface UserService {
	
	public List<User> getUsersList();
	public User deleteUser(String id);
	public User getUserById(String id);
	public boolean update(User user);
	public User save(User user);

}
