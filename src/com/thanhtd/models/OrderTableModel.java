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
public class OrderTableModel extends AbstractTableModel {

    public List<Order> orders;

    public OrderTableModel() {
        orders = new LinkedList<>();
    }

    public void setData(List<Order> data) {
        orders = data;
    }

    public List<Order> getData() {
        return orders;
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Order row = orders.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getID();
            case 1:
                return row.getCusName();
            case 2:
                return row.getCusAdd();
            case 3:
                return row.getCusTel();
            case 4:
                return row.getCusEmail();
            default:
                return "Not found!";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Order Id";
            case 1:
                return "Customer Name";
            case 2:
                return "Customer Address";
            case 3:
                return "Customer Tel";
            case 4:
                return "Cusomter Email";
            default:
                return "Not found!";
        }
    }
}
