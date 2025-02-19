package com.apexon.capitalMarkets.invester;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface InvestorService {

    Investor createInvestor(Investor investor);
    public Optional<Investor> findInvestorById(Long investorID);

    public Optional<Investor> findInvestorByEmail(String email);

    public List<Investor> findAllInvestors();
}
