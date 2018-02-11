/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.report;

/**
 *
 * @author ivankrister
 */
public class LoadItem {
    Integer load = 0;
    String subject = "";
    Integer lecHrs = 0;
    Integer labHrs = 0;

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getLecHrs() {
        return lecHrs;
    }

    public void setLecHrs(Integer lecHrs) {
        this.lecHrs = lecHrs;
    }

    public Integer getLabHrs() {
        return labHrs;
    }

    public void setLabHrs(Integer labHrs) {
        this.labHrs = labHrs;
    }
    
}
