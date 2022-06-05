package com.miu.edu.CS590.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="accounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String firstName;
    private String lastName;
    private String  email;
    private String shippingAddress;
   private Integer creditCardId;
   private Integer payPalId;
   private  String defaultPaymentMethod;

}
