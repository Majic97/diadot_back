package ru.jabori.potsg.crud.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;

@ControllerAdvice
@ResponseBody
public class ExceptionsController {

    public ExceptionsController() {
    }

    @ExceptionHandler(SQLException.class)
    public String handleSqlException(SQLException e) {
        return e.getMessage();
    }

    @ExceptionHandler(IOException.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }


}
