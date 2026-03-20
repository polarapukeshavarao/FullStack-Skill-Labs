package com.klu.MavenSkill_3;

import com.klu.dao.ProductDao;
import com.klu.entity.ProductEntity;

public class App {

    public static void main(String[] args) {

        ProductDao dao = new ProductDao();

        dao.saveProduct(new ProductEntity("Laptop","Electronics",5,50000));
        dao.saveProduct(new ProductEntity("Mouse","Electronics",20,500));
        dao.saveProduct(new ProductEntity("Keyboard","Electronics",10,1200));
        dao.saveProduct(new ProductEntity("Monitor","Electronics",3,12000));
        dao.saveProduct(new ProductEntity("Phone","Mobile",7,25000));
        dao.saveProduct(new ProductEntity("Tablet","Mobile",4,15000));
        dao.saveProduct(new ProductEntity("Camera","Electronics",2,45000));

        System.out.println("All Products:");
        dao.getAllProducts().forEach(System.out::println);

        System.out.println("\nPrice Ascending:");
        dao.sortPriceAsc().forEach(System.out::println);

        System.out.println("\nPrice Descending:");
        dao.sortPriceDesc().forEach(System.out::println);

        System.out.println("\nQuantity Highest:");
        dao.sortQuantityDesc().forEach(System.out::println);

        System.out.println("\nFirst 3 Products:");
        dao.first3Products().forEach(System.out::println);

        System.out.println("\nNext 3 Products:");
        dao.next3Products().forEach(System.out::println);

        System.out.println("\nTotal Products: " + dao.countProducts());

        System.out.println("Products Quantity >0: " + dao.countAvailable());

        Object[] price = dao.minMaxPrice();
        System.out.println("Min Price: " + price[0]);
        System.out.println("Max Price: " + price[1]);
    }
}