package com.miu.edu.cs590.creditcardservice.service;

import com.miu.edu.cs590.creditcardservice.model.CreditCard;
import com.miu.edu.cs590.creditcardservice.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCard saveCreditCard(CreditCard creditCard){
        return  creditCardRepository.save(creditCard);
    }

    public CreditCard getCreditCard(Integer creditCardId) {
        return creditCardRepository.findByCreditCardId(creditCardId);
    }

    public List<CreditCard> getCreditCards() {
        return creditCardRepository.findAll();
    }
}
