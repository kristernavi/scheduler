/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.report;

import com.bisu.dao.Loading;
import com.bisu.dao.SchoolYear;
import com.bisu.dao.Teacher;
import com.bisu.entities.Faculties;
import java.io.File;

/**
 *
 * @author ivankrister
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Loading loading = new Loading();
        
        Teacher teacher = new Teacher();
        Faculties instructor = (Faculties) teacher.find(1);
        SchoolYear schoolYears = new SchoolYear();
        FacultyLoadReportCreator report = new FacultyLoadReportCreator();
        report.create(loading.getByInstructor(instructor, schoolYears.getActive()), instructor, 2);
    }
    
}
