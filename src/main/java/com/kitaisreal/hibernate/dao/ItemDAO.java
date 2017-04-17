package com.kitaisreal.hibernate.dao;

import java.util.Collection;
import java.sql.SQLException;

public interface ItemDAO {
    public void addItem(ItemsEntity item) throws SQLException;
    public void updateItem(ItemsEntity item) throws SQLException;
    public ItemsEntity getItemById(int item_id) throws SQLException;
    public Collection getAllItems() throws SQLException;
    public void deleteItem(ItemsEntity item) throws SQLException;
    public Collection getItemsByBrand(String s) throws SQLException;
    public Collection getItemsByCustomerID(CustomersEntity customer) throws SQLException;
}
