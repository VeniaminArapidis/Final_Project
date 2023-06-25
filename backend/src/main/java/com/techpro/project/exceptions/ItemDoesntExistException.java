package com.techpro.project.exceptions;

public class ItemDoesntExistException extends RuntimeException{
     public ItemDoesntExistException(String itemName){ super("Item with itemName: "+itemName+" doesn't  exist!!!");  }
}
