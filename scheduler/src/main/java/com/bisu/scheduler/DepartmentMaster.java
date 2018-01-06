/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import com.bisu.dao.Department;
import com.bisu.entities.Departments;
import com.bisu.extras.Helper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author ANGGIE
 */
public class DepartmentMaster extends javax.swing.JFrame {

    Department department;
    DefaultTableModel model;
    JPopupMenu popupMenu;
    MainMenu mainMenu;
    
    
    public DepartmentMaster() {
        department = new Department();

        initComponents();
        popupMenu = new JPopupMenu();
        JMenuItem menuItemEdit = new JMenuItem("Edit");
        JMenuItem menuItemDelete = new JMenuItem("Delete");
        this.delete.setEnabled(false);
        this.cancel.setEnabled(false);
        this.save.setEnabled(false);
        pane_nav.setEnabledAt(0, false);
        menuItemEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                String id = department_table.getValueAt(department_table.getSelectedRow(), 3).toString();
                populate_input(Integer.parseInt(id));
                pane_nav.setSelectedIndex(0);
                save.setEnabled(true);
                edit.setEnabled(true);
                cancel.setEnabled(true);
                add.setEnabled(false);
            }
        });
        menuItemDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                String id = department_table.getValueAt(department_table.getSelectedRow(), 3).toString();
                populate_input(Integer.parseInt(id));
                pane_nav.setEnabledAt(0, true);
                pane_nav.setSelectedIndex(0);
                delete.setEnabled(true);
            }
        });

        popupMenu.add(menuItemEdit);
        popupMenu.add(menuItemDelete);

        model = (DefaultTableModel) department_table.getModel();
        pane_nav.setSelectedIndex(1);

    }

    public DepartmentMaster(MainMenu mainMenu) {
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
    protected void populate_input(int id) {

        Departments entity = (Departments) department.find(id);
        hiddenID.setText(entity.getId().toString());
        description.setText(entity.getDescription());
        head.setText(entity.getHead());
        code.setText(entity.getCode());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pane_nav = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        head = new javax.swing.JTextField();
        hiddenID = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        department_table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Department Master");

        pane_nav.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pane_navStateChanged(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Department Information"));

        jLabel1.setText("Department Code:");

        jLabel2.setText("Description:");

        jLabel3.setText("Department Head:");

        code.setEnabled(true);

        hiddenID.setText("hiddenID");
        hiddenID.setVisible(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(head, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(hiddenID)))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(code)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(description))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(head, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(hiddenID)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pane_nav.addTab("Details", jPanel2);

        department_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Description", "Head", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        department_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                department_tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(department_table);
        if (department_table.getColumnModel().getColumnCount() > 0) {
            department_table.getColumnModel().getColumn(3).setMinWidth(0);
            department_table.getColumnModel().getColumn(3).setPreferredWidth(0);
            department_table.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pane_nav.addTab("List", jPanel3);

        add.setText("New");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        jButton1.setText("Back to Main Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edit)
                .addGap(5, 5, 5)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel)
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(save)
                    .addComponent(delete)
                    .addComponent(cancel)
                    .addComponent(edit)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pane_nav)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pane_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void populateTable() {
        List tableData;
        tableData = department.all();

        Object row[] = new Object[4];
        model.setRowCount(0);
        for (int i = 0; i < tableData.size(); i++) {
            Departments dept = (Departments) tableData.get(i);
            row[0] = dept.getCode();
            row[1] = dept.getDescription();
            row[2] = dept.getHead();
            row[3] = dept.getId();
            model.addRow(row);

        }

    }

    private void clear() {
        code.setText("");
        description.setText("");
        head.setText("");
        hiddenID.setText("");

    }


    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        Departments entity;
        boolean clearable = false;

        if (Helper.isNumeric(hiddenID.getText())) {

            int id = Integer.parseInt(hiddenID.getText());
            entity = (Departments) department.find(id);

        } else {
            entity = new Departments();
            clearable = true;
        }

        entity.setDescription(description.getText());
        entity.setHead(head.getText());
        entity.setCode(code.getText());
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();

        //...
        Set<ConstraintViolation<Departments>> constraintViolations = validator.validate(entity);
        //System.out.println(constraintViolations);
        if (!constraintViolations.isEmpty()) {
            String msg = "";
            for (ConstraintViolation<Departments> constraintViolation : constraintViolations) {
                String name = constraintViolation.getPropertyPath().toString();
                name = name.substring(0, 1).toUpperCase()+name.substring(1);
                msg += name + " " + constraintViolation.getMessage() + "\n";
                
            }
            

            Helper.errorMessage(msg, "Error");
        } else {
            try {
                if (clearable) {
                    department.save(entity);
                    Helper.messageBox("Record Succefully Save", "Processing Complete");
                } else {

                    if (Helper.messageBox("Are you want to edit the record?", "Confirmation", true)) {
                        department.save(entity);
                        Helper.messageBox("Record Succefully Save", "Processing Complete");
                    }

                }
            } catch (Exception ex) {
                Helper.errorMessage("Code must be unique", "Error");
                clearable = false;
            } finally{
                if(clearable){
                this.clear();
                }
                Helper.closeSession();
            }

        }

    }//GEN-LAST:event_saveActionPerformed

    private void pane_navStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pane_navStateChanged
        if (evt.getSource() instanceof javax.swing.JTabbedPane) {
            javax.swing.JTabbedPane pane = (javax.swing.JTabbedPane) evt.getSource();
            if (pane.getSelectedIndex() == 1) {
                pane_nav.setEnabledAt(0, false);
                save.setEnabled(false);
                edit.setEnabled(false);
                delete.setEnabled(false);
                cancel.setEnabled(false);
                add.setEnabled(true);
                this.clear();
                populateTable();
            }
        }
    }//GEN-LAST:event_pane_navStateChanged

    private void department_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_department_tableMouseReleased
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

    }//GEN-LAST:event_department_tableMouseReleased

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        this.clear();
        pane_nav.setEnabledAt(0, false);
        pane_nav.setSelectedIndex(1);
    }//GEN-LAST:event_cancelActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        this.clear();
        save.setEnabled(true);
        pane_nav.setEnabledAt(0, true);
        pane_nav.setSelectedIndex(0);
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:

        Departments entity;
        int id = Integer.parseInt(hiddenID.getText());
        entity = (Departments) department.find(id);

        if (Helper.messageBox("Are you want to delete the record?", "Confirmation", true)) {
            department.delete(entity);
            Helper.messageBox("Record Succefully Deleted", "Processing Complete");
            pane_nav.setSelectedIndex(1);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.onScreen();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DepartmentMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartmentMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartmentMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartmentMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField code;
    private javax.swing.JButton delete;
    private javax.swing.JTable department_table;
    private javax.swing.JTextField description;
    private javax.swing.JButton edit;
    private javax.swing.JTextField head;
    private javax.swing.JLabel hiddenID;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane pane_nav;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
