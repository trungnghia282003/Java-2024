/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author ASUS
 */
public class JpaUtils {
    public static EntityManager getEntityManager() {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAWebApplicationPU");
            return factory.createEntityManager();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception to propagate it further if needed
        }
    }
}
