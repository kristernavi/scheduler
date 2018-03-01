/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.report;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author ANGGIE
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
            /* User home directory location */
            String userHomeDirectory = System.getProperty("user.home");
            /* Output file location */
            String outputFile = userHomeDirectory + File.separatorChar + "JasperTableExample1.pdf";
            
            /* List to hold Items */
            List<Item> listItems = new ArrayList<Item>();

            /* Create Items */
            Item iPhone = new Item();
            iPhone.setName("iPhone 6S");
            iPhone.setPrice(65000.00);

            Item iPad = new Item();
            iPad.setName("iPad Pro");
            iPad.setPrice(70000.00);

            /* Add Items to List */
            listItems.add(iPhone);
            listItems.add(iPad);

            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("ItemDataSource", itemsJRBean);

            /* Using compiled version(.jasper) of Jasper report to generate PDF */
            JasperPrint jasperPrint = JasperFillManager.fillReport("/Users/ANGGIE/Documents/java/scheduler/scheduler/src/main/java/com/bisu/report/template_Table.jasper", parameters, new JREmptyDataSource());

            /* outputStream to create PDF */
            OutputStream outputStream = new FileOutputStream(new File(outputFile));
            /* Write content to PDF file */
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            System.out.println("File Generated");
            if (Desktop.isDesktopSupported()) {
                 File myFile = new File(outputFile);
                Desktop.getDesktop().open(myFile);
   
}
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
         catch (IOException ex) {
         // no application registered for PDFs
        }
    }
    
}
