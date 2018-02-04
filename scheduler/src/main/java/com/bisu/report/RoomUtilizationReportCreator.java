/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.report;

import com.bisu.dao.LoadingDetail;
import com.bisu.dao.Room;
import com.bisu.entities.Rooms;
import com.bisu.entities.TeachersLoadingDetails;
import com.bisu.entities.TeachersLoadings;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
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
public class RoomUtilizationReportCreator {

    public boolean create(List<TeachersLoadingDetails> detail, Rooms rooms) throws ParseException {

        // TODO code application logic here
        try {
            /* User home directory location */
            String userHomeDirectory = System.getProperty("user.home");
            /* Output file location */
             Date date = new Date();

        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy_MM_dd");
        String f = dt1.format(date)+"_"+date.getTime();
            String outputFile = userHomeDirectory + File.separatorChar + f+"_RoomUtilizationReport.pdf";
            List<RoomUtlizationData> roomData = new ArrayList<RoomUtlizationData>();
            List<TeachersLoadingDetails> first = new ArrayList<TeachersLoadingDetails>();
            List<TeachersLoadingDetails> second = new ArrayList<TeachersLoadingDetails>();
            List<TeachersLoadingDetails> third = new ArrayList<TeachersLoadingDetails>();
            List<TeachersLoadingDetails> fourth = new ArrayList<TeachersLoadingDetails>();
            List<TeachersLoadingDetails> fifth = new ArrayList<TeachersLoadingDetails>();
            List<TeachersLoadingDetails> sixth = new ArrayList<TeachersLoadingDetails>();
            List<TeachersLoadingDetails> seventh = new ArrayList<TeachersLoadingDetails>();
            List<TeachersLoadingDetails> eigth = new ArrayList<TeachersLoadingDetails>();
            List<TeachersLoadingDetails> ninth = new ArrayList<TeachersLoadingDetails>();
            List<TeachersLoadingDetails> tenth = new ArrayList<TeachersLoadingDetails>();

            for (TeachersLoadingDetails item : detail) {
                if (inTimeFirst(item.getHourStart(), item.getHourEnd())) {
                    first.add(item);
                }
                if (inTimeSecond(item.getHourStart(), item.getHourEnd())) {
                    second.add(item);
                }
                if (inTimeThird(item.getHourStart(), item.getHourEnd())) {
                    third.add(item);
                }
                if (inTimeFourth(item.getHourStart(), item.getHourEnd())) {
                    fourth.add(item);
                }
                if (inTimeFifth(item.getHourStart(), item.getHourEnd())) {
                    fifth.add(item);
                }
                if (inTimeSixth(item.getHourStart(), item.getHourEnd())) {
                    sixth.add(item);
                }
                if (inTimeSeventh(item.getHourStart(), item.getHourEnd())) {
                    seventh.add(item);
                }
                if (inTimeEigth(item.getHourStart(), item.getHourEnd())) {
                    eigth.add(item);
                }
                if (inTimeNinth(item.getHourStart(), item.getHourEnd())) {
                    ninth.add(item);
                }
                if (inTimeTenth(item.getHourStart(), item.getHourEnd())) {
                    tenth.add(item);
                }

            }

            roomData.add(transform(first, "7:30 - 8:30"));
            roomData.add(transform(second, "8:30 - 9:30"));
            roomData.add(transform(third, "09:30 - 10:30"));
            roomData.add(transform(fourth, "10:30 - 11:30"));
            roomData.add(transform(fifth, "12:30 - 01:30"));
            roomData.add(transform(sixth, "01:30 - 02:30"));
            roomData.add(transform(seventh, "02:30 - 03:30"));
            roomData.add(transform(eigth, "03:30 - 04:30"));
            roomData.add(transform(ninth, "04:30 - 05:30"));
            roomData.add(transform(tenth, "05:30 - 06:30"));

            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(roomData);

            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("RoomDataSource", itemsJRBean);
            parameters.put("Room", "" + rooms.getNumber());


            /* Using compiled version(.jasper) of Jasper report to generate PDF */
            JasperPrint jasperPrint = JasperFillManager.fillReport("C:\\Users\\ANGGIE\\Documents\\NetBeansProjects\\scheduler\\scheduler\\src\\main\\java\\com\\bisu\\report\\RoomUtilization.jasper", parameters, new JREmptyDataSource());

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

        // TODO code application logic here
    }

    public static RoomUtlizationData transform(List<TeachersLoadingDetails> first, String time) {

        RoomUtlizationData result = new RoomUtlizationData();
        result.setTime(time);

        for (TeachersLoadingDetails data : first) {
            TeachersLoadings load = data.getTeachersLoadings();
            String value = "" + load.getSubjects().getCode() + " / " + load.getFaculties().getLastname();
            if (data.isM()) {
                result.setMonday(value);
            }
            if (data.isT()) {
                result.setTuesday(value);
            }
            if (data.isW()) {
                result.setWednesday(value);
            }
            if (data.isTh()) {
                result.setThursday(value);
            }
            if (data.isF()) {
                result.setFriday(value);

            }

        }

        return result;
    }

    public boolean inTimeFirst(Date s2, Date e2) throws ParseException {
        String startTime = "07:30";
        String endTime = "08:30";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s1 = sdf.parse(startTime);
        Date e1 = sdf.parse(endTime);
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }

    public boolean inTimeSecond(Date s2, Date e2) throws ParseException {
        String startTime = "08:30";
        String endTime = "09:30";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s1 = sdf.parse(startTime);
        Date e1 = sdf.parse(endTime);
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }

    public boolean inTimeThird(Date s2, Date e2) throws ParseException {
        String startTime = "09:30";
        String endTime = "10:30";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s1 = sdf.parse(startTime);
        Date e1 = sdf.parse(endTime);
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }

    public boolean inTimeFourth(Date s2, Date e2) throws ParseException {
        String startTime = "10:30";
        String endTime = "11:30";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s1 = sdf.parse(startTime);
        Date e1 = sdf.parse(endTime);
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }

    public boolean inTimeFifth(Date s2, Date e2) throws ParseException {
        String startTime = "12:30";
        String endTime = "13:30";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s1 = sdf.parse(startTime);
        Date e1 = sdf.parse(endTime);
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }

    public boolean inTimeSixth(Date s2, Date e2) throws ParseException {
        String startTime = "13:30";
        String endTime = "14:30";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s1 = sdf.parse(startTime);
        Date e1 = sdf.parse(endTime);
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }

    public boolean inTimeSeventh(Date s2, Date e2) throws ParseException {
        String startTime = "14:30";
        String endTime = "15:30";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s1 = sdf.parse(startTime);
        Date e1 = sdf.parse(endTime);
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }

    public boolean inTimeEigth(Date s2, Date e2) throws ParseException {
        String startTime = "15:30";
        String endTime = "16:30";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s1 = sdf.parse(startTime);
        Date e1 = sdf.parse(endTime);
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }

    public static boolean inTimeNinth(Date s2, Date e2) throws ParseException {
        String startTime = "16:30";
        String endTime = "17:30";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s1 = sdf.parse(startTime);
        Date e1 = sdf.parse(endTime);
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }

    public boolean inTimeTenth(Date s2, Date e2) throws ParseException {
        String startTime = "17:30";
        String endTime = "18:30";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date s1 = sdf.parse(startTime);
        Date e1 = sdf.parse(endTime);
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }

}
