package com.chandra.rest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chandra.rest.bean.User;
import com.chandra.rest.controller.exception.userNotFoundException;
import com.chandra.rest.dao.UserDaoService;

@RestController
public class userController {

	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {		
		User user =  service.findOne(id);
		if(user == null) {
			throw new userNotFoundException("No User with that id" + id);
		}
		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers  = linkTo(methodOn(this.getClass()).retriveAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		
		WebMvcLinkBuilder linkToPostUsers  = linkTo(methodOn(this.getClass()).addUser(user));
		model.add(linkToUsers.withRel("add-user"));
		return model;
		//return user;
	}


	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {		
		User savedUser =  service.save(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {		
		User user =  service.deleteUserById(id);
		if(user == null) {
			throw new userNotFoundException("No User with that id" + id);
		}
		
	}
	/*//not working
	@DeleteMapping("/users/{id}")
	public BodyBuilder deleteUserById(@PathVariable int id) {		
		User savedUser =  service.deleteUserById(id);;
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.status(HttpStatus.GONE);
	}*/
	/*
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {		
		User savedUser =  service.save(user);
		
	}
	
	*/
	/*
	@GetMapping("/users/{id}/posts")
	public List<User> retriveAllPostsOfUsers(@PathVariable int id){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {		
		User user =  service.findOne(id);
		if(user == null) {
			throw new userNotFoundException("No User with that id" + id);
		}
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {		
		User savedUser =  service.save(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	*/
	
	
}
