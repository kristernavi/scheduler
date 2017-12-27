/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.extras;

import com.bisu.contracts.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;


/**
 *
 * @author ivankrister
 */
public class Helper {

    public static boolean messageBox(String message, String titleBar, boolean warning) {
        if (!warning) {
            messageBox(message, titleBar);
            return true;
        } else {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, message, titleBar, dialogButton);
            if (dialogResult == 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    public static void messageBox(String infoMessage, String titleBar) {

        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);

    }
    public static boolean confirmationMessage(){
    
       return messageBox("Are you want to continue the action?", "Confirmation", true);
    }
    public static void successMessage(){
    
       messageBox("Record Succefully Save", "Processing Complete");
    }
    public static void deleteMessage(){
       messageBox("Record Succefully Deleted", "Processing Complete");
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    public static Session openSession(){
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public static void closeSession(){
        openSession().close();
    }
}
