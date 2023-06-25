package com.techpro.project.service;

import com.techpro.project.model.Orders;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ServiceOrders {

    Orders saveOrders(Orders orders);

    Iterable<Orders> findAllOrders();

    Optional<Orders> findById(int orderId);

    boolean existById(int orderId);

    void deleteById(int orderId);

}
