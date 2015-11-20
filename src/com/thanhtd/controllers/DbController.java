/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.controllers;

import com.thanhtd.models.MakeOrder;
import com.thanhtd.models.Order;
import com.thanhtd.models.OrderDetail;
import com.thanhtd.models.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trduy
 */
public class DbController {

    public static Connection conn = null;

    public static void ConnectToDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=AssignmentAAD1";

            try {
                conn = DriverManager.getConnection(url, "sa", "12345678");
                System.out.println("Connect to DB successfully...");
            } catch (SQLException ex) {
                System.out.println("Error to connect to DB.");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ReadProductFromDB(List<Product> list) {
        try {
            //String sql = "SELECT * FROM [Product] WHERE IsDeleted=0";
            String sql = "SELECT * FROM [Product]";
            Statement statement;
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int dbProductId = result.getInt(1);
                String dbProductName = result.getString(2);
                double dbProductPrice = Double.parseDouble(result.getString(3));
                list.add(new Product(dbProductId, dbProductName, dbProductPrice));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ReadOrderFromDB(List<Order> list) {
        try {
            String sql = "SELECT * FROM [Order]";
            Statement statement;
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int dbOrderId = result.getInt(1);
                String dbCusName = result.getString(2);
                String dbCusAdd = result.getString(3);
                String dbCusTel = result.getString(4);
                String dbCusEmail = result.getString(5);

                list.add(new Order(dbOrderId, dbCusName, dbCusAdd, dbCusTel, dbCusEmail));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ReadOrderDetailFromDB(List<OrderDetail> list, int id) {
        try {
            String sql = "SELECT [Product].ProductName,[Product].ProductPrice,[OrderDetail].Quantity,[Product].ProductPrice*[OrderDetail].Quantity AS Total\n"
                    + "FROM [Product] INNER JOIN [OrderDetail] ON [Product].ProductID=[OrderDetail].ProductID\n"
                    + "INNER JOIN [Order] ON [OrderDetail].OrderID=[Order].OrderID\n"
                    + "WHERE [OrderDetail].OrderID=" + id
                    + "ORDER BY [Product].ProductName";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String dbProductName = result.getString(1);
                Double dbProductPrice = result.getDouble(2);
                int dbQuantity = result.getInt(3);
                Double dbTotal = result.getDouble(4);
                list.add(new OrderDetail(dbProductName, dbProductPrice, dbQuantity, dbTotal));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void InsertNewProductToDB(Product temp) {
        try {
            String sql = "INSERT INTO [Product](ProductID,ProductName,ProductPrice) VALUES (?,?,?)";
            PreparedStatement statement;
            statement = conn.prepareStatement(sql);
            statement.setInt(1, temp.getProductID());
            statement.setNString(2, temp.getName());
            statement.setDouble(3, temp.getPrice());
            int rowEffected = statement.executeUpdate();

            if (rowEffected > 0) {
                System.out.println(rowEffected + " product has been add to Db.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void InsertNewOrderToDB(Order temp) {
        try {
            String sql = "INSERT INTO [Order](OrderID,CusName,CusAdd,CusTel,CusEmail) VALUES (?,?,?,?,?)";
            PreparedStatement statement;
            statement = conn.prepareStatement(sql);

            statement.setInt(1, temp.getID());
            statement.setNString(2, temp.getCusName());
            statement.setNString(3, temp.getCusAdd());
            statement.setString(4, temp.getCusTel());
            statement.setString(5, temp.getCusEmail());

            int rowEffected = statement.executeUpdate();
            if (rowEffected > 0) {
                System.out.println(rowEffected + " order has been add to Db.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void UpdateProductToDB(Product item) {
        try {
            String sql = "UPDATE [Product] SET ProductName=?,ProductPrice=? WHERE ProductID=" + item.getProductID();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            int row = statement.executeUpdate();
            if (row == 1) {
                System.out.println("Update ProductID " + item.getProductID() + " successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("Failed to update ProductID " + item.getProductID() + " to DB.");
        }
    }

    public static void DeleteProductFromDB(int id) {
        try {
            //String sql = "DELETE FROM [Product] WHERE ProductID=" + id;
            String sql = "UPDATE [Product] SET IsDeleted=1 WHERE ProductID=" + id;
            PreparedStatement statement = conn.prepareStatement(sql);
            int row = statement.executeUpdate();
            if (row == 1) {
                System.out.println("Update ProductID " + id + " successfully deleted!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void InsertNewFullOrderToDB(MakeOrder item) {
        try {
            String sql1 = "INSERT INTO [Order](OrderID,CusName,CusAdd,CusTel,CusEmail) VALUES\n"
                    + "(?,?,?,?,?)";
            String sql2 = "INSERT INTO [OrderDetail](OrderID,ProductID,Quantity) VALUES\n"
                    + "(?,?,?)";

            PreparedStatement statement = conn.prepareStatement(sql1);
            statement.setInt(1, item.getOrderID());
            statement.setNString(2, item.getCusName());
            statement.setNString(3, item.getCusAdd());
            statement.setString(4, item.getCusTel());
            statement.setString(5, item.getCusEmail());
            if (statement.executeUpdate() == 1) {
                System.out.println("Insert table Order successfully!");
            }

            statement = conn.prepareStatement(sql2);
            for (int i = 0; i < item.getListProducts().size(); i++) {
                statement.setInt(1, item.getOrderID());
                statement.setInt(2, item.getListProducts().get(i).getProductID());
                statement.setInt(3, item.getQuantity().get(i));
                if (statement.executeUpdate() == 1) {
                    System.out.println("Insert table OrderDetail " + (i + 1) + "/" + item.getListProducts().size() + " successfully!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void UpdateOrderToDB(Order item) {
        try {
            String sql = "UPDATE [Order] SET CusName=?,CusAdd=?,CusTel=?,CusEmail=? WHERE OrderID=" + item.getID();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setNString(1, item.getCusName());
            statement.setNString(2, item.getCusAdd());
            statement.setString(3, item.getCusTel());
            statement.setString(4, item.getCusEmail());
            int row = statement.executeUpdate();
            if (row == 1) {
                System.out.println("Update Order successfully.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
