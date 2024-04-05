/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entites.Users;
import com.utils.JpaUtils;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author ASUS
 */
public class UserDAO {

    public boolean checkDuplicates(String username) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM Users u WHERE u.username = :username", Long.class);
            query.setParameter("username", username);
            Long count = query.getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }

    public boolean authenticate(String username, String password) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.username = :username AND u.password = :password", Users.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            List<Users> users = query.getResultList();
            return !users.isEmpty();
        } finally {
            em.close();
        }
    }

    public int authorize(String username, String password) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            TypedQuery<Integer> query = em.createQuery("SELECT u.roleId FROM Users u WHERE u.username = :username AND u.password = :password", Integer.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            Integer roleId = query.getSingleResult();
            return roleId != null ? roleId : 0; // Trả về 0 nếu không tìm thấy roleId
        } finally {
            em.close();
        }
    }

    public List<Users> getAll() {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u", Users.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Users getUserById(int userId) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            Users user = em.find(Users.class, userId);
            return user;
        } finally {
            em.close();
        }
    }

    public int Insert(Users users) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            if (!trans.isActive()) {
                trans.begin();
            }
            em.persist(users);
            trans.commit();
            return 1; // Thêm thành công
        } catch (Exception ex) {
            if (trans.isActive()) {
                trans.rollback();
            }
            ex.printStackTrace(); // Log ngoại lệ
            return -1; // Lỗi khi thêm mới
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public int Update(Users updatedUser) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Users existingUser = em.find(Users.class, updatedUser.getId());
            if (existingUser != null) {
                // Update the fields of existingUser with the fields of updatedUser
                existingUser.setUsername(updatedUser.getUsername());
                existingUser.setPassword(updatedUser.getPassword());
                existingUser.setRoleId(2);
                em.merge(existingUser);
                trans.commit();
                return 1; // Update successful
            } else {
                return 0; // User with provided ID not found
            }
        } catch (Exception ex) {
            trans.rollback();
            return -1; // Error occurred during update
        } finally {
            em.close();
        }
    }

    public int Delete(int userId) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Users user = em.find(Users.class, userId);
            em.remove(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            return -1;
        } finally {
            em.close();
        }
        return 1;
    }
}
