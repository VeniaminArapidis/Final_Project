package com.techpro.project.controllers;

import com.techpro.project.exceptions.ItemNotFoundException;
import com.techpro.project.model.Items;
import com.techpro.project.repository.ItemsRepository;
import com.techpro.project.service.ServiceItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

//Restfull controller for save, update, view and delete data from Items Table.
@RestController
@CrossOrigin("http://localhost:3000")
public class ItemsController {
    @Autowired private ServiceItems serviceItems;
    @Autowired private ItemsRepository itemsRepository;
    // Save data to Item table.
    //If item already exist, throw exception ""Item with itemName: "+itemName+" already exist!!!""
    @PostMapping(value = "/item", produces = "application/json")
    Items newItem(@RequestBody HashMap<String, String> requestBody)throws Exception{
        Items item = serviceItems.findByItemName(requestBody.get("itemName"));
        if(item != null){
            throw new ItemNotFoundException(item.getItemName());
        }
        Items itm = new Items();
        itm.setItemName(requestBody.get("itemName"));
        return serviceItems.saveItems(itm);
    }

    //Get all items from Items Table
    @GetMapping(value = "/items", produces = "application/json")
    Iterable<Items> findAllItems() {return serviceItems.findAllItems();}

    //Get item with the specific itemID from Items Table
    @GetMapping(value = "/item/{itemId}", produces = "application/json")
    Items getItemById(@PathVariable Integer itemId){
        return itemsRepository.findById(itemId)
                .orElseThrow(()->new ItemNotFoundException(itemId));
    }


    //Update Item
    @PutMapping(value = "item/{itemId}", produces = "application/json")
    Items updateItems(@RequestBody Items newItem, @PathVariable Integer itemId){
        return serviceItems.findById(itemId)
                .map(item -> {
                    item.setItemName(newItem.getItemName());
                    return serviceItems.saveItems(item);
                }) .orElseThrow(()-> new ItemNotFoundException(itemId));
    }

    //Delete item by ID
    @DeleteMapping(value = "/items/{itemId}", produces = "application/json")
    String deleteItem(@PathVariable Integer itemId){
        if(!serviceItems.existById(itemId)){
            throw new ItemNotFoundException(itemId);
        }
        serviceItems.deleteById(itemId);
        return "Item with id: "+ itemId + " has been deleted!";
    }




}
