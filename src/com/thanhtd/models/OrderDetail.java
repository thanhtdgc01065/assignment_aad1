/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.models;

/**
 *
 * @author Thanh Tran
 */
public class OrderDetail {

    private String ProductName;
    private double ProductPrice;
    private int Quantity;
    private double Total;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public OrderDetail(String ProductName, double ProductPrice, int Quantity, double Total) {
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.Quantity = Quantity;
        this.Total = Total;
    }
}
