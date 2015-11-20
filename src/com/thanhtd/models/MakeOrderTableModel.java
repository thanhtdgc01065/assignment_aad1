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
 * @author Thanh Tran
 */
public class MakeOrderTableModel extends AbstractTableModel {

    List<Product> productList = new LinkedList<>();
    List<Integer> quantityList = new LinkedList<>();

    public void setData(List<Product> item1, List<Integer> item2) {
        productList = item1;
        quantityList = item2;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Product Name";
            case 1:
                return "Price";
            case 2:
                return "Quantity";
            case 3:
                return "Total";
            default:
                return "";
        }
    }

    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product temp = productList.get(rowIndex);
        int idx = quantityList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temp.getName();
            case 1:
                return "$" + temp.getPrice();
            case 2:
                return idx;
            case 3:
                return "$" + (temp.getPrice() * idx);
            default:
                return "";
        }
    }

}
