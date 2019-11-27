package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;

@RestController

public class UserController {
@Autowired
private UserService userService;

    @GetMapping(value="/readall")
	List<User> readAll()
	{
		return userService.readUser();
	}
    @PostMapping(value="/create")
    public User createUser(@RequestBody User user)
    {
    	return this.userService.createUser(user);
    }
    
    @RequestMapping(value="/readallbyid/{abc}",method=RequestMethod.GET)
    public User readUserbyid(@PathVariable("abc") int userId){
      
    	
    	return this.userService.readUserById(userId);
    }
    
    @PutMapping(value="/update")
    public User updateUser(User user)
    {
    	return this.userService.updateUser(user);
    }
    
    
    @DeleteMapping(value="/delete{efg}")
    public User deleteUser(@PathVariable("efg") int userId)
    {
    	return this.userService.deleteUserById(userId);
    }

}
