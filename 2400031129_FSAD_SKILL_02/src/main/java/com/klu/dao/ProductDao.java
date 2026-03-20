package com.klu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.entity.products;
import com.klu.util.ProductUtil;

public class ProductDao {

    // Insert
    public void saveProduct(products p) {
        Transaction tx = null;
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Select all
    public List<products> getAllProducts() {
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            return session.createQuery("from products", products.class).list();
        }
    }

    // Select by ID
    public products getId(int pid) {
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            return session.get(products.class, pid);
        }
    }

    // Update
    public void updateProduct(products p) {
        Transaction tx = null;
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteProduct(int pid) {
        Transaction tx = null;
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            products p = session.get(products.class, pid);
            if (p != null) {
                session.delete(p);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
