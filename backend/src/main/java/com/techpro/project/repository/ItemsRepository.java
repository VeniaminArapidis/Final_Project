package com.techpro.project.repository;

import com.techpro.project.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {
    Items findByItemName(String itemName);
}
