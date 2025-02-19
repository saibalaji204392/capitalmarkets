package com.apexon.capitalMarkets.invester;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    private InvestorRepository repo;

    private final InvestorRepository investorRepository;

    @Autowired
    public InvestorServiceImpl(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    @Override
    public Optional<Investor> findInvestorById(Long id) {
        // Logic to find investor by ID
        return investorRepository.findByInvestorID(id);
    }

    @Override
    public Optional<Investor> findInvestorByEmail(String email) {
        // Logic to find investor by email
        return investorRepository.findByEmail(email);
    }

    @Override
    public List<Investor> findAllInvestors() {
        List<Investor> listofinvestors= investorRepository.findAll();
        System.out.println(listofinvestors);
        return listofinvestors;
    }

    @Override
    public Investor createInvestor(Investor investor) {
        System.out.println(investor.toString());
        repo.save(investor);
        return null;
    }

}
