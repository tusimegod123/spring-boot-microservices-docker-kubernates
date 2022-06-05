package com.miu.edu.cs590.shipping.service;

import com.miu.edu.cs590.shipping.common.Order;
import com.miu.edu.cs590.shipping.domain.Shipping;
import com.miu.edu.cs590.shipping.repository.ShippingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    ShippingRepository shippingRepository;
    @Override
    public void saveShipping(Order order) {
        log.info("Shipment has been made successfully");
        System.out.println("INSIDE OF THE SHIPPING METHOD");
        shippingRepository.save(new Shipping(null, order.getShippingInfo(), ""+order.getPaymentMethod(), order.getOrderId()));
    }

    @Override
    public List<Shipping> getShippings() {
        return shippingRepository.findAll();
    }
}
