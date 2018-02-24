package com.practicaDaw.Dawllapop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	UserRepository userRepo;
	
	public User findUser(long id) {
		return userRepo.findOne(id);
	}
	
	public List<User> searchUsers(String name){
		return userRepo.searchByName(name);
	}
}
