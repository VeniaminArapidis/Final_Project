package com.techpro.project.controllers;

import com.techpro.project.exceptions.ItemDoesntExistException;
import com.techpro.project.exceptions.OrderNotFoundException;
import com.techpro.project.exceptions.PersonDoesntExistException;
import com.techpro.project.model.Items;
import com.techpro.project.model.OrderDetails;
import com.techpro.project.model.Orders;
import com.techpro.project.model.People;
import com.techpro.project.service.ServiceItems;
import com.techpro.project.service.ServiceOrderDetails;
import com.techpro.project.service.ServiceOrders;
import com.techpro.project.service.Servicepeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

//Restfull controller for Orders Table
@RestController
@CrossOrigin("http://localhost:3000")
public class OrdersController {

    @Autowired
    private ServiceOrders serviceOrders;
    @Autowired private Servicepeople servicepeople;

    @Autowired private ServiceOrderDetails serviceOrderDetails;
    @Autowired private ServiceItems serviceItems;

    //Get all info of Orders Table

    @GetMapping(value = "/orders", produces = "application/json")
    Iterable<Orders> findAllOrders() {return serviceOrders.findAllOrders();}


    //Post new Orders to the Orders Table and new OrderDetails to the OrderDetails Table

    @PostMapping(value = "/makeAnOrder", produces = "application/json")
        Orders order(@RequestBody HashMap<String, String> requestBody)throws Exception {
        People person = servicepeople.findByEmail(requestBody.get("email"));
        Items item = serviceItems.findByItemName(requestBody.get("itemName"));
        if(person == null){ throw new PersonDoesntExistException(requestBody.get("email"));}
        if(item == null){throw new ItemDoesntExistException(requestBody.get("itemName"));}
        Orders ord = new Orders();
        ord.setEmail(person);
        serviceOrders.saveOrders(ord);
        OrderDetails orderDetail = new OrderDetails();
        int quantity = Integer.parseInt(requestBody.get("quantity"));
        orderDetail.setQuantity(quantity);
        orderDetail.setItemId(item);
        orderDetail.setOrderId(ord);
        serviceOrderDetails.saveOrders(orderDetail);
        return ord;
    }


    @DeleteMapping(value = "/orderDel/{orderId}", produces = "application/json")
    String deleteOrder(@PathVariable Integer orderId){
        if(!serviceOrders.existById(orderId)){
            throw new OrderNotFoundException(orderId);
        }
        serviceOrders.deleteById(orderId);
        return "Item with id: "+ orderId + " has been deleted!";
    }


}
