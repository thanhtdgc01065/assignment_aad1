/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.app;

import com.thanhtd.views.EditProductFrame;
import com.thanhtd.controllers.DbController;
import com.thanhtd.models.Order;
import com.thanhtd.models.OrderDetail;
import com.thanhtd.models.OrderTableModel;
import com.thanhtd.models.Product;
import com.thanhtd.models.ProductTableModel;
import com.thanhtd.views.EditOrderFrame;
import com.thanhtd.views.MakeOrderFrame;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author trduy
 */
public class App extends javax.swing.JFrame {

    /**
     * Creates new form App
     */
    public static List<Product> dataProduct = new LinkedList<>();
    List<Product> filteredProductList = new LinkedList<>();
    public static List<Order> dataOrder = new LinkedList<>();
    public static List<OrderDetail> dataOrderDetail = new LinkedList<>();

    public static int selectedProduct;

    public static String emailUsername = "";
    public static String emailPassword = "";

    public static ProductTableModel ptm = new ProductTableModel();
    public static OrderTableModel otm = new OrderTableModel();

    public App() throws ClassNotFoundException {
        initComponents();

        //Set the windows to center of screen
        setLocationRelativeTo(null);

        //Set data to Product table
        DbController.ConnectToDB();
        DbController.ReadProductFromDB(dataProduct);
        DbController.ReadOrderFromDB(dataOrder);

        ptm.setData(dataProduct);
        dataProductTable.setAutoCreateRowSorter(true);
        dataProductTable.setModel(ptm);

        nextProductId.setText("" + (dataProduct.get(dataProduct.size() - 1).getProductID() + 1));

        otm.setData(dataOrder);
        dataOrderTable.setAutoCreateRowSorter(true);
        dataOrderTable.setModel(otm);

        setupApp();
        setTeamInfo();
    }

    private void setupApp() {

        TableColumn ProductIdCol = dataProductTable.getColumnModel().getColumn(0);
        ProductIdCol.setMaxWidth(50);
        ProductIdCol.setPreferredWidth(30);

        TableColumn ProductPriceCol = dataProductTable.getColumnModel().getColumn(2);
        ProductPriceCol.setMaxWidth(150);
        ProductPriceCol.setPreferredWidth(100);

        TableColumn OrderIdCol = dataOrderTable.getColumnModel().getColumn(0);
        OrderIdCol.setMaxWidth(70);
        OrderIdCol.setPreferredWidth(70);

        TableColumn OrderTelCol = dataOrderTable.getColumnModel().getColumn(3);
        OrderTelCol.setMaxWidth(100);
        OrderTelCol.setPreferredWidth(100);
    }

    private void setTeamInfo() {
        String information = "Assignment Group 1"
                + "\n\nMembers of group:" + "\n1. Tran Duy Thanh" + "\n2. Tran Ngoc Son"
                + "\n3. Nguyen Van Nam" + "\n4. Ngo Tung Lam" + "\n\nEnjoy our App :)";
        aboutInfo.setText(information);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        tabProducts = new javax.swing.JPanel();
        addProductName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nextProductId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addProductBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataProductTable = new javax.swing.JTable();
        addProductCheckName = new javax.swing.JLabel();
        addProductCheckPrice = new javax.swing.JLabel();
        searchProductField = new javax.swing.JTextField();
        addProductPrice = new javax.swing.JTextField();
        tabOrders = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataOrderTable = new javax.swing.JTable();
        addOrderBtn = new javax.swing.JButton();
        tabAbout = new javax.swing.JPanel();
        aboutInfo = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GROUP 1 - ASSIGNMENT AAD1");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Next Product ID");

        nextProductId.setText("Product ID");

        jLabel3.setText("Product Name");

        jLabel4.setText("Prodcut Price ($)");

