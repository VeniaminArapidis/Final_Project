package com.techpro.project.service;

import com.techpro.project.model.Orders;
import com.techpro.project.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceOrdersImpl implements ServiceOrders{
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders saveOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Iterable<Orders> findAllOrders(){return ordersRepository.findAll();}

    @Override
    public Optional<Orders> findById(int orderId){return ordersRepository.findById(orderId);}

    @Override
    public boolean existById(int orderId){return ordersRepository.existsById(orderId);}

    @Override
    public void deleteById(int orderId){ordersRepository.deleteById(orderId);}
}
