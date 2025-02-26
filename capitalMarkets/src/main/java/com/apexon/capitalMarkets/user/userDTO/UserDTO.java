package com.apexon.capitalMarkets.user.userDTO;

import com.apexon.capitalMarkets.user.Entity.User;
import com.apexon.capitalMarkets.user.Role;

public class UserDTO {
    private Long id;
        private String username;
        private String email;
        private Role role;

        // Constructors
        public UserDTO() {}

        public UserDTO(Long id, String username, String email, Role role) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.role = role;
        }

        // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        // Method to convert DTO to Entity
        public User toEntity() {
            return new User(null, this.username, this.email, this.role);
        }
}
