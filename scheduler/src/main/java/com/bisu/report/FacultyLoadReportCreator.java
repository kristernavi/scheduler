/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.report;

import com.bisu.entities.Faculties;
import com.bisu.entities.Subjects;
import com.bisu.entities.TeachersLoadingDetails;
import com.bisu.entities.TeachersLoadings;
import static com.bisu.report.RoomUtilizationReportCreator.inTimeNinth;
import static com.bisu.report.RoomUtilizationReportCreator.transform;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * @author ivankrister
 */
public class FacultyLoadReportCreator {
    
    public boolean create(List loads, Faculties instructor, Integer overload){
         // TODO code application logic here
        try {
            /* User home directory location */
            String userHomeDirectory = System.getProperty("user.home");
            /* Output file location */
             Date date = new Date();

        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy_MM_dd");
        String f = dt1.format(date)+"_"+date.getTime();
            String outputFile = userHomeDirectory + File.separatorChar + f+"_FacultyLoadReport.pdf";
            List<LoadItem> loadData = new ArrayList<LoadItem>();
            
            for(int i = 0 ; i < loads.size(); i++){
                TeachersLoadings load = (TeachersLoadings) loads.get(i);
                LoadItem item = new LoadItem();
                Subjects subject = load.getSubjects();
                Integer unitLoad = subject.getLabHours() + ( subject.getLecHours() /3);
                item.setLabHrs(subject.getLabHours());
                item.setLecHrs(subject.getLecHours());
                item.setLoad(unitLoad);
                item.setSubject(subject.getCode());
                loadData.add(item);
                
            }
          
            
            

         
            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(loadData);

            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("LoadDataList", itemsJRBean);
            parameters.put("Instructor", "" + instructor.getFullname());
            parameters.put("Overload", ""+overload);
            parameters.put("RegularLoad", ""+instructor.getRegularLoad());



            /* Using compiled version(.jasper) of Jasper report to generate PDF */
            JasperPrint jasperPrint = JasperFillManager.fillReport("/Users/ivankrister/Documents/java/scheduler/scheduler/src/main/java/com/bisu/report/FacultyLoad.jasper", parameters, new JREmptyDataSource());

            /* outputStream to create PDF */
            OutputStream outputStream = new FileOutputStream(new File(outputFile));
            /* Write content to PDF file */
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            if (Desktop.isDesktopSupported()) {
                File myFile = new File(outputFile);
                Desktop.getDesktop().open(myFile);

            }
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            // no application registered for PDFs
        }
        return true;

    
    }
    
}
