package com.miu.edu.CS590.order.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {
    private Integer accountId;
    private String firstName;
    private String lastName;
    private String email;
    private String shippingAddress;
    private Integer creditCardId;
    private Integer payPalId;
    private String defaultPaymentMethod;
}