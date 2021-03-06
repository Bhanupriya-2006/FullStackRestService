package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	public abstract User createUser(User user);
	public abstract List<User> readUser();
	public abstract User readUserById(int id);
	public abstract User readUserByName(String name);
	public abstract User updateUser(User user);
	public abstract User deleteUserById(int id);
	

}
