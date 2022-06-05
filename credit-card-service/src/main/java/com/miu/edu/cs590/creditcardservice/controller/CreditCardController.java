package com.miu.edu.cs590.creditcardservice.controller;

import com.miu.edu.cs590.creditcardservice.model.CreditCard;
import com.miu.edu.cs590.creditcardservice.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-card")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    @PostMapping("/")
    public CreditCard saveCreditCard(@RequestBody CreditCard creditCard){
        return creditCardService.saveCreditCard(creditCard);
    }

    @GetMapping("/")
    public List<CreditCard> getCreditCards() {
        return creditCardService.getCreditCards();
    }

    @GetMapping("/{creditCardId}")
    public CreditCard getCreditCard(@PathVariable ("creditCardId") Integer creditCardId){
        return  creditCardService.getCreditCard(creditCardId);
    }

}
