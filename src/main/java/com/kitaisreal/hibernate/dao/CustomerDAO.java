package com.kitaisreal.hibernate.dao;

import java.util.Collection;
import java.sql.SQLException;


public interface CustomerDAO {
    public void addCustomer(CustomersEntity customer) throws SQLException;
    public void updateCustomer(CustomersEntity customer) throws SQLException;
    public CustomersEntity getCustomerByID(int customer_id) throws SQLException;
    public Collection getAllCustomers() throws SQLException;
    public void deleteCustomer(CustomersEntity customer) throws SQLException;

}
