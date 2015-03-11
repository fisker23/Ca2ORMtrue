/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;

/**
 *
 * @author Uffe
 */
@Entity
public class Company extends InfoEntity{
    private String companyName;
    private String description;
    private int cvr;
    private int numEmployees;
    private int marketValue;

   
    public Company() {
    }

    public Company(String companyName, String description, int cvr, int numEmployees, int marketValue, String email) {
        super(email);
        this.companyName = companyName;
        this.description = description;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }
    
    
}
