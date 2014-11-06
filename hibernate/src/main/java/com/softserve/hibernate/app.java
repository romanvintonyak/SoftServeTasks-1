package com.softserve.hibernate;

import com.softserve.entities.Activity;
import com.softserve.entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Created by us3622 on 06.11.14.
 */
public class app {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Category cat = new Category();
        cat.setCategory_name("sdfhgssffsfhg");
        cat.setCategory_desk("lsjdf lsdsssjfuyvhsdfv ");
        Activity act = new Activity();
        act.setActivity_desc("sdgbdsgfb");
        act.setCategory_id(cat);
        act.setOperation_type(1);
        sessionFactory.openSession();
        Session session = sessionFactory.openSession();
        session.save(cat);
        session.save(act);
        Transaction tr = session.beginTransaction();
        tr.commit();
        session.close();
    }
}
