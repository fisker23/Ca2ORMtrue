/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Uffe
 */
@Entity
public class Person extends InfoEntity{
     private String firstName;
    private String lastName;
//    @ManyToMany
//    public List<Hobby> hobbyList = new ArrayList();

    public Person(String firstName, String lastName, String email) {
        super(email);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public List<Hobby> getHobbyList() {
//        return hobbyList;
//    }
//
//    public void setHobbyList(List<Hobby> hobbyList) {
//        this.hobbyList = hobbyList;
//    }

    public Person() {
    }
    

}
