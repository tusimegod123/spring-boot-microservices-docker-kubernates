package com.miu.edu.cs590.shipping.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.edu.cs590.shipping.common.Order;
import com.miu.edu.cs590.shipping.domain.Shipping;
import com.miu.edu.cs590.shipping.service.ShippingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class ShippingController {

    @Autowired
    ShippingService shippingService;

    @PostMapping("/shipping")
    public ResponseEntity<?> createShipping(@RequestBody String order) {

        ObjectMapper objectMapper = new ObjectMapper();
        Order tempOrder = null;
        try {
            tempOrder = objectMapper.readValue(order, Order.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        shippingService.saveShipping(tempOrder);
        log.info("Shipping send successfully");
        return new ResponseEntity<String>("The Order has been shipped to "
                + tempOrder.getShippingInfo() + " it will arrive soon", HttpStatus.OK);
    }

    @GetMapping("/shippings")
    public List<Shipping> getShippings(){
        return shippingService.getShippings();
    }



}
