/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import com.bisu.dao.Course;
import com.bisu.dao.Loading;
import com.bisu.dao.Subject;
import com.bisu.dao.SubjectCourse;
import com.bisu.dao.Teacher;
import com.bisu.entities.Faculties;
import com.bisu.entities.LoadCourses;
import com.bisu.entities.SubjectCourses;
import com.bisu.entities.Subjects;
import com.bisu.entities.TeachersLoadings;
import com.bisu.report.FacultyLoadReportCreator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ivankrister
 */
public class FacultyLoadList extends javax.swing.JFrame {

    /**
     * Creates new form FacultyLoadList
     */
     MainMenu mainMenu;
    Course course;
    Teacher teacher;
    Subject subject;
    SubjectCourse sc;
    DefaultTableModel model;
    Loading teacherLoading;
    com.bisu.dao.SchoolYear schoolYear;
    public FacultyLoadList() {
        course = new Course();
        teacher = new Teacher();
        subject = new Subject();
        sc = new SubjectCourse();
        teacherLoading = new Loading();
        schoolYear = new com.bisu.dao.SchoolYear();
        initComponents();
        model = (DefaultTableModel) loadingTable.getModel();
    }
    
    public FacultyLoadList(MainMenu mainMenu) {
    this();
    this.mainMenu = mainMenu;
        int op = this.getDefaultCloseOperation(); // HIDE_ON_CLOSE
    this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    
    }
    public void offScreen(){
     this.mainMenu.setVisible(false);
    }
    public void onScreen(){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        loadingTable = new javax.swing.JTable();
        scrollbar1 = new java.awt.Scrollbar();
        instructorCb = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        loadLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        overloadLbl = new javax.swing.JLabel();
        loadsLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tLoadLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loadingTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        loadingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Subject Code", "Load", "Lecture Hours", "Laboratory Hours"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(loadingTable);

        instructorCb.setModel(new javax.swing.DefaultComboBoxModel(comboTeacherItem().toArray()));
        instructorCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorCbActionPerformed(evt);
            }
        });

        jLabel7.setText("Instructor:");

        jLabel1.setText("Load");

        loadLbl.setText("0");

        jLabel3.setText("Overload");

        jLabel4.setText("Teacher Loading");

        overloadLbl.setText("0");

        loadsLbl.setText("0");

        jLabel8.setText("Unit Load");

        tLoadLbl.setText("0");

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(overloadLbl)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tLoadLbl)
                .addGap(0, 156, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructorCb, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(instructorCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(2, 2, 2)
                                .addComponent(jButton2)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(loadLbl)
                    .addComponent(jLabel3)
                    .addComponent(overloadLbl)
                    .addComponent(jLabel4)
                    .addComponent(loadsLbl)
                    .addComponent(jLabel8)
                    .addComponent(tLoadLbl))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private List comboTeacherItem() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Instructor"));

        try {
            for (Object obj : teacher.all()) {
                Faculties model = (Faculties) obj;
                combo.add(new ComboItem(model.getId(), model.getFirstname() + " " + model.getLastname()));
            }
        } catch (Exception e) {

        }

        return combo;
    }

    private void instructorCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorCbActionPerformed
        // TODO add your handling code here:
        ComboItem item = (ComboItem) instructorCb.getSelectedItem();
        model.setRowCount(0);
        if (item.getValue() > 0) {
            Faculties faculty = (Faculties) teacher.find(item.getValue());
            Object row[] = new Object[8];
            Integer lecHrs = 0;
            Integer labHrs = 0;
            Integer units = 0;
            for (TeachersLoadings loadings : faculty.getTeachersLoadingses()) {
                if(loadings.getSchoolYears().isActived()){
                    Subjects sub = loadings.getSubjects();
                    Integer unit = sub.getLecHours() + (sub.getLabHours() / 3);
                    String c = "";
                for (SubjectCourses lc : sub.getSubjectCourseses()) {
                    c = c + "/" + lc.getCourses().getCode()+"-"+sub.getYearLevel();
                }
                    c = StringUtils.removeEnd(c, "/");
                    c = StringUtils.removeStart(c, "/");
                    lecHrs += sub.getLecHours();
                    labHrs += sub.getLabHours();
                    row[0] = c ;
                    row[1] = sub.getCode() ;
                    row[2] = unit;
                    row[3] = sub.getLecHours();
                    row[4] = sub.getLabHours();
                    row[5] = "Delete";
                    row[6] = loadings.getId();
                    row[7] = sub.getId();
                    model.addRow(row);
                }
            }
            units += lecHrs;
            units += (labHrs / 3);
            Integer overload = (faculty.getRegularLoad() - faculty.getDeloading()) - (lecHrs+labHrs);
            Integer over = overload < 0 ? overload * -1:0;
            loadLbl.setText("" + faculty.getRegularLoad());
            overloadLbl.setText("" + over);
            tLoadLbl.setText("" + units);
            loadsLbl.setText(""+ (lecHrs+labHrs));

        }
    }//GEN-LAST:event_instructorCbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ComboItem item = (ComboItem) instructorCb.getSelectedItem();
        if (item.getValue() > 0) {
            Faculties faculty = (Faculties) teacher.find(item.getValue());
            FacultyLoadReportCreator report;
            report = new FacultyLoadReportCreator();
            report.create(this.teacherLoading.getByInstructor(faculty, schoolYear.getActive()), faculty, Integer.parseInt(overloadLbl.getText()));
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                this.onScreen();

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FacultyLoadList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacultyLoadList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacultyLoadList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyLoadList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacultyLoadList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> instructorCb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loadLbl;
    private javax.swing.JTable loadingTable;
    private javax.swing.JLabel loadsLbl;
    private javax.swing.JLabel overloadLbl;
    private java.awt.Scrollbar scrollbar1;
    private javax.swing.JLabel tLoadLbl;
    // End of variables declaration//GEN-END:variables
}
