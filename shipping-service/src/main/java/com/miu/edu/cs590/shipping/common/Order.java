package com.miu.edu.cs590.shipping.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer orderId;
    private String shippingInfo;
    private Integer paymentMethod;
    private Integer userAccountId;
    private String products;

}