package com.writer.cymmetri.apibasedsso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class TokenResponse {
    private boolean allowUser;
    private String userRole;
    private int userId;


    // Lombok-generated getter for boolean field
    public boolean isAllowUser() {
        return allowUser;
    }
    // Explicitly defined setter for boolean field
    public void setAllowUser(boolean allowUser) {
        this.allowUser = allowUser;
    }
}
