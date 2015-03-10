/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Andreas Fisker
 */
@Entity
public class Company  extends InfoEntity {
    private String name;
    private String description;
    private int cvr;
    private int numEmployees;
    private int marketValue;

    public Company(String name, String description, int cvr, int numEmployees, int marketValue) {
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }

    public Company() {
    }
    
    
}
