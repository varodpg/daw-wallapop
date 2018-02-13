package com.practicaDaw.Dawllapop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;


@Controller
@RequestMapping("/index")
public class IndexController {
    //Si se abre la URL http://127.0.0.1:8080/h2-console y se configura
    //la URL JDBC con el valor jdbc:h2:mem:testdb se puede acceder a la
    //base de datos de la aplicación

    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void init() {
        ArrayList<String[]> especificaciones = new ArrayList<>();

        ArrayList<String> tags = new ArrayList<>();
        String[] a = new String[2];
        a[0] = "titulo";
        a[1] = "hi";
        especificaciones.add(a);
        tags.add("tag1");
        for (int i = 0; i < 15; i++) {
            Product p = new Product("Mack", "es la leche", especificaciones, tags, 300);
            repository.save(p);
        }

    }


}
