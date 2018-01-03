/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import com.bisu.dao.Course;
import com.bisu.dao.Subject;
import com.bisu.entities.Courses;
import com.bisu.entities.Subjects;
import com.bisu.extras.Helper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANGGIE
 */
public class SubjectMaster extends javax.swing.JFrame {

    /**
     * Creates new form SubjectMaster
     */
    private Subject subject;
    private Course course;
    DefaultTableModel model;
    JPopupMenu popupMenu;
    public SubjectMaster() {
        initComponents();
        subject = new Subject();
        course = new Course();
        popupMenu = new JPopupMenu();
        model = (DefaultTableModel) subjectsTable.getModel();
        JMenuItem menuItemEdit = new JMenuItem("Edit");
        JMenuItem menuItemDelete = new JMenuItem("Delete");
        menuItemEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                //String id = courseTable.getValueAt(courseTable.getSelectedRow(), 3).toString();
               // populate_inputs(Integer.parseInt(id));
                save.setEnabled(true);
                nav_pane.setSelectedIndex(0);

            }
        });
         menuItemDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

               // String id = courseTable.getValueAt(courseTable.getSelectedRow(), 3).toString();
               // populate_inputs(Integer.parseInt(id));
                nav_pane.setEnabledAt(0, true);
                nav_pane.setSelectedIndex(0);
               // delete.setEnabled(true);
            }
        });
        popupMenu.add(menuItemEdit);
        popupMenu.add(menuItemDelete);
        nav_pane.setSelectedIndex(1);
    }

    private List comboSemItems(){

       List<ComboItem> combo = new ArrayList<ComboItem>();
       combo.add(new ComboItem(0,"Select Semester"));
       combo.add(new ComboItem(1,"First Semester"));
       combo.add(new ComboItem(2,"Second Semester"));


       return combo;
    }

    private List comboYearItems(){

       List<ComboItem> combo = new ArrayList<ComboItem>();
       combo.add(new ComboItem(0,"Select Year"));
       combo.add(new ComboItem(1,"First Year"));
       combo.add(new ComboItem(2,"Second Year"));
       combo.add(new ComboItem(3,"Third Year"));
       combo.add(new ComboItem(4,"Fourth Year"));
       combo.add(new ComboItem(5,"Fifth Year"));




       return combo;
    }

     private List comboItems(){

       List<ComboItem> combo = new ArrayList<ComboItem>();
       combo.add(new ComboItem(0,"Select Course"));

       try{
           for(Object obj: course.all()){
           Courses model = (Courses) obj;
           combo.add(new ComboItem(model.getId(),model.getCode()));
       }
       }
       catch(Exception e){

       }


       return combo;
    }

     private List comboSubjectItems(){

       List<ComboItem> combo = new ArrayList<ComboItem>();
       combo.add(new ComboItem(0,"Select Subject"));

       try{
           for(Object obj: subject.all()){
           Subjects model = (Subjects) obj;
           combo.add(new ComboItem(model.getId(),model.getCode()));
       }
       }
       catch(Exception e){

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

        typeGroup = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        nav_pane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectsTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        units = new javax.swing.JTextField();
        coursetItems = new javax.swing.JComboBox<>();
        major = new javax.swing.JRadioButton();
        gen_ed = new javax.swing.JRadioButton();
        elective = new javax.swing.JRadioButton();
        lec_hr = new javax.swing.JTextField();
        lab_hr = new javax.swing.JTextField();
        hiddenID = new javax.swing.JLabel();
        subjectItems = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        yearCB = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        semCb = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");

        jButton5.setText("Cancel");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(save)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        nav_pane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nav_paneStateChanged(evt);
            }
        });
        nav_pane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nav_paneMouseReleased(evt);
            }
        });

        subjectsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Description", "Course", "Type", "Units", "Lecture Hrs", "Laboratory Hrs", "Pre-Requisite", "ID"
            }
        ));
        subjectsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                subjectsTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(subjectsTable);
        if (subjectsTable.getColumnModel().getColumnCount() > 0) {
            subjectsTable.getColumnModel().getColumn(8).setPreferredWidth(0);
            subjectsTable.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1241, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        nav_pane.addTab("List", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Subject Information"));

        jLabel1.setText("Subject Code:");
        jPanel1.add(jLabel1);

        jLabel2.setText("Description");
        jPanel1.add(jLabel2);

        jLabel3.setText("Course");
        jPanel1.add(jLabel3);

        jLabel4.setText("Units:");
        jPanel1.add(jLabel4);

        jLabel5.setText("Lecture Hours:");
        jPanel1.add(jLabel5);

        jLabel6.setText("Laboratory Hours:");
        jPanel1.add(jLabel6);

        jLabel7.setText("Subject Type:");
        jPanel1.add(jLabel7);

        jLabel8.setText("Pre-requisite Subject:");
        jPanel1.add(jLabel8);
        jPanel1.add(code);
        jPanel1.add(description);

        units.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitsActionPerformed(evt);
            }
        });
        jPanel1.add(units);

        coursetItems.setModel(new javax.swing.DefaultComboBoxModel(comboItems().toArray()));
        coursetItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursetItemsActionPerformed(evt);
            }
        });
        jPanel1.add(coursetItems);

        typeGroup.add(major);
        major.setText("Major");
        major.setActionCommand("major");
        jPanel1.add(major);

        typeGroup.add(gen_ed);
        gen_ed.setText("General Education");
        gen_ed.setActionCommand("general");
        jPanel1.add(gen_ed);

        typeGroup.add(elective);
        elective.setText("Elective");
        elective.setActionCommand("elective");
        jPanel1.add(elective);
        jPanel1.add(lec_hr);
        jPanel1.add(lab_hr);

        hiddenID.setText("jLabel11");
        hiddenID.setVisible(false);
        jPanel1.add(hiddenID);

        subjectItems.setModel(new javax.swing.DefaultComboBoxModel(comboSubjectItems().toArray()));
        subjectItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectItemsActionPerformed(evt);
            }
        });
        jPanel1.add(subjectItems);

        jLabel9.setText("Year Level:");
        jPanel1.add(jLabel9);

        yearCB.setModel(new javax.swing.DefaultComboBoxModel(comboYearItems().toArray()));
        jPanel1.add(yearCB);

        jLabel10.setText("Course:");
        jPanel1.add(jLabel10);

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(comboItems().toArray()));
        jPanel1.add(jComboBox8);

        semCb.setModel(new javax.swing.DefaultComboBoxModel(comboSemItems().toArray()));
        jPanel1.add(semCb);

        jLabel11.setText("Semester:");
        jPanel1.add(jLabel11);

        nav_pane.addTab("Details", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nav_pane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nav_pane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populateTable() {
        List tableData;
        tableData = subject.all();

        Object row[] = new Object[9];
        model.setRowCount(0);
        for (int i = 0; i < tableData.size(); i++) {
            Subjects dept = (Subjects) tableData.get(i);
            row[0] = dept.getCode();
            row[1] = dept.getDescription();
            try {
               row[2] = dept.getCourses().getCode();
            }
            catch(Exception e){
                row[2] = "N/A";
            }
            try {
               row[7] = dept.getSubjects().getCode();
            }
            catch(Exception e){
                row[7] = "N/A";
            }
            row[3] = dept.getType();
            row[4] = dept.getUnits();
            row[5] = dept.getLecHours();
            row[6] = dept.getLabHours();

            row[8] = dept.getId();

            model.addRow(row);

        }

    }
    private void unitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitsActionPerformed

    private void coursetItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursetItemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coursetItemsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jButton1ActionPerformed

    private void subjectItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectItemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectItemsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        Subjects model;

        if(Helper.isNumeric(hiddenID.getText())){
            model = (Subjects) subject.find(Integer.parseInt(hiddenID.getText()));
        }
        else{
            model = new Subjects();
        }
        ComboItem selected_subject = (ComboItem) subjectItems.getSelectedItem();
        ComboItem selected_course = (ComboItem) coursetItems.getSelectedItem();
        Subjects pre_requisite = null;
        Courses course = null;
        if(selected_subject.getValue() != 0){
        pre_requisite = (Subjects) subject.find(selected_subject.getValue());
        }
        if(selected_course.getValue() != 0){
        course = (Courses) this.course.find(selected_subject.getValue());
        }
        model.setCode(code.getText());
        model.setDescription(description.getText());
        model.setLabHours(Integer.parseInt(lab_hr.getText()));
        model.setLecHours(Integer.parseInt(lec_hr.getText()));
        model.setSubjects(pre_requisite);
        model.setCourses(course);
        model.setUnits(Short.parseShort(units.getText()));
        model.setType(this.typeGroup.getSelection().getActionCommand());
        subject.save(model);
    }//GEN-LAST:event_saveActionPerformed

    private void nav_paneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_paneMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_nav_paneMouseReleased

    private void nav_paneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nav_paneStateChanged
        // TODO add your handling code here:
         if (evt.getSource() instanceof javax.swing.JTabbedPane) {
            javax.swing.JTabbedPane pane = (javax.swing.JTabbedPane) evt.getSource();
            if (pane.getSelectedIndex() == 1) {
                nav_pane.setEnabledAt(0, false);
                save.setEnabled(false);
               //edit.setEnabled(false);
               //delete.setEnabled(false);
               // cancel.setEnabled(false);
              // add.setEnabled(true);
                 this.clear();
                populateTable();
            }
        }
    }//GEN-LAST:event_nav_paneStateChanged

    private void subjectsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectsTableMouseReleased
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            JTable source = (JTable) evt.getSource();
            int row = source.rowAtPoint(evt.getPoint());
            int column = source.columnAtPoint(evt.getPoint());

            if (!source.isRowSelected(row)) {
                source.changeSelection(row, column, false, false);
            }
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }

    }//GEN-LAST:event_subjectsTableMouseReleased

    private void clear(){
       code.setText("");
        description.setText("");
        lab_hr.setText("1");
        lec_hr.setText("1");
        units.setText("1");


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
            java.util.logging.Logger.getLogger(SubjectMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubjectMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField code;
    private javax.swing.JComboBox<String> coursetItems;
    private javax.swing.JTextField description;
    private javax.swing.JRadioButton elective;
    private javax.swing.JRadioButton gen_ed;
    private javax.swing.JLabel hiddenID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lab_hr;
    private javax.swing.JTextField lec_hr;
    private javax.swing.JRadioButton major;
    private javax.swing.JTabbedPane nav_pane;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> semCb;
    private javax.swing.JComboBox<String> subjectItems;
    private javax.swing.JTable subjectsTable;
    private javax.swing.ButtonGroup typeGroup;
    private javax.swing.JTextField units;
    private javax.swing.JComboBox<String> yearCB;
    // End of variables declaration//GEN-END:variables
}
