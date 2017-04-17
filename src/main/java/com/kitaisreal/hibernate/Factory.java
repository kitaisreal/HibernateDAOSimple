package com.kitaisreal.hibernate;

import com.kitaisreal.hibernate.dao.CustomerDAO;
import com.kitaisreal.hibernate.dao.CustomerDAOImpl;
import com.kitaisreal.hibernate.dao.ItemDAO;
import com.kitaisreal.hibernate.dao.ItemDAOImpl;

public class Factory {

    private static CustomerDAO customerDAO = null;
    private static ItemDAO ItemDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public ItemDAO getItemDAO(){
        if (ItemDAO == null){
            ItemDAO = new ItemDAOImpl();
        }
        return ItemDAO;
    }

    public CustomerDAO getCustomerDAO(){
        if (customerDAO == null){
            customerDAO = new CustomerDAOImpl();
        }
        return customerDAO;
    }
}