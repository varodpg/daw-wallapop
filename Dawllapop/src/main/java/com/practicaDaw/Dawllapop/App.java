package com.practicaDaw.Dawllapop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableMongoRepositories(basePackageClasses = UserRepository.class)
//@ComponentScan({"com.practicaDaw.Dawllapop"})
//@ComponentScan({"com.practicaDaw.Dawllapop.controller.UserProfileController"})
//@ComponentScan({"com.practicaDaw.Dawllapop.security"})
//@ComponentScan({"com.practicaDaw.Dawllapop.Entities"})

public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

