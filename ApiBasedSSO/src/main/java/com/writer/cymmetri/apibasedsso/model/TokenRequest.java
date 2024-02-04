package com.writer.cymmetri.apibasedsso.model;

public class TokenRequest {
    private String appId;
    private String appPass;
    private String userSessionString;
    private String userIp;

    // Constructor with parameters
    public TokenRequest(String appId, String appPass, String userSessionString, String userIp) {
        this.appId = appId;
        this.appPass = appPass;
        this.userSessionString = userSessionString;
        this.userIp = userIp;
    }

    // Getter methods
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

    // Setter methods (if needed)
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setAppPass(String appPass) {
        this.appPass = appPass;
    }

    public void setUserSessionString(String userSessionString) {
        this.userSessionString = userSessionString;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}
