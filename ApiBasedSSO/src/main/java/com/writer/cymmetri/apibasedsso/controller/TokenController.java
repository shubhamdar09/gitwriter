package com.writer.cymmetri.apibasedsso.controller;

	import org.json.JSONObject;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;

import com.writer.cymmetri.apibasedsso.service.TokenServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

	@Controller
	@RequestMapping("/api")
	public class TokenController {

	    @Autowired
	    private TokenServiceImpl tokenService;

	    @RequestMapping("/getToken")
	    public String getToken(@RequestParam("auth_token") String authToken, HttpServletRequest req) throws IOException {
	        return tokenService.processToken(authToken, req);
	    }
	}
