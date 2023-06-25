package com.techpro.project.service;

import com.techpro.project.model.OrderDetails;
import com.techpro.project.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceOrderDetailsImpl implements ServiceOrderDetails{


    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Override
    public OrderDetails saveOrders(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public Iterable<OrderDetails> findAllOrderDetails(){return orderDetailsRepository.findAll();}


    @Override
    public Optional<OrderDetails> findById(int orderDetailsId){return orderDetailsRepository.findById(orderDetailsId);}

    @Override
    public OrderDetails findByOrderId(int orderId){return orderDetailsRepository.findByOrderId(orderId);}


    @Override
    public void deleteById(int orderDetailsId){orderDetailsRepository.deleteById(orderDetailsId);}

    @Override
    public boolean existById(int orderDetailId){return orderDetailsRepository.existsById(orderDetailId);}
}
