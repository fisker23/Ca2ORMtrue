/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Andreas Fisker
 */
@Entity
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int number;
    private String description;

    public int getId() {
        return id;
    }

    public Phone(int id, int number, String description) {
        this.id = id;
        this.number = number;
        this.description = description;
    }

    public Phone() {
    }

    
    
    public void setId(int id) {
        this.id = id;
    }

   
}
