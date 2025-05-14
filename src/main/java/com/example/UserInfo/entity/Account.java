package com.example.UserInfo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javamoney.moneta.Money;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    private long userId;

    @Column(precision = 19, scale = 2)
    private Money balance;

    @Column(name = "initial_balance", precision = 19, scale = 2)
    private Money initialBalance;
}
