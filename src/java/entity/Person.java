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
 * @author Andreas Fisker
 */
@Entity
public class Person extends InfoEntity  {
    
    private String firstName;
    private String lastName;
    @ManyToMany
    public List<Hobby> hobbyList = new ArrayList();
   

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }
    
    
}
