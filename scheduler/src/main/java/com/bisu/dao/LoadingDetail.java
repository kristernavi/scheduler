/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.TeachersLoadingDetails;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author ivankrister
 */
public class LoadingDetail extends AbstractModel {

    public LoadingDetail() {
        super(TeachersLoadingDetails.class);
    }

    public boolean hasConflict() {
        Query query = session().createSQLQuery(
                "select s.stock_code from stock s where s.stock_code = :stockCode")
                .setParameter("stockCode", "7277");
        List result = query.list();
        return true;
    }

}
