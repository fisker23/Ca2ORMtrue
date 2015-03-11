/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Hobby;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Uffe
 */
public class main123 {
    public static void main(String[] args) {
//        Persistence.generateSchema("Ca2ORMtruePU", null);
       EntityManager em = Persistence.createEntityManagerFactory("Ca2ORMtruePU").createEntityManager();
       Hobby hobby = new Hobby(1, "hej", "Sto");
//        
        em.getTransaction().begin();
        em.persist(hobby);
        em.getTransaction().commit();
    }
}
