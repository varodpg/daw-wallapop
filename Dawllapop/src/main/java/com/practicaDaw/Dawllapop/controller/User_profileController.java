package com.practicaDaw.Dawllapop.controller;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Controller
@RequestMapping("/user-profile")

public class User_profileController {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void init() {

        User u = new User("Alvaro", "varoTheBestNoob@hotmail.com", "soy tontito", "Mostoles");
        repository.save(u);


    }


}
