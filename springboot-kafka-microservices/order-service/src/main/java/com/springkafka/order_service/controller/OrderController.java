package com.springkafka.order_service.controller;

import com.springkafka.base_domains.dto.Order;
import com.springkafka.base_domains.dto.OrderEvent;
import com.springkafka.order_service.kafka.OrderProducer;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/order")
    public String placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setMessage("PENDING");
        orderEvent.setStatus("Order status is pending state");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return "Ordered Places Successfully";

    }
}
