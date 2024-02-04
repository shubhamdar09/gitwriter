package com.writer.cymmetri.apibasedsso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CustomErrorController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFoundError(NoHandlerFoundException ex, Model model) {
        model.addAttribute("error", "Not Found");
        model.addAttribute("status", HttpStatus.NOT_FOUND.value());
        return "error"; // Ensure you have a corresponding error.html or error.jsp view
    }
}
