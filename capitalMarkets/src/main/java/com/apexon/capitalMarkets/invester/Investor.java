package com.apexon.capitalMarkets.invester;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int investorID;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    private String email;
    private long accountNo;
    @Enumerated(EnumType.STRING)
    private accountType accountType;
    @Enumerated(EnumType.STRING)
    private kycStatus kycStatus;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date creationDate;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public com.apexon.capitalMarkets.invester.accountType getAccountType() {
        return accountType;
    }

    public void setAccountType(com.apexon.capitalMarkets.invester.accountType accountType) {
        this.accountType = accountType;
    }

    public com.apexon.capitalMarkets.invester.kycStatus getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(com.apexon.capitalMarkets.invester.kycStatus kycStatus) {
        this.kycStatus = kycStatus;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "investorID=" + investorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + email +
                ", accountNo=" + accountNo +
                ", accountType=" + accountType +
                ", kycStatus=" + kycStatus +
                ", creationDate=" + creationDate +
                '}';
    }
}
