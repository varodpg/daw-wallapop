package com.practicaDaw.Dawllapop.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;


public class Add_productController {


    @RequestMapping("/add_product")
    public String index() {
        return "add_product";
    }

}
