package com.apexon.capitalMarkets.user;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    private int userId;
    @Column(length = 20)
    private int firstName;
    @Column(length =20)
    private int lastName;
    @Enumerated(EnumType.STRING)
    private role role;

}
