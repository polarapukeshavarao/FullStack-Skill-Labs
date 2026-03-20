package com.klu.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductUtil {

    private static SessionFactory sf;

    static {
        try {
            sf = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed.");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }
}
