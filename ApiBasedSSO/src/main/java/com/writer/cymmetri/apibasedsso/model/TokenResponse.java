package com.writer.cymmetri.apibasedsso.model;

public class TokenResponse {
    private boolean allowUser;
    private String userRole;
    private int userId;

    // No-argument constructor
    public TokenResponse() {
    }

    // Constructor with parameters
    public TokenResponse(boolean allowUser, String userRole, int userId) {
        this.allowUser = allowUser;
        this.userRole = userRole;
        this.userId = userId;
    }

    // Getter methods
    public boolean isAllowUser() {
        return allowUser;
    }

    public String getUserRole() {
        return userRole;
    }

    public int getUserId() {
        return userId;
    }

    // Setter methods (if needed)
    public void setAllowUser(boolean allowUser) {
        this.allowUser = allowUser;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
