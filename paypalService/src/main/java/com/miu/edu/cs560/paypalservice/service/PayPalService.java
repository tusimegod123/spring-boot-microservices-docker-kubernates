package com.miu.edu.cs560.paypalservice.service;

import com.miu.edu.cs560.paypalservice.model.PayPal;
import com.miu.edu.cs560.paypalservice.repository.PayPalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayPalService {
    @Autowired
    PayPalRepository payPalRepository;
    public PayPal savePayPal(PayPal payPal) {
        return payPalRepository.save(payPal);
    }

    public PayPal getPayPal(Integer payPalId) {
        return payPalRepository.findByPayPalId(payPalId);
    }

    public List<PayPal> getPaypalAccounts() {
        return payPalRepository.findAll();
    }
}
