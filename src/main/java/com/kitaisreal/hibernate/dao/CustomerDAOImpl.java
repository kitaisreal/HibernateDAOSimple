package com.kitaisreal.hibernate.dao;


import com.kitaisreal.hibernate.utils.HibernateSessionFactory;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public void addCustomer(CustomersEntity customer) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    public void updateCustomer(CustomersEntity customer) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public CustomersEntity getCustomerByID(int customer_id) throws SQLException {
        Session session = null;
        CustomersEntity customer = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            customer = (CustomersEntity)session.load(CustomersEntity.class, customer_id);
            Hibernate.initialize(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customer;
    }


    public Collection getAllCustomers() throws SQLException {
        Session session = null;
        List customers = new ArrayList<CustomersEntity>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            customers = session.createCriteria(CustomersEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customers;
    }



    public void deleteCustomer(CustomersEntity customer) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
