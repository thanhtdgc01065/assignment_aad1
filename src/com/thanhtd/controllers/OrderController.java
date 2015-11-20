/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.controllers;

import com.thanhtd.models.Order;
import java.util.List;

/**
 *
 * @author Thanh Tran
 */
public class OrderController {

    public static void AddOrder(List<Order> orders, Order item) {
        orders.add(item);
    }

    public static void RemoveOrder(List<Order> orders, int index) {
        orders.remove(index);
    }

    public static void UpdateOrder(List<Order> orders, int id, Order item) {
        orders.get(id).setCusName(item.getCusName());
        orders.get(id).setCusAdd(item.getCusAdd());
        orders.get(id).setCusTel(item.getCusTel());
        orders.get(id).setCusEmail(item.getCusEmail());
    }

    public static int SearchOrder(List<Order> orders, int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }
}
