/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.views;

import com.thanhtd.app.App;
import com.thanhtd.controllers.DbController;
import com.thanhtd.controllers.ProductController;
import com.thanhtd.models.Product;
import javax.swing.JOptionPane;

/**
 *
 * @author Thanh Tran
 */
public class EditProductFrame extends javax.swing.JFrame {

    /**
     * Creates new form EditProductFrame
     */
    private Product temp;

    public EditProductFrame(Product i) {
        initComponents();

        //Set the windows to center of screen
        setLocationRelativeTo(null);

        temp = i;
        editProductID.setText("" + temp.getProductID());
        editProductNameTxt.setText(temp.getName());
        editProductPriceTxt.setText("" + temp.getPrice());
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editProductNameTxt = new javax.swing.JTextField();
        editProductPriceTxt = new javax.swing.JTextField();
        editProductID = new javax.swing.JLabel();
        editProductSaveBtn = new javax.swing.JButton();
        editProductCancelBtn = new javax.swing.JButton();
        editProductDeleteBtn = new javax.swing.JButton();

        setTitle("Edit Product");
        setResizable(false);

        jLabel1.setText("Product ID");

        jLabel2.setText("Product Name");

        jLabel3.setText("Product Price ($)");

        editProductID.setText("jLabel4");

        editProductSaveBtn.setText("Save");
        editProductSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductSaveBtnActionPerformed(evt);
            }
        });

        editProductCancelBtn.setText("Close");
        editProductCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductCancelBtnActionPerformed(evt);
            }
        });

        editProductDeleteBtn.setText("Delete");
        editProductDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductDeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editProductDeleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editProductSaveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editProductCancelBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editProductNameTxt)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editProductID)
                                    .addComponent(editProductPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 145, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(editProductID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(editProductNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(editProductPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editProductDeleteBtn)
                    .addComponent(editProductSaveBtn)
                    .addComponent(editProductCancelBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editProductCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductCancelBtnActionPerformed
        if (editProductNameTxt.getText().trim().toUpperCase().compareTo(temp.getName().toUpperCase()) == 0
                && Float.parseFloat(editProductPriceTxt.getText()) == temp.getPrice()) {
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Product information changed. Please save before close.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_editProductCancelBtnActionPerformed

    private void editProductSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductSaveBtnActionPerformed
        temp.setName(editProductNameTxt.getText());
        temp.setPrice(Double.parseDouble(editProductPriceTxt.getText()));
        ProductController.UpdateProduct(App.dataProduct, App.selectedProduct, temp);
        JOptionPane.showMessageDialog(this, "Product ID: " + temp.getProductID() + " changed!");
        DbController.UpdateProductToDB(temp);
        setVisible(false);
        App.ptm.fireTableDataChanged();
    }//GEN-LAST:event_editProductSaveBtnActionPerformed

    private void editProductDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductDeleteBtnActionPerformed
        App.dataProduct.remove(App.selectedProduct);
        JOptionPane.showMessageDialog(this, "Product ID: " + temp.getProductID() + " deleted!");
        DbController.DeleteProductFromDB(temp.getProductID());
        setVisible(false);
        App.ptm.fireTableDataChanged();
    }//GEN-LAST:event_editProductDeleteBtnActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(EditProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EditProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EditProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EditProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EditProductFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editProductCancelBtn;
    private javax.swing.JButton editProductDeleteBtn;
    private javax.swing.JLabel editProductID;
    private javax.swing.JTextField editProductNameTxt;
    private javax.swing.JTextField editProductPriceTxt;
    private javax.swing.JButton editProductSaveBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}