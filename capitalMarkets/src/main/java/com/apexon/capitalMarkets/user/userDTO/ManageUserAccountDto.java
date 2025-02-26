package com.apexon.capitalMarkets.user.userDTO;
import com.apexon.capitalMarkets.user.Role;

public class ManageUserAccountDto {
    private Long id;
    private Role role;
    private boolean isAccountExpired;
    private boolean isAccountLocked;
    private boolean  isCredentialsExpired;

    public ManageUserAccountDto(Long id, Role role, boolean isAccountExpired, boolean isAccountLocked, boolean isCredentialsExpired) {
        this.id = id;
        this.role = role;
        this.isAccountExpired = isAccountExpired;
        this.isAccountLocked = isAccountLocked;
        this.isCredentialsExpired = isCredentialsExpired;
    }

    public ManageUserAccountDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
