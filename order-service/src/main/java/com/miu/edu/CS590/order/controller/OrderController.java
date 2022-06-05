package com.miu.edu.CS590.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.miu.edu.CS590.order.VO.ResponseEntityVo;
import com.miu.edu.CS590.order.model.Order;
import com.miu.edu.CS590.order.model.OrderDTO;
import com.miu.edu.CS590.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order) throws JsonProcessingException {
        return orderService.saveOrder(order);
    }
    @GetMapping("/")
    public List<Order> getOrders(){
       return orderService.findOrders();
    }

    @PostMapping("/test")
    public Order testing(@RequestBody Order order) {
        Order tempOrder = order;
        System.out.println(order);
        return tempOrder;
    }

    @PostMapping("/place-order")
    public ResponseEntity<?> placeOrder(@RequestBody OrderDTO orderDTO) throws JsonProcessingException {

        boolean orderSuccess = orderService.placeOrder(orderDTO);

        if(orderSuccess) {
            return new ResponseEntity<String>("The Order has been made successfully", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Some of the items doesn't have enough stock. " +
                " Please modify the quantity and try again", HttpStatus.OK);
    }

}
