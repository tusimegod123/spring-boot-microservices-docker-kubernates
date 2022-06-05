package com.miu.edu.CS590.order.model;

import com.miu.edu.CS590.order.VO.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
//    private String items;
    private String shippingInfo;
    private Integer paymentMethod;
    private Integer userAccountId;
    private String products;

}
