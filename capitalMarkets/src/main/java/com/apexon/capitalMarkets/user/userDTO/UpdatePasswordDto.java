package com.apexon.capitalMarkets.user.userDTO;

public class UpdatePasswordDto {
    public UpdatePasswordDto(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
}
