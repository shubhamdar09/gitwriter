package com.writer.cymmetri.apibasedsso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class TokenRequest {
    private String appId;
    private String appPass;
    private String userSessionString;
    private String userIp;
    

    // Explicitly generated getters
    public String getAppId() {
        return appId;
    }

    public String getAppPass() {
        return appPass;
    }

    public String getUserSessionString() {
        return userSessionString;
    }

    public String getUserIp() {
        return userIp;
    }

    public TokenRequest(String appId, String appPass, String userSessionString, String userIp) {
        this.appId = appId;
        this.appPass = appPass;
        this.userSessionString = userSessionString;
        this.userIp = userIp;
    }
}
