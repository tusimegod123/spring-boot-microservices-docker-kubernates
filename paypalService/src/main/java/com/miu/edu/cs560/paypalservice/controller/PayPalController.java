package com.miu.edu.cs560.paypalservice.controller;

import com.miu.edu.cs560.paypalservice.model.PayPal;
import com.miu.edu.cs560.paypalservice.service.PayPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pay-pal")
public class PayPalController {
    @Autowired
    private PayPalService payPalService;

    @PostMapping("/")
    public PayPal savePayPal(@RequestBody PayPal payPal) {
        return payPalService.savePayPal(payPal);
    }

    @GetMapping("/")
    public List<PayPal> getPaypalAccounts() {
        return payPalService.getPaypalAccounts();
    }

    @GetMapping("/{payPalId}")
    public PayPal getCreditCard(@PathVariable("payPalId") Integer payPalId) {
        return payPalService.getPayPal(payPalId);
    }
}
