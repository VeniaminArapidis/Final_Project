package com.techpro.project.exceptions;

public class PersonDoesntExistException extends RuntimeException {

    public PersonDoesntExistException(String email){super("Person with that email: "+email+" doesn't exist!");}
}
