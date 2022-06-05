package com.miu.edu.cs590.shipping.service;

import com.miu.edu.cs590.shipping.common.Order;
import com.miu.edu.cs590.shipping.domain.Shipping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShippingService {
    void saveShipping(Order order);

    List<Shipping> getShippings();
}
