/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import com.bisu.dao.Department;
import com.bisu.dao.Loading;
import com.bisu.dao.LoadingDetail;
import com.bisu.dao.Teacher;
import com.bisu.entities.TeachersLoadings;
import com.bisu.entities.Departments;
import com.bisu.entities.Faculties;
import com.bisu.entities.LoadCourses;
import com.bisu.entities.TeachersLoadingDetails;
import com.bisu.extras.Helper;
import com.bisu.report.TeachersLoadReport;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ANGGIE
 */
public class TeachersLoad extends javax.swing.JFrame {

    /**
     * Creates new form TeachersLoad
     */
    private Department department;
    private Teacher teacher;
    DefaultTableModel model;
    private Loading load;
    private JPopupMenu popupMenu;
    MainMenu mainMenu;
    LoadingDetail loadDetail;
    com.bisu.dao.SchoolYear schoolYear;

    public TeachersLoad(MainMenu mainMenu) {
        this();
        this.mainMenu = mainMenu;
           setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void offScreen() {
        this.mainMenu.setVisible(false);
        
    }

    public void onScreen() {
        this.mainMenu.setVisible(true);
        this.setVisible(false);
        int op = this.getDefaultCloseOperation(); // HIDE_ON_CLOSE
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

    }

    public TeachersLoad() {
        popupMenu = new JPopupMenu();
        department = new Department();
        teacher = new Teacher();
        load = new Loading();
        this.schoolYear = new com.bisu.dao.SchoolYear();
        loadDetail = new LoadingDetail();
        initComponents();
        JMenuItem menuItemDelete = new JMenuItem("Delete");
        this.model = (DefaultTableModel) this.scheduleTable.getModel();
        menuItemDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (Helper.confirmationMessage()) {
                    String id = scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 4).toString();
                    TeachersLoadingDetails d = (TeachersLoadingDetails) loadDetail.find(Integer.parseInt(id));
                    loadDetail.delete(d);
                    model.removeRow(scheduleTable.getSelectedRow());
                    Helper.deleteMessage();
                }

            }
        });
        popupMenu.add(menuItemDelete);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        departmentCb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        instuctorCb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollbar1 = new java.awt.Scrollbar();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        loadLbl = new javax.swing.JLabel();
        overLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teachers Load");

        jLabel1.setText("Department:");

        departmentCb.setModel(new javax.swing.DefaultComboBoxModel(comboDepartmentItem().toArray()));
        departmentCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentCbActionPerformed(evt);
            }
        });

        jLabel2.setText("Instuctor:");

        instuctorCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instuctorCbActionPerformed(evt);
            }
        });

        jLabel3.setText("Regular Load:");

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        scheduleTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        scheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Days", "Room", "Subjects", "id", "Course"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scheduleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                scheduleTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(scheduleTable);
        if (scheduleTable.getColumnModel().getColumnCount() > 0) {
            scheduleTable.getColumnModel().getColumn(0).setResizable(false);
            scheduleTable.getColumnModel().getColumn(3).setResizable(false);
            scheduleTable.getColumnModel().getColumn(4).setMinWidth(0);
            scheduleTable.getColumnModel().getColumn(4).setPreferredWidth(0);
            scheduleTable.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Overload:");

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        loadLbl.setText("0");

        overLbl.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(departmentCb, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(instuctorCb, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(overLbl))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loadLbl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jButton4)
                            .addComponent(loadLbl))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(overLbl)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departmentCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(instuctorCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void populateTable(Faculties instructor) {
        List tableData;
        tableData = load.getByInstructor(instructor, this.schoolYear.getActive());

        Object row[] = new Object[6];
        model.setRowCount(0);
        for (int i = 0; i < tableData.size(); i++) {
            TeachersLoadings loads = (TeachersLoadings) tableData.get(i);
            Set<TeachersLoadingDetails> details = loads.getTeachersLoadingDetailses();

            for (Iterator<TeachersLoadingDetails> it = details.iterator(); it.hasNext();) {
                TeachersLoadingDetails detail = it.next();
                long diff = detail.getHourEnd().getTime() - detail.getHourStart().getTime();
                row[0] = Helper.formatDuration(diff);
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
                row[1] = day;
                row[2] = detail.getRooms().getNumber();
                row[3] = loads.getSubjects().getDescription();
                row[4] = detail.getId();
                String c = "";
                for (LoadCourses lc : detail.getLoadCourseses()) {
                    c = c + "/" + lc.getCourses().getCode();
                }
                c = StringUtils.removeEnd(c, "/");
                c = StringUtils.removeStart(c, "/");
                row[5] = c;
                model.addRow(row);
            }

        }

    }

    private List comboDepartmentItem() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Department"));

        try {
            for (Object obj : department.all()) {
                Departments model = (Departments) obj;
                combo.add(new ComboItem(model.getId(), model.getCode() + " - " + model.getDescription()));
            }
        } catch (Exception e) {

        }

        return combo;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ComboItem selected = (ComboItem) instuctorCb.getSelectedItem();
        if (selected.getValue() > 0) {
            jButton1.setText("Please wait ");
            jButton1.setEnabled(false);
            Faculties instructor = (Faculties) teacher.find(selected.getValue());
            loadLbl.setText("" + instructor.getRegularLoad());
            overLbl.setText("" + instructor.getOverload());
            List<TeachersLoadingDetails> newList = new ArrayList<TeachersLoadingDetails>();
            List tableData;
            tableData = load.getByInstructor(instructor, this.schoolYear.getActive());
            for (int i = 0; i < tableData.size(); i++) {
                TeachersLoadings loads = (TeachersLoadings) tableData.get(i);
                newList.addAll(loads.getTeachersLoadingDetailses());
            }
            TeachersLoadReport report = new TeachersLoadReport();
            try {
                if (report.create(newList, instructor)) {
                    jButton1.setText("Print");
                    jButton1.setEnabled(true);
                }
            } catch (ParseException ex) {
                Logger.getLogger(TeachersLoad.class.getName()).log(Level.SEVERE, null, ex);
                jButton1.setText("Print");
                jButton1.setEnabled(true);
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void departmentCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentCbActionPerformed
        // TODO add your handling code here:
        ComboItem selected = (ComboItem) departmentCb.getSelectedItem();
        if (selected.getValue() > 0) {
            Departments dept = (Departments) department.find(selected.getValue());
            instuctorCb.setModel(new javax.swing.DefaultComboBoxModel(comboInstructorItem(dept).toArray()));
        }
    }//GEN-LAST:event_departmentCbActionPerformed

    private void instuctorCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instuctorCbActionPerformed
        // TODO add your handling code here:
        ComboItem selected = (ComboItem) instuctorCb.getSelectedItem();
        if (selected.getValue() > 0) {
            Faculties instructor = (Faculties) teacher.find(selected.getValue());
            loadLbl.setText("" + instructor.getRegularLoad());
            overLbl.setText("" + instructor.getOverload());
            this.populateTable(instructor);
        }

    }//GEN-LAST:event_instuctorCbActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.onScreen();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void scheduleTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleTableMouseReleased
        // TODO add your handling code here:
        // TODO add your handling code here:
        System.err.println("Im outside");
        if (SwingUtilities.isRightMouseButton(evt)) {
            System.err.println("Im inside");

            JTable source = (JTable) evt.getSource();
            int row = source.rowAtPoint(evt.getPoint());
            int column = source.columnAtPoint(evt.getPoint());

            if (!source.isRowSelected(row)) {
                source.changeSelection(row, column, false, false);
            }
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_scheduleTableMouseReleased

    private List comboInstructorItem(Departments dept) {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Instructor"));

        try {
            for (Object obj : teacher.getByDepartment(dept)) {
                Faculties model = (Faculties) obj;
                combo.add(new ComboItem(model.getId(), model.getFirstname() + "  " + model.getLastname()));
            }
        } catch (Exception e) {

        }

        return combo;
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
            java.util.logging.Logger.getLogger(TeachersLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeachersLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeachersLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeachersLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeachersLoad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> departmentCb;
    private javax.swing.JComboBox<String> instuctorCb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loadLbl;
    private javax.swing.JLabel overLbl;
    private javax.swing.JTable scheduleTable;
    private java.awt.Scrollbar scrollbar1;
    // End of variables declaration//GEN-END:variables
}
