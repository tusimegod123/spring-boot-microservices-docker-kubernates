package com.miu.edu.CS590.account.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.edu.CS590.account.VO.ResponseEntityVo;
import com.miu.edu.CS590.account.model.UserAccount;
import com.miu.edu.CS590.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/")
    public UserAccount saveAccount(@RequestBody UserAccount account){
        log.info("Inside Account controller ");
        return accountService.saveAccount(account);
    }

    @GetMapping("/")
    public List<UserAccount> getAccount(){
        log.info("Inside Account controller Get all user accounts ");
        return accountService.getAccount();
    }
    @PutMapping(value = {"/{userAccountId}"})
    public  UserAccount updateUserAccount(@RequestBody UserAccount userAccount, @PathVariable Integer userAccountId){
        userAccount.setAccountId(userAccountId);
        accountService.updateUserAccount(userAccount);
        return userAccount;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateInternalAccount(@RequestBody String userAccount) {
        System.out.println("INSIDE OF THE SHIPPING CONTROLLER");
        ObjectMapper objectMapper = new ObjectMapper();
        UserAccount tempOrder = null;
        try {
            tempOrder = objectMapper.readValue(userAccount, UserAccount.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        UserAccount userAccount1 = accountService.getAccountByTheId(tempOrder.getAccountId());
        userAccount1.setDefaultPaymentMethod(tempOrder.getDefaultPaymentMethod());
        accountService.updateUserAccount(userAccount1);
        return new ResponseEntity<>("The Account has been"
                + " Updated", HttpStatus.OK);
    }
    @GetMapping("/{accountId}")
    public ResponseEntityVo getAccountById(@PathVariable("accountId") Integer accountId){
        log.info("Inside Account controller ");
        return accountService.getAccountById(accountId);
    }
}
