package com.miu.edu.CS590.account.service;

import com.miu.edu.CS590.account.VO.CreditCard;
import com.miu.edu.CS590.account.VO.PayPal;
import com.miu.edu.CS590.account.VO.ResponseEntityVo;
import com.miu.edu.CS590.account.model.UserAccount;
import com.miu.edu.CS590.account.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class AccountService {
    @Autowired
    private AccountRepository  accountRepository;

    @Autowired
    private RestTemplate restTemplate;


    public UserAccount saveAccount(UserAccount account) {
        log.info("Inside Account controller ");
        return  accountRepository.save(account);
    }

    public UserAccount updateUserAccount(UserAccount userAccount){
      //  UserAccount account = accountRepository.findAccountByAccountId(userAccount.getAccountId());
       //account.setAccountId(account.setAccountId());
        return accountRepository.save(userAccount);
    }

    public List<UserAccount> getAccount(){
        return  accountRepository.findAll();
    }

    public ResponseEntityVo getAccountById(Integer accountId){
        ResponseEntityVo vo = new ResponseEntityVo();
        UserAccount account = accountRepository.findAccountByAccountId(accountId);
        CreditCard creditCard =restTemplate.getForObject("http://CREDIT-CARD-SERVICE/credit-card/" + account.getCreditCardId(),CreditCard.class);
        PayPal payPal = restTemplate.getForObject("http://PAY-PAL-SERVICE/pay-pal/" + account.getPayPalId(),PayPal.class);
        vo.setAccount(account);
        vo.setCreditCard(creditCard);
        vo.setPayPal(payPal);
       // account.setDefaultPaymentMethod(creditCard.getCreditCardName());
       return  vo;
    }

    public UserAccount getAccountByTheId(Integer accountId) {
        return accountRepository.findById(accountId).get();
    }
}
