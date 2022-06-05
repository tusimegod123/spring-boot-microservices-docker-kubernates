package com.miu.edu.cs560.paypalservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="paypal")
public class PayPal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payPalId;
    private  String PayPalDetails;
}
