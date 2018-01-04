/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

/**
 *
 * @author ANGGIE
 */
public class ComboItem {
    
    private Integer value;
    private String label;

    public ComboItem(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
    
    
    
    
    
}
