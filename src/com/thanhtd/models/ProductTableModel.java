/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.models;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author trduy
 */
public class ProductTableModel extends AbstractTableModel {

    public List<Product> products = new LinkedList<>();

    public void setData(List<Product> data) {
        this.products = data;
    }

    public List<Product> getData() {
        return this.products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product row = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getProductID();
            case 1:
                return row.getName();
            case 2:
                return "$" + row.getPrice();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Name";
            case 2:
                return "Price";
            default:
                return "";
        }
    }

}
