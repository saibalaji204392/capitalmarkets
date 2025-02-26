package com.apexon.capitalMarkets.user.Repository;

import com.apexon.capitalMarkets.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface RolesRepository extends JpaRepository<Role,Long> {
    Set<Role> findByRole(Set<Role> names);
}
