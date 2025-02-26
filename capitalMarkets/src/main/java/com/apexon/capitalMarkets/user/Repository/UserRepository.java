package com.apexon.capitalMarkets.user.Repository;
import com.apexon.capitalMarkets.user.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
        // Custom queries can go here, for example:
        // List<User> findByRole(Role role);
        Optional<User> findByUsername(String username);
        boolean existsByEmail(String email);
        boolean existsByEmailAndIdNot(String email,Long id);
    }


