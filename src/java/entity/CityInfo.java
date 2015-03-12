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
public class CityInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private String zip;
    private String city;
    //Denne kommentar er rimelig vild
    
    @OneToMany(mappedBy = "cityInfo")
    public List<Address> addressList = new ArrayList();

    public CityInfo(String zipCode, String city) {
        this.zip = zipCode;
        this.city = city;
    }

    
    public CityInfo() {
    }
    
    
    public String getZipCode() {
        return zip;
    }

    public void setZipCode(String zipCode) {
        this.zip = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

   
}
