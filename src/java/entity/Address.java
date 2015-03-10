/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Andreas Fisker
 */
@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private String AdditionalInfo;
    @OneToMany
    public List<InfoEntity> IEList = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address(int id, String street, String AdditionalInfo) {
        this.id = id;
        this.street = street;
        this.AdditionalInfo = AdditionalInfo;
    }

    public Address() {
    }

   
    
}
