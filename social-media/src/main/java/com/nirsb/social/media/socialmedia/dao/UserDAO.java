package com.nirsb.social.media.socialmedia.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nirsb.social.media.socialmedia.model.User;

@Component
public interface UserDAO {
	
	public List<User> getUsers();
	public User save(User user);
	public User delete(String id);
	public User getUserById(String id);
	public boolean update(User user);

}
