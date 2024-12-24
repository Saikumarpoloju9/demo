package com.example.demo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RestUser;

@RestController
@RequestMapping("/users")
public class Controller {
	
	Map<String, RestUser> allUsers = new HashMap<>(); 
	
	
    @GetMapping
	public Collection<RestUser> getMethod() {
		return allUsers.values();
	}
    @PostMapping
    public String postMethod(@RequestBody RestUser userDetails) {
    	RestUser addValue = new RestUser();
    	addValue.setUserId(userDetails.getUserId());
    	addValue.setName(userDetails.getName());
    	addValue.setEmail(userDetails.getEmail());
    	allUsers.put(userDetails.getUserId(), addValue);
    	return "users added";
    	 
    }
    @PutMapping(path="/{userId}")
    public String putMethod(@PathVariable String userId, @RequestBody RestUser userDetails) {
    	if(allUsers.containsKey(userId))
    	{
    	  	RestUser addValue = new RestUser();
        	addValue.setUserId(userDetails.getUserId());
        	addValue.setName(userDetails.getName());
        	addValue.setEmail(userDetails.getEmail());
        	allUsers.put(userId, addValue);
        	return "updated user";
    	}
    	else
    	{
    		return "userId not found";
    	}
	}
    
    @DeleteMapping(path="/{userId}")
    public String deleteMethod(@PathVariable String userId) {
    	if(allUsers.containsKey(userId))
    	{
    	allUsers.remove(userId);
    	return "user deleted successfully";
    	}
    	else
    	{
		return "userId not found";
    	}
    	}
    }

