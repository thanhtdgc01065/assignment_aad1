/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.controllers;

import com.thanhtd.models.Product;
import java.util.List;

/**
 *
 * @author trduy
 */
public class ProductController {

    public static void AddProduct(List<Product> products, Product item) {
        products.add(item);
    }

    public static void RemoveProduct(List<Product> products, int index) {
        products.remove(index);
    }

    public static void UpdateProduct(List<Product> products, int index, Product product) {
        products.get(index).setProductID(product.getProductID());
        products.get(index).setName(product.getName());
        products.get(index).setPrice(product.getPrice());
    }

    public static int SearchProduct(List<Product> products, int id) {
        if (products.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProductID()== id) {
                    return i;
                }
            }
            return -1;
        }
    }
}
