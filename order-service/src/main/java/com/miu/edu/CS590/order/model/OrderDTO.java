package com.miu.edu.CS590.order.model;

import com.miu.edu.CS590.order.VO.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String shippingInfo;
    private Integer paymentMethod;
    private Integer userAccountId;
    private List<Product> products;

}
