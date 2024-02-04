package com.writer.cymmetri.apibasedsso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

    private String email;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String mobileNo;

    // Lombok generates getters and setters

    public User(Integer userId, String email, String firstName, String lastName, String login, String password, String mobileNo) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.mobileNo = mobileNo;
    }

	public Integer getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}

    // No-args constructor can be omitted unless needed

    // Additional methods or customization can be added as needed
}
