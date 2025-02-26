package com.apexon.capitalMarkets.user.userDTO;

import com.apexon.capitalMarkets.user.Role;
import java.util.HashSet;
import java.util.Set;

public class AssignRolesDto {
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    private Long userId;
    private Set<Role> roles= new HashSet<>();




}
