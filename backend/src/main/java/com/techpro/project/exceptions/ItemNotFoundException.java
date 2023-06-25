package com.techpro.project.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Integer itemId){
        super("Item with id: "+itemId+" not found!!!");
    }
    public ItemNotFoundException(String itemName){
        super("Item with itemName: "+itemName+" already exist!!!");
    }

}
