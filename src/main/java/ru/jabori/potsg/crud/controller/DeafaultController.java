package ru.jabori.potsg.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jabori.potsg.crud.dao.TransactionService;
import ru.jabori.potsg.crud.models.PostgreSqlModels.Chats;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class DeafaultController {

    @Autowired
    private TransactionService userDao;

    @GetMapping("/hello")
    public String firstPage() {

        return "Hello";

    }



}
