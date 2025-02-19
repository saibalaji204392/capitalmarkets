package com.apexon.capitalMarkets.invester;

import lombok.Builder;

import java.util.Date;

@Builder
public class InvestorDTO {
    private int investorID;
    private String firstName;
    private String lastName;
    private String email;
    private long accountNo;
    private String accountType;
    private String kycStatus;
    private String creationDate;

    public InvestorDTO(int investorID, String firstName, String lastName, String email, long accountNo, String accountType, String kycStatus, Date creationDate) {
        this.investorID = investorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.kycStatus = kycStatus;
        this.creationDate = String.valueOf(creationDate);
    }

    public int getInvestorID() {
        return investorID;
    }

    public void setInvestorID(int investorID) {
        this.investorID = investorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
