/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import com.bisu.dao.Room;
import com.bisu.entities.Departments;
import com.bisu.entities.Rooms;
import com.bisu.extras.Helper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.JMenuItem;
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
public class RoomMaster extends javax.swing.JFrame {

    /**
     * Creates new form RoomMaster
     */
    protected Room room;
    DefaultTableModel model;

    MainMenu mainMenu;
    
    public RoomMaster(MainMenu mainMenu) {
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
    
    public RoomMaster() {
        room = new Room();
        initComponents();
        hidden_id.setVisible(false);
        lec_radio.setActionCommand("lecture");
        lab_radio.setActionCommand("laboratory");
        lec_lab_radio.setActionCommand("lec_lab");
        this.model = (DefaultTableModel) room_table.getModel();
        room_table.getColumnModel().getColumn(5).setWidth(0);
        room_table.getColumnModel().getColumn(5).setMinWidth(0);
        room_table.getColumnModel().getColumn(5).setMaxWidth(0);

        JMenuItem menuItemEdit = new JMenuItem("Edit");
        JMenuItem menuItemDelete = new JMenuItem("Delete");
        menuItemEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                String id = room_table.getValueAt(room_table.getSelectedRow(), 5).toString();
                populate_inputs(Integer.parseInt(id));
                nav_pane.setSelectedIndex(0);
                save.setEnabled(true);

            }
        });
        menuItemDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                String id = room_table.getValueAt(room_table.getSelectedRow(), 0).toString();
                populate_inputs(Integer.parseInt(id));
                nav_pane.setEnabledAt(0, true);
                nav_pane.setSelectedIndex(0);
                delete.setEnabled(true);
            }
        });
        popupMenu.add(menuItemEdit);
        popupMenu.add(menuItemDelete);
        nav_pane.setSelectedIndex(1);

    }

    private void populate_inputs(Integer id) {
        Rooms room = (Rooms) this.room.find(id);
        description.setText(room.getDescription());
        location.setText(room.getLocation());
        room_id.setText("" + room.getNumber());
        capacity.setText("" + room.getCapacity());
        hidden_id.setText("" + room.getId());
        System.out.println("" + hidden_id.getText());
        if (room.getType().equals("lecture")) {
            lec_radio.setSelected(true);
        } else if (room.getType().equals("laboratory")) {
            lab_radio.setSelected(true);
        } else {
            lec_lab_radio.setSelected(true);
        }

    }

    private void clear() {

        description.setText("");
        location.setText("");
        room_id.setText("");
        capacity.setText("");
        hidden_id.setText("");
        lec_radio.setSelected(false);
        lab_radio.setSelected(false);
        lec_lab_radio.setSelected(false);

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
        popupMenu = new javax.swing.JPopupMenu();
        jPanel3 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        cancel1 = new javax.swing.JButton();
        nav_pane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lec_radio = new javax.swing.JRadioButton();
        lab_radio = new javax.swing.JRadioButton();
        lec_lab_radio = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        room_id = new javax.swing.JTextField();
        capacity = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        location = new javax.swing.JTextField();
        hidden_id = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        room_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Room Master");

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

        cancel1.setText("Back");
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add)
                .addGap(18, 18, 18)
                .addComponent(save)
                .addGap(13, 13, 13)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel)
                .addGap(18, 18, 18)
                .addComponent(cancel1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(save)
                    .addComponent(delete)
                    .addComponent(cancel)
                    .addComponent(cancel1))
                .addContainerGap())
        );

        nav_pane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nav_paneStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Room Information"));

        jLabel1.setText("Room No:");

        jLabel2.setText("Room Type:");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        typeGroup.add(lec_radio);
        lec_radio.setText("Lecture");

        typeGroup.add(lab_radio);
        lab_radio.setText("Laboratory");

        typeGroup.add(lec_lab_radio);
        lec_lab_radio.setText("Lecture with Laboratory");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lec_lab_radio)
                    .addComponent(lab_radio)
                    .addComponent(lec_radio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lec_radio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_radio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lec_lab_radio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Capacity:");

        jLabel4.setText("Description:");

        jLabel5.setText("Location:");

        hidden_id.setText("hidden");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(room_id, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(capacity, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(31, 31, 31)
                            .addComponent(location, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(description)))
                    .addComponent(hidden_id))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(room_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(capacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hidden_id)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        nav_pane.addTab("Details", jPanel1);

        room_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Number", "Description", "Location", "Type", "Capacity", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        room_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                room_tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(room_table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nav_pane.addTab("List", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nav_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nav_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        Rooms model;
        boolean clearable = false;
        if (Helper.isNumeric(hidden_id.getText())) {
            model = (Rooms) room.find(Integer.parseInt(hidden_id.getText()));

        } else {
            model = new Rooms();
            clearable = true;
        }
        Integer cap = 0;
        Integer num = 0;
        String type = "";
        if (Helper.isNumeric(capacity.getText()) && !capacity.getText().equals("")) {
            cap = Integer.parseInt(capacity.getText());

        } 
        if (Helper.isNumeric(room_id.getText()) && !room_id.getText().equals("")) {
            num = Integer.parseInt(room_id.getText());

        }
        if(typeGroup.getSelection() != null){
            type = typeGroup.getSelection().getActionCommand();
        }
        model.setCapacity(cap);
        model.setDescription(description.getText());
        model.setLocation(location.getText());
        model.setType(type);
        model.setNumber(num);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<Rooms>> constraintViolations = validator.validate(model);
        if (!constraintViolations.isEmpty()) {
            String msg = "";
            for (ConstraintViolation<Rooms> constraintViolation : constraintViolations) {
                String name = constraintViolation.getPropertyPath().toString();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                msg += name + " " + constraintViolation.getMessage() + "\n";

            }

            Helper.errorMessage(msg, "Error");
        } else {
            try {
                if (clearable) {
                    room.save(model);
                    Helper.messageBox("Record Succefully Save", "Processing Complete");
                } else {

                    if (Helper.messageBox("Are you want to edit the record?", "Confirmation", true)) {
                        room.save(model);
                        Helper.messageBox("Record Succefully Save", "Processing Complete");
                    }

                }
            } catch (Exception ex) {
                Helper.errorMessage("Room Number must be unique", "Error");
                clearable = false;
                Helper.closeSession();
            } finally {
                if (clearable) {
                    this.clear();
                }
            }
        }
    }//GEN-LAST:event_saveActionPerformed

    private void room_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_room_tableMouseReleased
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
    }//GEN-LAST:event_room_tableMouseReleased

    private void nav_paneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nav_paneStateChanged
        // TODO add your handling code here:
        if (evt.getSource() instanceof javax.swing.JTabbedPane) {
            javax.swing.JTabbedPane pane = (javax.swing.JTabbedPane) evt.getSource();
            if (pane.getSelectedIndex() == 1) {
                nav_pane.setEnabledAt(0, false);
                save.setEnabled(false);
                // edit.setEnabled(false);
                delete.setEnabled(false);
                cancel.setEnabled(false);
                add.setEnabled(true);
                this.clear();
                populate();
            }
        }
    }//GEN-LAST:event_nav_paneStateChanged

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:

        if (Helper.confirmationMessage()) {
            room.delete((Rooms) room.find(Integer.parseInt(hidden_id.getText())));
            Helper.deleteMessage();
            nav_pane.setSelectedIndex(1);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        this.clear();
        nav_pane.setSelectedIndex(0);
        save.setEnabled(true);
    }//GEN-LAST:event_addActionPerformed

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed
        // TODO add your handling code here:
        this.onScreen();
    }//GEN-LAST:event_cancel1ActionPerformed

    /**
     * @param args the command line arguments
     */
    private void populate() {

        List tableData;
        tableData = room.all();

        Object row[] = new Object[6];
        model.setRowCount(0);
        for (int i = 0; i < tableData.size(); i++) {
            Rooms room = (Rooms) tableData.get(i);
            row[0] = room.getNumber();
            row[1] = room.getDescription();
            row[2] = room.getLocation();
            row[3] = room.getType();
            row[4] = room.getCapacity();
            row[5] = room.getId();

            model.addRow(row);

        }

    }

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
            java.util.logging.Logger.getLogger(RoomMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton cancel1;
    private javax.swing.JTextField capacity;
    private javax.swing.JButton delete;
    private javax.swing.JTextField description;
    private javax.swing.JLabel hidden_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton lab_radio;
    private javax.swing.JRadioButton lec_lab_radio;
    private javax.swing.JRadioButton lec_radio;
    private javax.swing.JTextField location;
    private javax.swing.JTabbedPane nav_pane;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTextField room_id;
    private javax.swing.JTable room_table;
    private javax.swing.JButton save;
    private javax.swing.ButtonGroup typeGroup;
    // End of variables declaration//GEN-END:variables
}
