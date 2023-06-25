package com.techpro.project.controllers;

import com.techpro.project.exceptions.PeopleNotFoundException;
import com.techpro.project.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.techpro.project.model.People;
import com.techpro.project.service.Servicepeople;

import java.util.HashMap;


//Restfull controller for People Table
@RestController
@CrossOrigin("http://localhost:3000")
public class PeopleController {


    @Autowired private Servicepeople servicepeople;
    @Autowired private PeopleRepository peopleRepository;

    //Post new Customer to the People Table
    @PostMapping(value = "/people", produces = "application/json")
    People newPerson(@RequestBody HashMap<String, String> requestBody) throws Exception {
        People person = servicepeople.findByEmail(requestBody.get("email").toLowerCase());
        if(person != null) {
            throw new PeopleNotFoundException(person.getEmail());
        }
        People prs = new People();
        prs.setFirstName(requestBody.get("firstName"));
        prs.setLastName(requestBody.get("lastName"));
        prs.setEmail(requestBody.get("email").toLowerCase());

        return servicepeople.savePeople(prs);
    }

    // Get all customer from People Table
    @GetMapping(value = "/peopleAll", produces = "application/json")
    Iterable<People> findAllPeople() {
        return  servicepeople.findAllPeople();
    }

    //Get customer by ID
    @GetMapping(value = "/people/{personID}", produces = "application/json")
    People getPeopleById(@PathVariable Integer personID){
        return peopleRepository.findById(personID)
                .orElseThrow(()->new PeopleNotFoundException(personID));
    }


    //Update customer info
    @PutMapping(value = "people/{peopleId}", produces = "application/json")
    People updatePeople(@RequestBody People newPeople, @PathVariable Integer peopleId){
        return servicepeople.findById(peopleId)
                .map(person -> {
                    person.setFirstName(newPeople.getFirstName());
                    person.setLastName(newPeople.getLastName());
                    person.setEmail(newPeople.getEmail());
                    return servicepeople.savePeople(person);
                }) .orElseThrow(()-> new PeopleNotFoundException(peopleId));
    }

    //Delete customer by ID from People Table
    @DeleteMapping(value = "/peopleDel/{peopleId}", produces = "application/json")
    String deletePeople(@PathVariable Integer peopleId){
        if(!servicepeople.existById(peopleId)){
            throw new PeopleNotFoundException(peopleId);
        }
        servicepeople.deleteById(peopleId);
        return "Person with id: "+ peopleId + " has been deleted!";
    }


}
