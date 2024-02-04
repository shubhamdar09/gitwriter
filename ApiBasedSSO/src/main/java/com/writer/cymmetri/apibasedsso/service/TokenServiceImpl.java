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
    private ApiService apiService;

    @Value("${app.id}")
    private String appId;

    @Value("${app.pass}")
    private String appPass;

    @Override
    public String processToken(String authToken, HttpServletRequest req) {
        String ipAddress = req.getRemoteAddr();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("App.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            TokenRequest tokenRequest = new TokenRequest(appId, appPass, authToken, ipAddress);

            String inputStr = "app_id=" + tokenRequest.getAppId() +
                    "&app_pass=" + tokenRequest.getAppPass() +
                    "&user_session_string=" + tokenRequest.getUserSessionString() +
                    "&user_ip=" + tokenRequest.getUserIp();

            String response = apiService.callApi("https://shubham09.cymmetri.io/api-sso/api/sso/validateToken", inputStr);

            TokenResponse tokenResponse = new TokenResponse();
            JSONObject respJSON = new JSONObject(response);
            tokenResponse.setAllowUser(respJSON.getBoolean("allow_user"));

            if (tokenResponse.isAllowUser()) {
                return "Dashboard";
            } else {
                return "redirect:/Login.jsp";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/error.jsp";
        }
    }
}
