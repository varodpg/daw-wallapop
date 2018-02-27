package com.practicaDaw.Dawllapop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.practicaDaw.Dawllapop.Entities.Friend_request;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.Friend_RequestRepository;

@Service
public class FriendRequestServices {
	@Autowired
	private Friend_RequestRepository friendResquestRepo;
	
	public List<Friend_request> getUserRequests(User user) {
		return friendResquestRepo.getUserRequests(user);
	}
	
	public List<User> getUserFriends(User user) {
		return friendResquestRepo.getUserFriends(user);
	}
}
