package com.techpro.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techpro.project.model.People;
import com.techpro.project.repository.PeopleRepository;

import java.util.Optional;

@Component
public class ServicepeopleImpl implements Servicepeople {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public People savePeople(People people) {return peopleRepository.save(people);}

    @Override
    public People readPeople(int id) {
        return null;

    }

    @Override
    public People findByEmail(String email){return peopleRepository.findByEmail(email);}


    @Override
    public Iterable<People> findAllPeople(){return peopleRepository.findAll();}


    @Override
    public Optional <People> findById(int peopleId){return peopleRepository.findById(peopleId);}


    @Override
    public boolean existById(int peopleId) {return peopleRepository.existsById(peopleId);}


    @Override
    public void deleteById(int peopleId){
        peopleRepository.deleteById(peopleId);
    }
}
