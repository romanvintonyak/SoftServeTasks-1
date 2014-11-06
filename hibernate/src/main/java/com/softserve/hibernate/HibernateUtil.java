package com.softserve.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by us3622 on 06.11.14.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
       sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
