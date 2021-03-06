package com.kitaisreal.hibernate.dao;


import com.kitaisreal.hibernate.utils.HibernateSessionFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    public void addItem(ItemsEntity item) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    public void updateItem(ItemsEntity item) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public ItemsEntity getItemById(int item_id) throws SQLException {
        Session session = null;
        ItemsEntity item = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            item = (ItemsEntity)session.load(ItemsEntity.class,item_id );
            Hibernate.initialize(item);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return item;
    }

    public Collection getAllItems() throws SQLException {
        Session session = null;
        List items = new ArrayList<ItemsEntity>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            items = session.createCriteria(ItemsEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return items;
    }

    public void deleteItem(ItemsEntity item) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getItemsByBrand(String s) throws SQLException {
        Session session = null;
        List items = new ArrayList<ItemsEntity>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            items = session.createCriteria(CustomersEntity.class).list();
            Query query = session.createQuery("from ItemsEntity where brandname = :brand ");
            query.setParameter("brand", s);
            items = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return items;
    }

    public Collection getItemsByCustomerID(CustomersEntity customer) throws SQLException {
        Session session = null;
        List items = new ArrayList<ItemsEntity>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            items = session.createCriteria(CustomersEntity.class).list();
            Query query = session.createQuery("from ItemsEntity where customerid = :customerID ");
            query.setParameter("customerID", customer.getId());
            items = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return items;
    }
}
