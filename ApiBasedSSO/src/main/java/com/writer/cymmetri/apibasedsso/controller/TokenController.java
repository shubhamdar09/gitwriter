package com.writer.cymmetri.apibasedsso.controller;

import com.writer.cymmetri.apibasedsso.service.TokenService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/api")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/getToken")
    public String getToken(@RequestParam("auth_token") String authToken, HttpServletRequest req) throws IOException {
        return tokenService.processToken(authToken, req);
    }
}
