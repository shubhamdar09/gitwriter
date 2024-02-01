package com.writer.cymmetri.apibasedsso.service;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public interface TokenService {

    String processToken(String authToken, HttpServletRequest req) throws IOException;

}
