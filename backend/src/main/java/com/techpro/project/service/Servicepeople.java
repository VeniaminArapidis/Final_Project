package com.techpro.project.service;

import org.springframework.stereotype.Service;

import com.techpro.project.model.People;

import java.util.Optional;

@Service
public interface Servicepeople {

    // Save operation
    
    People savePeople(People people);

    // Read operation
   People readPeople(int id);

   People findByEmail(String email);

   Iterable<People> findAllPeople();

   Optional<People> findById(int peopleId);


   boolean existById (int peopleId);

   void deleteById(int peopleId);
    
}
