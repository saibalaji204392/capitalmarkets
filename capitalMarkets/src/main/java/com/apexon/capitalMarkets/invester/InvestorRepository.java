package com.apexon.capitalMarkets.invester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Integer> {
    Optional<Investor> findByInvestorID(Long investorID);
    Optional<Investor> findByEmail(String email);
}
