package com.techpro.project.repository;

import com.techpro.project.model.OrderDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    OrderDetails findByOrderId(int orderId);

}
