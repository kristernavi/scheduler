/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.dao;

import com.bisu.contracts.AbstractModel;
import com.bisu.entities.Faculties;
import com.bisu.entities.SchoolYears;
import com.bisu.entities.Subjects;
import com.bisu.entities.TeachersLoadings;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ivankrister
 */
public class Loading extends AbstractModel {

    public Loading() {
        super(TeachersLoadings.class);
    }

    public List getByInstructor(Faculties instructor, SchoolYears schoolYears) {

        List results;
        begin();

        Criteria cr = session().createCriteria(TeachersLoadings.class);
        cr.add(Restrictions.eq("faculties", instructor));
        cr.add(Restrictions.eq("schoolYears", schoolYears));

        results = cr.list();
        end();
        return results;
    }

    public List<TeachersLoadings> classRoomData(SchoolYears schoolYear, List<Subjects> subjects) {

        List results;
        begin();
        Criteria cr = session().createCriteria(TeachersLoadings.class);
        cr.add(Restrictions.in("subjects", subjects));
        cr.add(Restrictions.eq("schoolYears", schoolYear));
        results = cr.list();
        end();
        return results;

    }

    public boolean hasConflict(Integer schoolYear, Integer room, Date hr_start, Date hr_end, boolean m, boolean t, boolean w, boolean th, boolean f) {

        java.sql.Time sqlStart = new java.sql.Time(hr_start.getTime());
        java.sql.Time sqlEnd = new java.sql.Time(hr_end.getTime());

        String query_string = "SELECT teachers_loadings.teacher_id from teachers_loadings JOIN teachers_loading_details ON teachers_loadings.id = teachers_loading_details.loading_id ";

        query_string = query_string + "WHERE teachers_loadings.school_year_id = " + schoolYear;

        query_string = query_string + " AND teachers_loading_details.room_id = " + room;
        query_string = query_string + " AND teachers_loadings.school_year_id = " + schoolYear;
        query_string = query_string + " AND (teachers_loading_details.hour_start < '" + sqlEnd + "'";
        query_string = query_string + " AND teachers_loading_details.hour_end > '" + sqlStart + "') AND";

        if (m) {
            query_string = query_string + " teachers_loading_details.M = 1 OR";
        }
        if (t) {
            query_string = query_string + " teachers_loading_details.T = 1 OR";
        }
        if (w) {
            query_string = query_string + " teachers_loading_details.W = 1 OR";
        }
        if (th) {
            query_string = query_string + " teachers_loading_details.Th = 1 OR";
        }
        if (f) {
            query_string = query_string + " teachers_loading_details.F = 1 OR";
        }

        query_string = StringUtils.removeEnd(query_string, "OR");
        List result;
        begin();
        Query query = session().createSQLQuery(
                query_string);
        result = query.list();
        end();
        if (result.size() > 0) {
            return true;

        }
        return false;
    }

}
