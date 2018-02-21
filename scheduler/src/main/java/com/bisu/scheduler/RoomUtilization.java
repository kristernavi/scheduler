/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import com.bisu.dao.LoadingDetail;
import com.bisu.dao.Room;
import com.bisu.entities.LoadCourses;
import com.bisu.entities.Rooms;
import com.bisu.entities.TeachersLoadingDetails;
import com.bisu.report.RoomUtilizationReportCreator;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ANGGIE
 */
public class RoomUtilization extends javax.swing.JFrame {

    /**
     * Creates new form RoomUtilization
     */
    MainMenu mainMenu;
    Room room;
    LoadingDetail loadingDetail;
    DefaultTableModel model;

    public RoomUtilization(MainMenu mainMenu) {
        this();
        this.mainMenu = mainMenu;
        int op = this.getDefaultCloseOperation(); // HIDE_ON_CLOSE
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
           setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public void offScreen() {
        this.mainMenu.setVisible(false);
    }

    public void onScreen() {
        this.mainMenu.setVisible(true);
        this.setVisible(false);
    }

    public RoomUtilization() {
        this.room = new Room();
        this.loadingDetail = new LoadingDetail();
        initComponents();
        model = (DefaultTableModel) utilizeRoomTable.getModel();

    }

    private List comboRoomItem() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Room"));

        try {
            for (Object obj : room.all()) {
                Rooms model = (Rooms) obj;
                combo.add(new ComboItem(model.getId(), "" + model.getNumber()));
            }
        } catch (Exception e) {

        }

        return combo;
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
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollbar1 = new java.awt.Scrollbar();
        jScrollPane1 = new javax.swing.JScrollPane();
        utilizeRoomTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        roomCb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Room Utilization");

        jLabel1.setText("Room Code:");

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        utilizeRoomTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        utilizeRoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Days", "Instructor", "Subjects", "Course"
            }
        ));
        jScrollPane1.setViewportView(utilizeRoomTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        roomCb.setModel(new javax.swing.DefaultComboBoxModel(comboRoomItem().toArray()));
        roomCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomCbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomCb, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 896, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(roomCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(494, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(2, 2, 2)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ComboItem selected = (ComboItem) roomCb.getSelectedItem();
        if (selected.getValue() > 0) {
            jButton1.setText("Please wait ... ");
            jButton1.setEnabled(false);
            Rooms room = (Rooms) this.room.find(selected.getValue());
            Object row[] = new Object[5];
            List<TeachersLoadingDetails> tableData;
            tableData = this.loadingDetail.getByRoom(room);

            for (Iterator<TeachersLoadingDetails> iter = tableData.listIterator(); iter.hasNext();) {
                TeachersLoadingDetails a = iter.next();
                if (!a.getTeachersLoadings().getSchoolYears().isActived()) {
                    iter.remove();
                }
            }
            RoomUtilizationReportCreator report = new RoomUtilizationReportCreator();
            try {
                if (report.create(tableData, room)) {
                    jButton1.setText("Print");
                    jButton1.setEnabled(true);
                }

            } catch (ParseException ex) {
                Logger.getLogger(RoomUtilization.class.getName()).log(Level.SEVERE, null, ex);
                jButton1.setText("Print");
                jButton1.setEnabled(true);
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.onScreen();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void roomCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomCbActionPerformed
        // TODO add your handling code here:
        ComboItem selected = (ComboItem) roomCb.getSelectedItem();
        model.setRowCount(0);
        if (selected.getValue() > 0) {
            Rooms room = (Rooms) this.room.find(selected.getValue());
            Object row[] = new Object[5];
            List<TeachersLoadingDetails> tableData;
            tableData = this.loadingDetail.getByRoom(room);
            for (TeachersLoadingDetails detail : tableData) {
                if (detail.getTeachersLoadings().getSchoolYears().isActived()) {
                    row[0] = detail.getHourStart() + " - " + detail.getHourEnd();
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
                    row[2] = detail.getTeachersLoadings().getFaculties().getFullname();
                    row[3] = detail.getTeachersLoadings().getSubjects().getCode();
                    String crs = "";
                    for (LoadCourses lc : detail.getLoadCourseses()) {
                        crs = crs + "/" + lc.getCourses().getCode();
                    }
                    crs = StringUtils.removeEnd(crs, "/");
                    crs = StringUtils.removeStart(crs, "/");
                    row[4] = crs;

                    model.addRow(row);
                }

            }

        }
    }//GEN-LAST:event_roomCbActionPerformed

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
            java.util.logging.Logger.getLogger(RoomUtilization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomUtilization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomUtilization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomUtilization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomUtilization().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> roomCb;
    private java.awt.Scrollbar scrollbar1;
    private javax.swing.JTable utilizeRoomTable;
    // End of variables declaration//GEN-END:variables
}
