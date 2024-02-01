package com.writer.cymmetri.apibasedsso.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.writer.cymmetri.apibasedsso.model.TokenRequest;
import com.writer.cymmetri.apibasedsso.model.TokenResponse;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private ApiServiceImpl apiService;

    @Value("${app.id}")
    private String appId;

    @Value("${app.pass}")
    private String appPass;

    @Override
    public String processToken(String authToken, HttpServletRequest req) throws IOException {
        String ipAddress = req.getRemoteAddr();
        System.out.println("IP: " + ipAddress);

        Properties properties = new Properties();
        boolean allowUser = false;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("App.properties")) {
            properties.load(inputStream);

            // Create TokenRequest object
            TokenRequest tokenRequest = new TokenRequest(appId, appPass, authToken, ipAddress);
            System.out.println(tokenRequest);

            // Convert TokenRequest to query string
            String inputStr = "app_id=" + tokenRequest.getAppId() +
                              "&app_pass=" + tokenRequest.getAppPass() +
                              "&user_session_string=" + tokenRequest.getUserSessionString() +
                              "&user_ip=" + tokenRequest.getUserIp();
            System.out.println(inputStr);

            // Call the API with the query string
            String response = apiService.callApi("https://shubham09.cymmetri.io/api-sso/api/sso/validateToken", inputStr);
            System.out.println(response);

            // Parse the response into TokenResponse
            TokenResponse tokenResponse = new TokenResponse();
            JSONObject respJSON = new JSONObject(response);
            tokenResponse.setAllowUser(respJSON.getBoolean("allow_user"));
            // Set other properties of tokenResponse based on your response JSON

            System.out.println(tokenResponse.isAllowUser());

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (allowUser) {
            return "Dashboard";
        } else {
            return "redirect:/Login.jsp";
        }
    }
}
