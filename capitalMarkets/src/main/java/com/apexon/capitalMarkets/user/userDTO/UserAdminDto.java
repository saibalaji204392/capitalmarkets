package com.apexon.capitalMarkets.user.userDTO;

import com.apexon.capitalMarkets.user.Role;

public class UserAdminDto {
    private Long id;
    private String username;
    private String email;
    private Role role;
    private boolean isAccountExpired;
    private boolean isAccountLocked;
    private boolean  isCredentialsExpired;

    public UserAdminDto(Long id, String username, String email, Role role, boolean isAccountExpired, boolean isAccountLocked, boolean isCredentialsExpired) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.isAccountExpired = isAccountExpired;
        this.isAccountLocked = isAccountLocked;
        this.isCredentialsExpired = isCredentialsExpired;
    }

    public UserAdminDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public boolean isAccountExpired() {
        return isAccountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        isAccountExpired = accountExpired;
    }

    public boolean isAccountLocked() {
        return isAccountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        isAccountLocked = accountLocked;
    }

    public boolean isCredentialsExpired() {
        return isCredentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        isCredentialsExpired = credentialsExpired;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}