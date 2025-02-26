package com.apexon.capitalMarkets.user.userDTO;


public class UpdateUserDto {
    private String username;

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

    private String email;

    public UpdateUserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
