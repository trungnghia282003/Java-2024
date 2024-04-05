/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.utils.JpaUtils;
import entities.Players;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author ASUS
 */
public class PlayerDAO {

    public List<Players> selectAll() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        try {
            // Create and execute the JPQL query
            TypedQuery<Players> query = entityManager.createQuery("SELECT p FROM Players p", Players.class);
            return query.getResultList(); // Return the list of players
        } finally {
            entityManager.close(); // Close the EntityManager to release resources
        }
    }

    public void insert(Players player) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); // Start a new transaction
            entityManager.persist(player); // Persist the player entity
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Rollback the transaction if an exception occurs
            }
            e.printStackTrace();
        } finally {
            entityManager.close(); // Close the EntityManager to release resources
        }
    }

    public Players selectById(int id) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        try {
            return entityManager.find(Players.class, id); // Find player by ID
        } finally {
            entityManager.close(); // Close the EntityManager to release resources
        }
    }

    public void update(Players player) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); // Start a new transaction
            entityManager.merge(player); // Update the player entity
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Rollback the transaction if an exception occurs
            }
            e.printStackTrace();
        } finally {
            entityManager.close(); // Close the EntityManager to release resources
        }
    }

    public void delete(int id) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); // Start a new transaction
            Players player = entityManager.find(Players.class, id); // Find player by ID
            if (player != null) {
                entityManager.remove(player); // Delete the player entity
            }
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Rollback the transaction if an exception occurs
            }
            e.printStackTrace();
        } finally {
            entityManager.close(); // Close the EntityManager to release resources
        }
    }
}
