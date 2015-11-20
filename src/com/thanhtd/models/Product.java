/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.models;

/**
 *
 * @author trduy
 */
public class Product implements Comparable<Product> {

    private int ProductID;
    private String Name;
    private double Price;

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ID) {
        this.ProductID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    @Override
    public String toString() {
        return "Product{" + "ID: " + ProductID + ", Name: " + Name + ", Price: " + Price + '}';
    }

    public Product(int ID, String Name, double Price) {
        this.ProductID = ID;
        this.Name = Name;
        this.Price = Price;
    }

    @Override
    public int compareTo(Product o) {
        if (this.getProductID()== o.getProductID()) {
            return 0;
        }
        if (this.getProductID()> o.getProductID()) {
            return 1;
        }
        return -1;
    }
}
