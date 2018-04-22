package com.practicaDaw.Dawllapop.ApiRestController;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.security.UserComponent;
import com.practicaDaw.Dawllapop.services.UserServices;

@RestController
public class RestUser {
	@Autowired UserRepository userRepository;
	@Autowired UserComponent userComponent;
	@Autowired UserServices userService;
	
	@RequestMapping (value="/api/users", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)

	@CrossOrigin(origins = "http://localhost:4200")
	public User add_new_user(@RequestBody User user) {
		user.setActivatedUser(true);
		userRepository.save(user);
		return user;
	}
	 @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User updatedUser, HttpSession session) {

		User user = userRepository.findById(id);
		User userlog = userComponent.getLoggedUser();
		User newuser = userRepository.findByName(userlog.getName());
		if(newuser.getId()==id) {

		if (user != null) {
			
			

			user.setId(id);
			
			user.setActivatedUser(user.isActivatedUser());
			if ((updatedUser.getEmail())!= null) {
				user.setEmail(updatedUser.getEmail());
			} else {
				user.setEmail(user.getEmail());
			}
			if ((updatedUser.getImage())!= null) {
				user.setImage(updatedUser.getImage());
			} else {
				user.setImage(user.getImage());
			}
			if ((updatedUser.getLocation())!= null) {
				user.setLocation(updatedUser.getLocation());
			} else {
				user.setLocation(user.getLocation());
			}
			if ((updatedUser.getName())!= null) {
				user.setName(updatedUser.getName());
			} else {
				user.setName(user.getName());
			}
			if ((updatedUser.getOffers())!= null) {
				user.setOffers(updatedUser.getOffers());
			} else {
				user.setOffers(user.getOffers());
			}
			if ((updatedUser.getPasswordHash())!= null) {
				user.setPasswordHash(updatedUser.getPasswordHash());
			} else {
				user.setPasswordHash(user.getPasswordHash());
			}
			
			user.setPhone(user.getPhone());
			
			if ((updatedUser.getProductos())!= null) {
				user.setProductos(updatedUser.getProductos());
			} else {
				user.setProductos(user.getProductos());
			}
			
			user.setRegisterDate(user.getRegisterDate());
			user.setRoles(user.getRoles());
			userRepository.saveAndFlush(user);

			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		} else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping (value = "/api/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable long id, HttpSession session){
		User user = userRepository.findById(id);
		User userlog =(User) session.getAttribute("user");
		if(userlog.getId()==id) {
			if (user != null) {
				userRepository.delete(user);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@JsonView(User.BasicInformation.class)
	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable long id){
		User user = userRepository.findById(id);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@JsonView(User.BasicInformation.class)
	@RequestMapping(value = "/api/users/search/{search}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> searchUsers(@PathVariable String search){
		List<User> users = userService.searchUsers(search);
		if(!users.isEmpty()) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}