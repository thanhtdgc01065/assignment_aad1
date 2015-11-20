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
public class OrderDetailTableModel extends AbstractTableModel {

    List<OrderDetail> orderDetails = new LinkedList<>();

    public void setData(List<OrderDetail> i) {
        orderDetails = i;
    }

    public List<OrderDetail> getData() {
        return orderDetails;
    }

    @Override
    public int getRowCount() {
        return orderDetails.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderDetail row = orderDetails.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getProductName();
            case 1:
                return "$" + row.getProductPrice();
            case 2:
                return row.getQuantity();
            case 3:
                return "$" + row.getTotal();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Product Name";
            case 1:
                return "Product Price";
            case 2:
                return "Quantity";
            case 3:
                return "Total";
            default:
                return "";
        }
    }

}
