package com.apexon.capitalMarkets.user.userDTO;


import com.apexon.capitalMarkets.user.Role;

public class UserRegisterDto {
    private String username;
    private String email;
    private String password;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserRegisterDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRegisterDto(String username, String email, String password,Role role) {
        this.username = username;
        this.role=role;
        this.email = email;
        this.password = password;
    }


}