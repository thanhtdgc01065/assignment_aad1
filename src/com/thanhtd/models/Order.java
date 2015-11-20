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
public class Order implements Comparable<Order> {

    private int ID;
    private String CusName;
    private String CusAdd;
    private String CusTel;
    private String CusEmail;

    public Order(int ID, String CusName, String CusAdd, String CusTel, String CusEmail) {
        this.ID = ID;
        this.CusName = CusName;
        this.CusAdd = CusAdd;
        this.CusTel = CusTel;
        this.CusEmail = CusEmail;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "Order{" + "ID: " + ID + ", CusName: " + CusName + ", CusAdd: " + CusAdd + ", CusTel: " + CusTel + ", CusEmail: " + CusEmail + '}';
    }

    @Override
    public int compareTo(Order o) {
        if (this.getID() == o.getID()) {
            return 0;
        }
        if (this.getID() > o.getID()) {
            return 1;
        }
        return -1;
    }
}
