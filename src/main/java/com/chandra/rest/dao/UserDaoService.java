package com.chandra.rest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chandra.rest.bean.User;

@Component
public class UserDaoService {

	private static List<User> users =  new ArrayList<>();
	private static int userCount = 3;
	static
	{
		users.add(new User(1,"chandra",new Date()));
		users.add(new User(2,"pradeep",new Date()));
		users.add(new User(3,"avvaru",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User u:users) {
			if(u.getId()==id) {
				return u;
			}
		}
		return null;
	}
	public User deleteUserById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User u = iterator.next();
		if(u.getId()==id) {
				return u;
			}
		}
		return null;
	}
	/*
	public List<User> findAllPostofUser(int id){
		return posts;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User u:users) {
			if(u.getId()==id) {
				return u;
			}
		}
		return null;
	}
	*/
}
