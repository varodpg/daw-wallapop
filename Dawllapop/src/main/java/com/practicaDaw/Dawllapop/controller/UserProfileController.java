package com.practicaDaw.Dawllapop.controller;

import com.practicaDaw.Dawllapop.Entities.Friend_request;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.ImageManager.Image;
import com.practicaDaw.Dawllapop.Repository.Friend_RequestRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.practicaDaw.Dawllapop.security.*;
import com.practicaDaw.Dawllapop.services.UserServices;

@Controller

public class UserProfileController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserComponent userComponent;
	@Autowired
	private UserServices uss;
	@Autowired
	private Friend_RequestRepository friendRequestRepo;
	private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "ImgFiles");

	private AtomicInteger imageId = new AtomicInteger();
	private Map<String, Image> images = new ConcurrentHashMap<>();
	@RequestMapping("/add_new_user")
	public String add_new_user(Model model, 
			@RequestParam("name")String name,
			@RequestParam("passwordHash")String password,
			@RequestParam("email")String email,
			@RequestParam("location")String location,
			@RequestParam("file") MultipartFile file){
		User user = new User();
		Date date = new Date();
		user.setRegisterDate(date);
		user.setName(name);
		
		user.setPasswordHash(password);
		
		user.setLocation(location);
		user.setRoles("ROLE_USER");
		user.setEmail(email);
		user.setActivatedUser(true);
		
		String fileName = "UserImg-" + imageId.getAndIncrement() + ".jpg";
		String imageTitle = file.getName(); //the title is the name of the uploaded image
		if (!file.isEmpty()) {
			try {

				File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
				file.transferTo(uploadedFile);
				images.put(fileName, new Image(imageTitle, fileName));
				user.setImage(fileName);

			} catch (Exception e) {

				model.addAttribute("fileName", fileName);
				model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());
			}
		} else {


			return "error file " + file.getName() + " is empty";
		}	
		
		
		userRepository.save(user);
		return "index";
	}

	@RequestMapping("/edit_profile")
	public String editProfile(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute(user);
		return "user-profile";
	}

	@RequestMapping("/editEmailProfileBBDD")
	public String editEmailProfileBBDD(Model model, @RequestParam String email, HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setEmail(email);
		repository.saveAndFlush(user);
		return "/";
	}
	@RequestMapping(value = "/editUserImage",method = RequestMethod.POST)
	public String editUserImage(Model model, @RequestParam("file") MultipartFile file,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		String fileName = "UserImg-" + imageId.getAndIncrement() + ".jpg";
		String imageTitle = file.getName(); //the title is the name of the uploaded image
		if (!file.isEmpty()) {
			try {

				File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
				file.transferTo(uploadedFile);
				images.put(fileName, new Image(imageTitle, fileName));
				user.setImage(fileName);

			} catch (Exception e) {

				model.addAttribute("fileName", fileName);
				model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());
			}
		} else {


			return "error file " + file.getName() + " is empty";
		}		
		repository.saveAndFlush(user);
		return "/";
	}
	@RequestMapping("/editDatesProfileBBDD")
	public String editDatesProfileBBDD(Model model, @RequestParam String name, @RequestParam String location,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setName(name);
		user.setLocation(location);
		repository.saveAndFlush(user);
		return "/";
	}

	@RequestMapping("/editPasswordProfileBBDD")
	public String editPasswordProfileBBDD(Model model, @RequestParam String passwordHash, HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setPasswordHash(passwordHash);
		repository.saveAndFlush(user);
		return "/";
	}

	@RequestMapping("/deleteProfileBBDD")
	public String deleteProfileBBDD(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		repository.delete(user);
		return "/";
	}

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void init() {

	

	}

	@RequestMapping("/user-profile")
	public String serveUserProfile(Model model, @RequestParam Optional<String> emailUser,
			@RequestParam Optional<String> passUser, @RequestParam Optional<Boolean> sent) {
		if (sent.isPresent()) {
			if (emailUser.isPresent()) {
				userComponent.getLoggedUser().setEmail(emailUser.get());
			}
			if (!passUser.get().equals("")) {
				userComponent.getLoggedUser().setPasswordHash(passUser.get());
			}
			userRepository.save(userComponent.getLoggedUser());
		}

		return "user-profile";
	}
	
	@RequestMapping("/sendFriendRequest/{id}")
	public String sendFriendRequest(Model model, HttpSession session, @RequestParam("message") String message, @PathVariable("id") long id){
		User userFrom = (User) session.getAttribute("user");
		User userTo = uss.findUser(id);
		Friend_request friendRequest = new Friend_request(message, userFrom, userTo);
		friendRequestRepo.save(friendRequest);
		
		return "/publicDashboard/" + id;
	}

}
