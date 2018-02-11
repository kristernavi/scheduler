/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import com.bisu.dao.Course;
import com.bisu.dao.LoadCourse;
import com.bisu.dao.Loading;
import com.bisu.dao.Subject;
import com.bisu.dao.SubjectCourse;
import com.bisu.entities.Courses;
import com.bisu.entities.LoadCourses;
import com.bisu.entities.SchoolYears;
import com.bisu.entities.TeachersLoadingDetails;
import com.bisu.entities.TeachersLoadings;
import com.bisu.extras.Helper;
import com.bisu.report.ClassScheduleReportCreator;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ANGGIE
 */
public class ClassProgram extends javax.swing.JFrame {

    /**
     * Creates new form ClassProgram
     */
    MainMenu mainMenu;
    Course course;
    com.bisu.dao.SchoolYear schoolYear;
    SubjectCourse subjectCourse;
    Subject subject;
    Loading loading;
    DefaultTableModel model;
    LoadCourse loadCourse;
    List <TeachersLoadingDetails> reportData = new ArrayList<TeachersLoadingDetails>();
    

    public ClassProgram() {
        this.course = new Course();
        this.loadCourse = new LoadCourse();
        this.schoolYear = new com.bisu.dao.SchoolYear();
        this.subjectCourse = new SubjectCourse();
        this.subject = new Subject();
        this.loading = new Loading();
        initComponents();
        this.model = (DefaultTableModel) classProgramTable.getModel();
           setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public ClassProgram(MainMenu mainMenu) {
        this();
        this.mainMenu = mainMenu;

        int op = this.getDefaultCloseOperation(); // HIDE_ON_CLOSE
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

    }

    private List comboCourseItem() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Course"));

        try {
            for (Object obj : course.all()) {
                Courses model = (Courses) obj;
                String name = model.getCode() + " - " + model.getDescription();
                combo.add(new ComboItem(model.getId(), "" + name));
            }
        } catch (Exception e) {

        }

        return combo;
    }

    private List comboSchooYearItem() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select SchoolYear"));

        try {
            for (Object obj : schoolYear.all()) {
                SchoolYears model = (SchoolYears) obj;
                String sem = "";
                if (model.getSemester() == 1) {
                    sem = "First Semester";
                } else {
                    sem = "Second Semester";
                }
                String current = "";
                if (model.isActived()) {
                    current = "(Current)";
                }
                String name = model.getYearStart() + " - " + model.getYearEnd() + " " + sem + " " + current;
                combo.add(new ComboItem(model.getId(), "" + name));
            }
        } catch (Exception e) {

        }

