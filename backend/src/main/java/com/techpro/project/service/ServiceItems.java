package com.techpro.project.service;

import com.techpro.project.model.Items;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface ServiceItems {
    Items saveItems(Items items);
    Iterable<Items> findAllItems();

    Items findByItemName(String itemName);
    Optional<Items> findById(int itemId);

    boolean existById(int itemId);

    void deleteById(int itemId);

}
