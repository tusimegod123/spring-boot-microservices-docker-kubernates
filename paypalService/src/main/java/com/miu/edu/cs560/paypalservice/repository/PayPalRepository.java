package com.miu.edu.cs560.paypalservice.repository;

import com.miu.edu.cs560.paypalservice.model.PayPal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayPalRepository extends JpaRepository<PayPal, Integer> {
    PayPal findByPayPalId(Integer payPalId);
}