        addProductBtn.setText("Add Product");
        addProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtnActionPerformed(evt);
            }
        });

        dataProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataProductTable.setRowHeight(20);
        dataProductTable.setRowMargin(2);
        dataProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataProductTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dataProductTable);

        searchProductField.setText("Search");
        searchProductField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchProductFieldFocusLost(evt);
            }
        });
        searchProductField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchProductFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchProductFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout tabProductsLayout = new javax.swing.GroupLayout(tabProducts);
        tabProducts.setLayout(tabProductsLayout);
        tabProductsLayout.setHorizontalGroup(
            tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(tabProductsLayout.createSequentialGroup()
                        .addGroup(tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nextProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabProductsLayout.createSequentialGroup()
                                .addGroup(tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                    .addComponent(addProductPrice))
                                .addGap(24, 24, 24)
                                .addGroup(tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addProductCheckName)
                                    .addComponent(addProductCheckPrice))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tabProductsLayout.createSequentialGroup()
                        .addComponent(addProductBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchProductField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tabProductsLayout.setVerticalGroup(
            tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProductsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nextProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(addProductCheckName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addProductCheckPrice)
                    .addComponent(addProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductBtn)
                    .addComponent(searchProductField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Products", tabProducts);

        dataOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataOrderTable.setRowHeight(20);
        dataOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataOrderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataOrderTable);

        addOrderBtn.setText("Add an Order");
        addOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabOrdersLayout = new javax.swing.GroupLayout(tabOrders);
        tabOrders.setLayout(tabOrdersLayout);
        tabOrdersLayout.setHorizontalGroup(
            tabOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(tabOrdersLayout.createSequentialGroup()
                        .addComponent(addOrderBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tabOrdersLayout.setVerticalGroup(
            tabOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addOrderBtn)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Orders", tabOrders);

        aboutInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        aboutInfo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        aboutInfo.setEnabled(false);
        aboutInfo.setFocusable(false);

        javax.swing.GroupLayout tabAboutLayout = new javax.swing.GroupLayout(tabAbout);
        tabAbout.setLayout(tabAboutLayout);
        tabAboutLayout.setHorizontalGroup(
            tabAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aboutInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabAboutLayout.setVerticalGroup(
            tabAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabAboutLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(aboutInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("About", tabAbout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchProductFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProductFieldKeyReleased
        if (searchProductField.getText().trim().compareTo("") != 0) {
            List<Product> temp = new LinkedList<>();

            for (Product i : dataProduct) {
                if (i.getName().toUpperCase().contains(searchProductField.getText().toUpperCase())) {
                    temp.add(i);
                }
            }
            filteredProductList = temp;
            ptm.setData(temp);
            ptm.fireTableDataChanged();
            dataProductTable.setModel(ptm);
        } else {
            ptm.setData(dataProduct);
            ptm.fireTableDataChanged();
            dataProductTable.setModel(ptm);
        }
    }//GEN-LAST:event_searchProductFieldKeyReleased

    private void searchProductFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchProductFieldFocusLost
        if (searchProductField.getText().compareTo("") == 0) {
            searchProductField.setText("Search");
            ptm.setData(dataProduct);
            ptm.fireTableDataChanged();
            dataProductTable.setModel(ptm);
        }
    }//GEN-LAST:event_searchProductFieldFocusLost

    private void dataProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataProductTableMouseClicked
        if (evt.getClickCount() == 2) {
            if (searchProductField.getText().trim().compareTo("Search") == 0) {
                selectedProduct = dataProductTable.rowAtPoint(evt.getPoint());
                EditProductFrame editProductFrame = new EditProductFrame(dataProduct.get(selectedProduct));
                editProductFrame.getContentPane();
            } else {
                ptm.setData(filteredProductList);
                ptm.fireTableDataChanged();
                selectedProduct = dataProductTable.rowAtPoint(evt.getPoint());
                EditProductFrame editProductFrame = new EditProductFrame(filteredProductList.get(selectedProduct));
                editProductFrame.getContentPane();
            }
        }
    }//GEN-LAST:event_dataProductTableMouseClicked

    private void addProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtnActionPerformed
        if (addProductName.getText().equals("") || addProductPrice.getText().equals("")) {
            if (addProductName.getText().equals("")) {
                addProductCheckName.setText("Please input a Product Name.");
            }
            if (addProductPrice.getText().equals("")) {
                addProductCheckPrice.setText("Please input a Product Price.");
            }
        } else {
            Product temp = new Product(dataProduct.size() + 1, addProductName.getText(), Double.parseDouble(addProductPrice.getText()));
            dataProduct.add(temp);
            DbController.InsertNewProductToDB(temp);
            Collections.sort(dataProduct);
            ptm.fireTableDataChanged();
            nextProductId.setText(Integer.toString(dataProduct.size() + 1));
            addProductName.setText(null);
            addProductPrice.setText(null);
            addProductCheckName.setText(null);
            addProductCheckPrice.setText(null);
            JOptionPane.showMessageDialog(this, "Add Successfully!");
        }
    }//GEN-LAST:event_addProductBtnActionPerformed

    private void dataOrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataOrderTableMouseClicked
        if (evt.getClickCount() == 2) {
            EditOrderFrame editOrderFrame = new EditOrderFrame(dataOrder.get(dataOrderTable.rowAtPoint(evt.getPoint())));
            editOrderFrame.getContentPane();
        }
    }//GEN-LAST:event_dataOrderTableMouseClicked

    private void addOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderBtnActionPerformed
        MakeOrderFrame makeOrderFrame = new MakeOrderFrame(dataProduct, dataOrder, ptm);
        makeOrderFrame.getContentPane();
    }//GEN-LAST:event_addOrderBtnActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ptm.fireTableDataChanged();
        otm.fireTableDataChanged();
    }//GEN-LAST:event_formWindowActivated

    private void searchProductFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProductFieldKeyPressed
        if (searchProductField.getText().compareTo("Search") == 0) {
            searchProductField.setText("");
        }
    }//GEN-LAST:event_searchProductFieldKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new App().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane aboutInfo;
    private javax.swing.JButton addOrderBtn;
    private javax.swing.JButton addProductBtn;
    private javax.swing.JLabel addProductCheckName;
    private javax.swing.JLabel addProductCheckPrice;
    private javax.swing.JTextField addProductName;
    private javax.swing.JTextField addProductPrice;
    private javax.swing.JTable dataOrderTable;
    private javax.swing.JTable dataProductTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel nextProductId;
    private javax.swing.JTextField searchProductField;
    private javax.swing.JPanel tabAbout;
    private javax.swing.JPanel tabOrders;
    private javax.swing.JPanel tabProducts;
    // End of variables declaration//GEN-END:variables
}