package com.miu.edu.cs590.creditcardservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer creditCardId;
    private  String creditCardName;
    private  String cardNumber;
    private Integer ccv;
    private LocalDate expiryDate;
}
