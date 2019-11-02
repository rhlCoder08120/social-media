package com.nirsb.social.media.socialmedia.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nirsb.social.media.socialmedia.exception.UserNotFoundException;
import com.nirsb.social.media.socialmedia.model.User;
import com.nirsb.social.media.socialmedia.service.impl.UserRepositoryService;

@RestController
public class UserJpaController {

	@Autowired
	UserRepositoryService userService;
	
	
	@GetMapping(path="/jpa/users")
	public List<User> getUsers(){
		return userService.getUsersList();
	}
	
	
	@RequestMapping(path="/jpa/users",method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody User id) {
		 userService.deleteUser(id);
	}
	
	
	@RequestMapping(path="/jpa/users/{id}",method = RequestMethod.GET)
	public Resource<User> getUserById(@PathVariable String id) {
		User user = userService.getUserById(id);
		 if(user ==null) {
			 throw new UserNotFoundException("user not found for: "+id);
		 }
		 Resource<User> resource = new Resource<User>(user);
		 ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
		 resource.add(linkTo.withRel("all-users"));
		 return resource;
	}
	
	
	@RequestMapping(path="/jpa/users",method = RequestMethod.POST)
	public ResponseEntity<User> save(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@RequestMapping(path="/jpa/users",method = RequestMethod.PUT)
	public boolean update(@RequestBody User user) {
		return userService.update(user);
	}
	
}
