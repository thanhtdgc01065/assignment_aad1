/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtd.controllers;

import com.thanhtd.models.Order;
import com.thanhtd.models.OrderDetail;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author trduy
 */
public class WorkWithEmail {

    public static void SendEmailToUser(Order item, List<OrderDetail> list, String user, String pass) {
        final String sender = user + "@fpt.edu.vn";
        final String password = pass;
        String listProduct = "";
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i).getProductPrice() * list.get(i).getQuantity();
            listProduct += "Item No." + (i + 1) + "/" + list.size()
                    + "\nProduct Name: " + list.get(i).getProductName()
                    + "\nPrice: $" + list.get(i).getProductPrice()
                    + "\nQuantity: " + list.get(i).getQuantity()
                    + "\nTotal: $" + list.get(i).getProductPrice() * list.get(i).getQuantity() + "\n\n";
        }
        String message = "Dear Mr/Mrs " + item.getCusName() + ", "
                + "\nThank you for your order. Here is your order detail."
                + "\n\nOrder Number: " + item.getID()
                + "\nCustomer Name: " + item.getCusName()
                + "\nCustomer Address: " + item.getCusAdd()
                + "\nCustomer Telephone: " + item.getCusTel()
                + "\nCustomer Email: " + item.getCusEmail()
                + "\n\nPRODUCT LIST:" + "\n" + listProduct
                + "\n\nTOTAL: $" + total;

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");

        Session session;
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });

        MimeMessage mesg = new MimeMessage(session);
        try {
            mesg.setFrom(new InternetAddress(sender));
            mesg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(item.getCusEmail()));
            mesg.setSubject("Order Number: " + item.getID());
            mesg.setText(message);
            Transport.send(mesg);
        } catch (AddressException ex) {
            System.out.println("There was a problem sending your mail.\n" + ex);
        } catch (MessagingException ex) {
            System.out.println("There was a problem sending your mail.\n" + ex);
        }
    }
}
