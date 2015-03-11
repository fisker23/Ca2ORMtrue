/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Uffe
 */
public class Facade {
    
    EntityManager em;
    public Facade() {
        em = Persistence.createEntityManagerFactory("Ca2ORMtruePU").createEntityManager();
    }
    
    
    
            
    
    
}
