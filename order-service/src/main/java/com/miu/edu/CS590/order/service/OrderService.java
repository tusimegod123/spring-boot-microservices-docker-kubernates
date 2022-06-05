package com.miu.edu.CS590.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.edu.CS590.order.VO.*;
import com.miu.edu.CS590.order.model.Order;
import com.miu.edu.CS590.order.model.OrderDTO;
import com.miu.edu.CS590.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    public Order saveOrder(Order order) throws JsonProcessingException {
        ResponseEntityVo vo = new ResponseEntityVo();
       // Order order2 = new Order(null,order.getItems(),order.getPaymentMethod(),order.getUserAccountId());

        Order order1 =  orderRepository.save(order);
       UserAccount account = restTemplate.getForObject("http://ACCOUNT-SERVICE/account/"+ order1.getUserAccountId(),UserAccount.class);
        assert account != null;
        CreditCard creditCard =restTemplate.getForObject("http://CREDIT-CARD-SERVICE/credit-card/" + order1.getPaymentMethod(),CreditCard.class);
        PayPal payPal = restTemplate.getForObject("http://PAY-PAL-SERVICE/pay-pal/" + order1.getPaymentMethod(),PayPal.class);
      //  vo.setAccount(account);
        vo.setCreditCard(creditCard);
       vo.setPayPal(payPal);
       if (order1.getPaymentMethod() == 1){
           account.setDefaultPaymentMethod(creditCard.getCreditCardName());
       }else if (order1.getPaymentMethod() ==2 ){
           account.setDefaultPaymentMethod(payPal.getPayPalDetails());
       }
      account.setAccountId(order1.getUserAccountId());
//      account.setDefaultPaymentMethod(order1.getPaymentMethod());
        ObjectMapper objectMapper = new ObjectMapper();
        String orderString = objectMapper.writeValueAsString(account);
        restTemplate.put("http://ACCOUNT-SERVICE/account/update", orderString, String.class);

       return  order1;
    }

    public boolean placeOrder(OrderDTO orderDTO) throws JsonProcessingException {

        // SAM'S CODE PART
        List <Product> products = orderDTO.getProducts();

        log.info("INSIDE OF CHECK METHOD");
        for(Product product : products) {
            System.out.println(product);
            Product tempProduct = restTemplate.getForObject("http://PRODUCT-SERVICE/products/{productName}", Product.class, product.getName());
            if(tempProduct.getQuantity() <= product.getQuantity()) {
                return false;
            } else {
                restTemplate.put("http://PRODUCT-SERVICE/products/{productName}/{quantity}", Product.class, product.getName(), product.getQuantity());
            }
        }

        log.info("OUTSIDE OF THE LOOP AND END OF SAM'S CODE");

        // GODWIN'S CODE PART
        ResponseEntityVo vo = new ResponseEntityVo();

        Order tempOrder = convertOrderDTO(orderDTO);

        Order order1 = orderRepository.saveAndFlush(tempOrder);
        UserAccount account = restTemplate.getForObject("http://ACCOUNT-SERVICE/account/"+ order1.getUserAccountId(),UserAccount.class);
        assert account != null;
        CreditCard creditCard =restTemplate.getForObject("http://CREDIT-CARD-SERVICE/credit-card/" + order1.getPaymentMethod(),CreditCard.class);
        PayPal payPal = restTemplate.getForObject("http://PAY-PAL-SERVICE/pay-pal/" + order1.getPaymentMethod(),PayPal.class);
        //  vo.setAccount(account);
        vo.setCreditCard(creditCard);
        vo.setPayPal(payPal);
        if (order1.getPaymentMethod() == 1){
            account.setDefaultPaymentMethod(creditCard.getCreditCardName());
        }else if (order1.getPaymentMethod() ==2 ){
            account.setDefaultPaymentMethod(payPal.getPayPalDetails());
        }
        account.setAccountId(order1.getUserAccountId());
        ObjectMapper objectMapper = new ObjectMapper();
        String orderString = objectMapper.writeValueAsString(account);
        restTemplate.put("http://ACCOUNT-SERVICE/account/update", orderString, String.class);

        String orderShippingString = objectMapper.writeValueAsString(order1);
        restTemplate.postForObject("http://SHIPPING-SERVICE/shipping", orderShippingString, String.class);
        log.info("Shipping Order...");

        return true;
    }

    private Order convertOrderDTO(OrderDTO orderDTO) {

        StringBuffer sb = new StringBuffer();
        Order tempOrder = new Order();
        tempOrder.setShippingInfo(orderDTO.getShippingInfo());
        tempOrder.setPaymentMethod(orderDTO.getPaymentMethod());
        tempOrder.setUserAccountId(orderDTO.getUserAccountId());
        for(Product product : orderDTO.getProducts()) {
            sb.append(product.getName() + "= ").append(product.getQuantity()+",");
        }
        tempOrder.setProducts(sb.toString());
        return tempOrder;
    }

    public List<Order> findOrders(){
        return orderRepository.findAll();
    }

}
