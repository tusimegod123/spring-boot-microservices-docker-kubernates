package com.miu.edu.CS590.account.VO;

import com.miu.edu.CS590.account.model.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntityVo {
    private UserAccount account;
    private  CreditCard creditCard;
    private  PayPal payPal;

}
