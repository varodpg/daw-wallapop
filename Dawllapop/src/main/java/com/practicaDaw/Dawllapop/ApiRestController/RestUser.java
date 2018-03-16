package com.practicaDaw.Dawllapop.ApiRestController;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.UserRepository;

@RestController
public class RestUser {
	@Autowired UserRepository userRepository;

	
	@RequestMapping (value="/api/users", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)


	public User add_new_user(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}
	
	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User updatedUser, HttpSession session) {

		User user = userRepository.findById(id);
		User userlog =(User) session.getAttribute("user");
		if(userlog.getId()==id) {

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

	
}