/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.controllers;

import com.thanhtd.models.OrderDetail;
import java.util.List;

/**
 *
 * @author Thanh Tran
 */
public class OrderDetailController {

    public static void AddOrderDetail(List<OrderDetail> list, OrderDetail item) {
        list.add(item);
    }
}
