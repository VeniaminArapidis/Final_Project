package com.techpro.project.service;


import com.techpro.project.model.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface ServiceOrderDetails {
    OrderDetails saveOrders(OrderDetails orderDetails);

    Iterable<OrderDetails> findAllOrderDetails();

    Optional <OrderDetails> findById(int orderDetailsId);

    OrderDetails findByOrderId(int orderId);

    void deleteById(int orderDetailsId);

    boolean existById(int orderDetailId);
}
