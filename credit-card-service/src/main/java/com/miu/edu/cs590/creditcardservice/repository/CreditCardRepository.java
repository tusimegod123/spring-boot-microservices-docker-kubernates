package com.miu.edu.cs590.creditcardservice.repository;

import com.miu.edu.cs590.creditcardservice.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    CreditCard findByCreditCardId(Integer creditCardId);
}
