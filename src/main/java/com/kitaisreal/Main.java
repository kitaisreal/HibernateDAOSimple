package com.kitaisreal;

import com.kitaisreal.hibernate.Factory;
import com.kitaisreal.hibernate.dao.CustomersEntity;
import com.kitaisreal.hibernate.dao.ItemsEntity;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("OOP LAB 2");
        List<CustomersEntity> customers = (List<CustomersEntity>) Factory.getInstance().getCustomerDAO().getAllCustomers();
        for (CustomersEntity customer: customers){
            System.out.println(customer.getNickname() + "  have Items: ");
            List<ItemsEntity> items = (List<ItemsEntity>) Factory.getInstance().getItemDAO().getItemsByCustomerID(customer);
            for (int i=0;i<items.size();i++){
                System.out.println((i+1) + ". " + items.get(i).getBrandname() + " " + items.get(i).getItemname() );
            }
        }
        List<ItemsEntity> items = (List<ItemsEntity>) Factory.getInstance().getItemDAO().getItemsByBrand("New-Balance");
        System.out.println("New-Balance items");
        for (int i=0;i<items.size();i++){
            System.out.println((i+1) + ". " + items.get(i).getBrandname() + " " + items.get(i).getItemname() );
        }

    }
}
