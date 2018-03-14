package com.practicaDaw.Dawllapop.ApiRestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Friend_request;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.Friend_RequestRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.security.UserComponent;
import com.practicaDaw.Dawllapop.services.FriendRequestServices;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class RestFriendRequest {
	
	@Autowired
	private UserComponent userComponent;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private Friend_RequestRepository friendRequestRepo;
	
	@Autowired
	private FriendRequestServices fRequestServices;
	
	@RequestMapping(value = "/friendRequest/accept/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Friend_request> acceptRequest(@PathVariable long id){
		Friend_request fRequest = friendRequestRepo.findOne(id);
		User userLogged = userComponent.getLoggedUser();
		if(userLogged.getId() == fRequest.getTo().getId()) {
			fRequest.setState("accepted");
			friendRequestRepo.saveAndFlush(fRequest);
			return new ResponseEntity<>(fRequest, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value = "/friendRequest/refuse/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Friend_request> refuseRequest(@PathVariable long id){
		Friend_request fRequest = friendRequestRepo.findOne(id);
		User userLogged = userComponent.getLoggedUser();
		if(userLogged.getId() == fRequest.getTo().getId()) {
			fRequest.setState("refused");
			friendRequestRepo.saveAndFlush(fRequest);
			return new ResponseEntity<>(fRequest, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value = "/friendRequest/", method = RequestMethod.POST)
	public ResponseEntity<Friend_request> addFriendRequest(@RequestBody Map<String, Object> rBody){
		int idUserTo = (int) rBody.get("idUser");
		User userTo = userRepo.findById(idUserTo);
		User userFrom = userComponent.getLoggedUser(); 
		String message = (String) rBody.get("message");
		Friend_request fRequest = new Friend_request(message, userFrom, userTo);
		friendRequestRepo.save(fRequest);
		return new ResponseEntity<>(fRequest, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/friendRequest/", method = RequestMethod.GET)
	public ResponseEntity<List<Friend_request>> getUserFRequests(){
		List<Friend_request> friendRequests = fRequestServices.getUserRequests(userComponent.getLoggedUser());
		return new ResponseEntity<>(friendRequests, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUserFriends(){
		List<User> friends = fRequestServices.getUserFriends(userComponent.getLoggedUser());
		return new ResponseEntity<>(friends, HttpStatus.OK);
	}
}
