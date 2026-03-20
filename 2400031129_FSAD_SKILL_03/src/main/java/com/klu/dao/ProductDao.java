package com.klu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.klu.entity.ProductEntity;
import com.klu.util.HibernateUtil;

public class ProductDao {

    // SAVE PRODUCT
    public void saveProduct(ProductEntity p) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(p);

        tx.commit();
        session.close();
    }

    // GET ALL PRODUCTS
    public List<ProductEntity> getAllProducts(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery("FROM ProductEntity", ProductEntity.class);

        return q.list();
    }

    // SORT PRICE ASC
    public List<ProductEntity> sortPriceAsc(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery(
                "FROM ProductEntity ORDER BY price ASC", ProductEntity.class);

        return q.list();
    }

    // SORT PRICE DESC
    public List<ProductEntity> sortPriceDesc(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery(
                "FROM ProductEntity ORDER BY price DESC", ProductEntity.class);

        return q.list();
    }

    // SORT BY QUANTITY
    public List<ProductEntity> sortQuantityDesc(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery(
                "FROM ProductEntity ORDER BY quantity DESC", ProductEntity.class);

        return q.list();
    }

    // PAGINATION FIRST 3
    public List<ProductEntity> first3Products(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery("FROM ProductEntity", ProductEntity.class);

        q.setFirstResult(0);
        q.setMaxResults(3);

        return q.list();
    }

    // PAGINATION NEXT 3
    public List<ProductEntity> next3Products(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery("FROM ProductEntity", ProductEntity.class);

        q.setFirstResult(3);
        q.setMaxResults(3);

        return q.list();
    }

    // COUNT TOTAL PRODUCTS
    public Long countProducts(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Long> q = session.createQuery(
                "SELECT COUNT(*) FROM ProductEntity", Long.class);

        return q.uniqueResult();
    }

    // COUNT WHERE QUANTITY > 0
    public Long countAvailable(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Long> q = session.createQuery(
                "SELECT COUNT(*) FROM ProductEntity WHERE quantity > 0", Long.class);

        return q.uniqueResult();
    }

    // GROUP BY DESCRIPTION
    public List<Object[]> groupByDescription(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Object[]> q = session.createQuery(
                "SELECT description, COUNT(*) FROM ProductEntity GROUP BY description",
                Object[].class);

        return q.list();
    }

    // MIN MAX PRICE
    public Object[] minMaxPrice(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Object[]> q = session.createQuery(
                "SELECT MIN(price), MAX(price) FROM ProductEntity", Object[].class);

        return q.uniqueResult();
    }

    // PRICE RANGE
    public List<ProductEntity> priceRange(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery(
                "FROM ProductEntity WHERE price BETWEEN 5000 AND 50000",
                ProductEntity.class);

        return q.list();
    }

    // LIKE START
    public List<ProductEntity> nameStart(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery(
                "FROM ProductEntity WHERE productName LIKE 'L%'",
                ProductEntity.class);

        return q.list();
    }

    // LIKE END
    public List<ProductEntity> nameEnd(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery(
                "FROM ProductEntity WHERE productName LIKE '%e'",
                ProductEntity.class);

        return q.list();
    }

    // LIKE CONTAIN
    public List<ProductEntity> nameContain(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery(
                "FROM ProductEntity WHERE productName LIKE '%top%'",
                ProductEntity.class);

        return q.list();
    }

    // LENGTH
    public List<ProductEntity> nameLength(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ProductEntity> q = session.createQuery(
                "FROM ProductEntity WHERE LENGTH(productName)=5",
                ProductEntity.class);

        return q.list();
    }
}