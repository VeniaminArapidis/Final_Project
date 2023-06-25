package com.techpro.project.controllers;



import com.techpro.project.model.OrderDetails;
import com.techpro.project.service.ServiceOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Restfull controller for OrderDetails Table
@CrossOrigin("http://localhost:3000")
@RestController
public class OrderDetailsController {

    @Autowired private ServiceOrderDetails serviceOrderDetails;
    //Get OrderDetails from OrderDetails table
    @GetMapping(value = "/orderDetails", produces = "application/json")
    Iterable<OrderDetails> findAllOrderDetails() {return serviceOrderDetails.findAllOrderDetails();}




}
