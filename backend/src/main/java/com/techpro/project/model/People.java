package com.techpro.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//people ENTITY WITH SETTERS AND GETTERS
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "PersonID")
    private int personID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName" )
    private String lastName;

    @Column(name = "Email" )
    private String email;

    public People(String name) {
        this.firstName = name;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