        return combo;
    }

    public void offScreen() {
        this.mainMenu.setVisible(false);
        schoolYearCb.setModel(new javax.swing.DefaultComboBoxModel(comboSchooYearItem().toArray()));
    }

    public void onScreen() {
        this.mainMenu.setVisible(true);
        this.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFileChooser1 = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jLabel1 = new javax.swing.JLabel();
        schoolYearCb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollbar1 = new java.awt.Scrollbar();
        jScrollPane1 = new javax.swing.JScrollPane();
        classProgramTable = new javax.swing.JTable();
        courseCb = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        yearCB = new javax.swing.JComboBox<>();
        sectionCb = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Class Schedule");
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jLabel1.setText("School Year:");

        schoolYearCb.setModel(new javax.swing.DefaultComboBoxModel(comboSchooYearItem().toArray()));
        schoolYearCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schoolYearCbActionPerformed(evt);
            }
        });

        jLabel2.setText("Course:");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        classProgramTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        classProgramTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Code", "Instructor", "Room", "Hours", "Day", "Course"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(classProgramTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
        );

        courseCb.setModel(new javax.swing.DefaultComboBoxModel(comboCourseItem().toArray()));
        courseCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCbActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Year Level:");

        yearCB.setModel(new javax.swing.DefaultComboBoxModel(comboYearItems().toArray()));
        yearCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCBActionPerformed(evt);
            }
        });

        sectionCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));
        sectionCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionCbActionPerformed(evt);
            }
        });

        jLabel10.setText("Section:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(schoolYearCb, 0, 441, Short.MAX_VALUE)
                                    .addComponent(courseCb, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(yearCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(sectionCb, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(schoolYearCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(courseCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.onScreen();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ClassScheduleReportCreator report = new ClassScheduleReportCreator();
        jButton2.setText("Please wait ... ");
        jButton2.setEnabled(false);
        String course = courseCb.getSelectedItem().toString();
        String section = sectionCb.getSelectedItem().toString();
        String year = yearCB.getSelectedItem().toString();
        try {
            report.create(reportData, course, section,year);
        } catch (ParseException ex) {
            Logger.getLogger(ClassProgram.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        jButton2.setText("Print");
        jButton2.setEnabled(true);
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void schoolYearCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schoolYearCbActionPerformed
        // TODO add your handling code here:
        ComboItem selected_sy = (ComboItem) this.schoolYearCb.getSelectedItem();
        ComboItem selected_course = (ComboItem) this.courseCb.getSelectedItem();
                model.setRowCount(0);

        ComboItem selected_year = (ComboItem) this.yearCB.getSelectedItem();
        if (selected_sy.getValue() > 0 && selected_course.getValue() > 0 && selected_year.getValue() > 0) {
            Short year = Short.parseShort(""+selected_year.getValue());
            populateTableContent(selected_sy.getValue(), selected_course.getValue(), year);
        }

    }//GEN-LAST:event_schoolYearCbActionPerformed

    private List comboYearItems() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Year"));
        combo.add(new ComboItem(1, "First Year"));
        combo.add(new ComboItem(2, "Second Year"));
        combo.add(new ComboItem(3, "Third Year"));
        combo.add(new ComboItem(4, "Fourth Year"));

        return combo;
    }
    private void courseCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCbActionPerformed
        // TODO add your handling code here:
        ComboItem selected_sy = (ComboItem) this.schoolYearCb.getSelectedItem();
        ComboItem selected_course = (ComboItem) this.courseCb.getSelectedItem();
        ComboItem selected_year = (ComboItem) this.yearCB.getSelectedItem();
        
                model.setRowCount(0);

        if (selected_sy.getValue() > 0 && selected_course.getValue() > 0 && selected_year.getValue() > 0) {
            Short year = Short.parseShort(""+selected_year.getValue());
            populateTableContent(selected_sy.getValue(), selected_course.getValue(), year);
        }
    }//GEN-LAST:event_courseCbActionPerformed

    private void yearCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCBActionPerformed
        // TODO add your handling code here:
        ComboItem selected_sy = (ComboItem) this.schoolYearCb.getSelectedItem();
        ComboItem selected_course = (ComboItem) this.courseCb.getSelectedItem();
        ComboItem selected_year = (ComboItem) this.yearCB.getSelectedItem();
                model.setRowCount(0);
        if (selected_sy.getValue() > 0 && selected_course.getValue() > 0 && selected_year.getValue() > 0) {
            Short year = Short.parseShort(""+selected_year.getValue());
            populateTableContent(selected_sy.getValue(), selected_course.getValue(), year);
        }
    }//GEN-LAST:event_yearCBActionPerformed

    private void sectionCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionCbActionPerformed
        // TODO add your handling code here:
         ComboItem selected_sy = (ComboItem) this.schoolYearCb.getSelectedItem();
        ComboItem selected_course = (ComboItem) this.courseCb.getSelectedItem();
        ComboItem selected_year = (ComboItem) this.yearCB.getSelectedItem();
                model.setRowCount(0);
        if (selected_sy.getValue() > 0 && selected_course.getValue() > 0 && selected_year.getValue() > 0) {
            Short year = Short.parseShort(""+selected_year.getValue());
            populateTableContent(selected_sy.getValue(), selected_course.getValue(), year);
        }
    }//GEN-LAST:event_sectionCbActionPerformed
    private void populateTableContent(Integer schoolYearId, Integer courseId, Short y) {
        Courses c = (Courses) course.find(courseId);
        Object row[] = new Object[6];
        List dataLoadCouse = this.loadCourse.getByCourse(c);
        reportData.clear();
        for (int o = 0; o < dataLoadCouse.size(); o++) {

            LoadCourses loadCourses = (LoadCourses) dataLoadCouse.get(o);

            TeachersLoadingDetails detail = loadCourses.getTeachersLoadingDetails();

            if (detail.getTeachersLoadings().getSubjects().getYearLevel() == y && detail.getTeachersLoadings().getSchoolYears().getId() == schoolYearId &&detail.getSection().equals(sectionCb.getSelectedItem().toString())) {
            long diff = detail.getHourEnd().getTime() - detail.getHourStart().getTime();
            row[0] = detail.getTeachersLoadings().getSubjects().getCode();
            String day = "";
            if (detail.isM()) {
                day = day + "M";
            }
            if (detail.isT()) {
                day = day + "T";
            }
            if (detail.isW()) {
                day = day + "W";
            }
            if (detail.isTh()) {
                day = day + "Th";
            }
            if (detail.isF()) {
                day = day + "F";
            }
            row[1] = detail.getTeachersLoadings().getFaculties().getFullname();
            row[2] = detail.getRooms().getNumber();
            row[3] = Helper.timeFormat(detail.getHourStart()) + " - "+Helper.timeFormat(detail.getHourEnd());
            row[4] = day;
            String crs = "";
            for (LoadCourses lc : detail.getLoadCourseses()) {
                crs = crs + "/" + lc.getCourses().getCode() +detail.getSection();
            }
            reportData.add(detail);
            crs = StringUtils.removeEnd(crs, "/");
            crs = StringUtils.removeStart(crs, "/");
            row[5] = crs;
            model.addRow(row);
            }

            

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClassProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassProgram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable classProgramTable;
    private javax.swing.JComboBox<String> courseCb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JComboBox<String> schoolYearCb;
    private java.awt.Scrollbar scrollbar1;
    private javax.swing.JComboBox<String> sectionCb;
    private javax.swing.JComboBox<String> yearCB;
    // End of variables declaration//GEN-END:variables
}
