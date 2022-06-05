package com.miu.edu.CS590.order.VO;

import com.miu.edu.CS590.order.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntityVo {
    private Order order;
    private UserAccount account;
    private  CreditCard creditCard;
    private  PayPal payPal;

}
