/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.models;

import java.util.List;

/**
 *
 * @author Thanh Tran
 */
public class MakeOrder {
    private int OrderID;
    private String CusName;
    private String CusAdd;
    private String CusTel;
    private String CusEmail;    
    private List<Product> listProducts;
    private List<Integer> Quantity;

    public MakeOrder() {
    }    

    public MakeOrder(int OrderID, String CusName, String CusAdd, String CusTel, String CusEmail, List<Product> listProducts, List<Integer> Quantity) {
        this.OrderID = OrderID;
        this.CusName = CusName;
        this.CusAdd = CusAdd;
        this.CusTel = CusTel;
        this.CusEmail = CusEmail;
        this.listProducts = listProducts;
        this.Quantity = Quantity;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public String getCusAdd() {
        return CusAdd;
    }

    public void setCusAdd(String CusAdd) {
        this.CusAdd = CusAdd;
    }

    public String getCusTel() {
        return CusTel;
    }

    public void setCusTel(String CusTel) {
        this.CusTel = CusTel;
    }

    public String getCusEmail() {
        return CusEmail;
    }

    public void setCusEmail(String CusEmail) {
        this.CusEmail = CusEmail;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public List<Integer> getQuantity() {
        return Quantity;
    }

    public void setQuantity(List<Integer> Quantity) {
        this.Quantity = Quantity;
    }
}