package com.apexon.capitalMarkets.invester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/investor")
public class InvestorController {
    @Autowired
    public InvestorService investorService;

    @PostMapping
    public ResponseEntity<String> createInvestor(@RequestBody Investor investor){
        String status = String.valueOf(investorService.createInvestor(investor));
        System.out.println(investor.toString());
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/{investorID}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long investorID) {
        Optional<Investor> investor = investorService.findInvestorById(investorID);
        return investor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Investor by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Investor> getInvestorByEmail(@PathVariable String email) {
        Optional<Investor> investor = investorService.findInvestorByEmail(email);
        return investor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Investor> getAllInvestors() {
        List<Investor> investors = investorService.findAllInvestors();
        return investors;
    }
}
