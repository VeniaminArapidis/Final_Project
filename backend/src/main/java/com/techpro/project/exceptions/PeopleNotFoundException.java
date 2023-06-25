package com.techpro.project.exceptions;


public class PeopleNotFoundException extends RuntimeException{

    public PeopleNotFoundException(String name){
        super("Person with that email: "+name+" already exist!!!");
    }


    public PeopleNotFoundException(Integer peopleId){super("Person with id: "+peopleId+" doesn't exist!!!");}
}
