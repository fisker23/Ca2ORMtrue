/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import control.Facade;
import entity.Person;
import java.util.List;

/**
 *
 * @author Uffe
 */
public class main123 {
    public static void main(String[] args) {
//        Persistence.generateSchema("Ca2ORMtruePU", null);
       Facade fc = new Facade("Ca2ORMtruePU");
       Person p1 = fc.createPerson("Hej", "12qweas3", "asdasdffflaks", null, "esssr ", "eeelaka", "2700");
       Person p2 = fc.createPerson("Hj", "123fdgg", "lakdss", null, "er aa", "lakafd", "2700");
       Person p3 = fc.createPerson("ej", "123fd", "lakwqes", null, "er asd", "lakadd", "2700");
       Person p4 = fc.createPerson("sHej", "1231sad23", "glaks", null, "errdf ", "laffka", "2700");
       Person p5 = fc.createPerson("Hffdej", "3123", "laksasd", null, "e22r ", "lakaeee", "2700");
       
        System.out.println(p1.getId());
        
        List<Person> testList = fc.getAllPersons();
        
        for (Person p : testList) {
            System.out.println(p.getFirstName());
        }
    }
}
