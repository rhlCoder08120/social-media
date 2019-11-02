package com.nirsb.social.media.socialmedia.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nirsb.social.media.socialmedia.dao.UserDAO;
import com.nirsb.social.media.socialmedia.exception.UserNotFoundException;
import com.nirsb.social.media.socialmedia.model.User;

@Component
public class UserDAOImpl implements UserDAO {
	private static List<User> userList = new ArrayList<User>();
	
	static {
		userList.add(new User("1", "Rahul", new Date()));
		userList.add(new User("2", "Suraj", new Date()));
		userList.add(new User("3", "Brijesh", new Date()));
		userList.add(new User("4", "Ragini", new Date()));
		userList.add(new User("5", "Bhabhi", new Date()));
		userList.add(new User("6", "Papa", new Date()));
		userList.add(new User("7", "Mummy", new Date()));
	}

	@Override
	public List<User> getUsers() {	
		return userList;
	}

	@Override
	public User save(User user) {
		if(user != null) {
			user.setDob(new Date());
			userList.add(user);
			return user;
		}
		return null;
	}

	@Override
	public User delete(String id) {
		Iterator<User> userIterator = userList.iterator();
		while(userIterator.hasNext()) {
			User user1 = userIterator.next();
			if(user1.getId() == id) {
				userIterator.remove();
				return user1;
			}
		}
		throw new UserNotFoundException("Id missing in DB:"+id);
	}

	@Override
	public User getUserById(String id) {
		Optional<User> user = userList.stream().filter(u->u.getId().equals(id)).findAny();
		if(user.isPresent()) {
			return user.get(); 
		}
		return null;
	}

	@Override
	public boolean update(User user) {
		for(User user1: userList) {
			if(user1.getId()==user.getId()) {
				user1.setDob(user.getDob());
				user1.setName(user.getName());
				userList.add(user1);
				return true; 
			}
		}
		return false;
	}
	
	
}
