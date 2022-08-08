package ru.jabori.potsg.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jabori.potsg.crud.dao.UserDao;

@RestController
public class DeafaultController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/hello")
    public String firstPage() {
        System.out.println("Hello");
        userDao.createNewChat();

        return "Hello";
    }
}
