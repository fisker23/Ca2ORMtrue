/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Address;
import entity.CityInfo;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Uffe
 */
public class Facade {

    static EntityManagerFactory emf;

    public Facade(String str) {
        emf = Persistence.createEntityManagerFactory(str);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    

    public Person createPerson(String fn, String ln, String mail, List<Phone> phone, String street, String ai, String zip) {
        EntityManager em = getEntityManager();
        Person p = null;
        try {
            p = new Person(fn, ln, mail);
            System.out.println("--------------------------------------------- inside facade");
            
            Address a = new Address(street, ai);
            CityInfo ci = getCityInfo(zip);
            a.setCityInfo(ci);
            p.setAddress(a);
            
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            
            
        }catch(Exception e){
            System.out.println("knep mig");
            System.err.println("ERROR: " + e.getMessage());
        }finally {
            if (em != null) {
                em.close();
            }
        }
        return p;

    }
   
    public CityInfo getCityInfo(String zip){
        EntityManager em = getEntityManager();
        try {
            
            return em.find(CityInfo.class, zip);
            
        } finally {
            if (em != null) {

                em.close();

            }
        }
    }
    
    public List<Person> getAllPersons(){
        EntityManager em = getEntityManager();
        List<Person> pList = em.createQuery("Select p From Person p").getResultList();
        return pList;
    }
    
    public Person getOnePerson(int id){
        EntityManager em = getEntityManager();
        return em.find(Person.class, id);
        
    }

}
