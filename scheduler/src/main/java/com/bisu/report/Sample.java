/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.report;
import com.bisu.report.Sample;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/**
 *
 * @author ANGGIE
 */
public class Sample {
    
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
