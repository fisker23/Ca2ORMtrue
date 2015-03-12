/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import control.Facade;
import entity.Person;

/**
 *
 * @author Uffe
 */
public class main123 {
    public static void main(String[] args) {
//        Persistence.generateSchema("Ca2ORMtruePU", null);
       Facade fc = new Facade("Ca2ORMtruePU");
       Person p = fc.createPerson("Hej", "123", "laks", null, "er ", "laka", "2700");
        System.out.println(p.getId());
    }
}
