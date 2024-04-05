/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entites.TBLBook;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import utils.JpaUtils;

/**
 *
 * @author ASUS
 */
public class BookDAO {

    public static List<TBLBook> selectAll() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        Query query = entityManager.createQuery("SELECT b FROM TBLBook b");
        List<TBLBook> books = query.getResultList();
        entityManager.close();
        return books;
    }

    public static TBLBook selectById(int bookId) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        TBLBook book = entityManager.find(TBLBook.class, bookId);
        entityManager.close();
        return book;
    }

    public static void insert(TBLBook book) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
        entityManager.close();
    }

    public static void update(TBLBook book) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(book);
        transaction.commit();
        entityManager.close();
    }

    public static void delete(int bookId) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TBLBook book = entityManager.find(TBLBook.class, bookId);
        entityManager.remove(book);
        transaction.commit();
        entityManager.close();
    }
}
