package com.techpro.project.service;

import com.techpro.project.model.Items;
import com.techpro.project.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ServiceItemsImpl implements ServiceItems{

    @Autowired
    private ItemsRepository itemsRepository;
    @Override
    public Items saveItems(Items items) {
        return itemsRepository.save(items);
    }

    @Override
    public Iterable<Items> findAllItems(){return  itemsRepository.findAll();}

    @Override
    public Items findByItemName(String itemName){return itemsRepository.findByItemName(itemName);}


    @Override
    public Optional <Items> findById(int itemId){return itemsRepository.findById(itemId);}


    @Override
    public boolean existById(int itemId){return itemsRepository.existsById(itemId);}


    @Override
    public void deleteById(int itemId){itemsRepository.deleteById(itemId);}





}
