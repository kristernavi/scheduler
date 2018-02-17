/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import com.bisu.entities.Users;
import com.bisu.extras.Helper;
import javax.swing.JFrame;

/**
 *
 * @author ANGGIE
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MAINMENU
     */
    DepartmentMaster departmentMaster;
    ClassProgram classProgram ;
    CourseMaster courseMaster;
    FacultyMaster facultyMaster;
    RoomMaster roomMaster;
    SchoolYear schoolYear;
    SubjectMaster subjectMaster;
    TeachersLoad load;
    TeachersLoading loading;
    RoomUtilization roomUtil;
    FacultyLoading facultyLoading;
    Login login;
    Users loginUser;
    ChangePassword changePassword;
   
    public MainMenu() {
        initComponents();
        roomUtil = new RoomUtilization(this);
        roomUtil.setVisible(false);
        
        departmentMaster =  new DepartmentMaster(this);
        departmentMaster.setVisible(false);
        
        
        classProgram = new ClassProgram(this);
        classProgram.setVisible(false);
        
        courseMaster = new CourseMaster(this);
        this.courseMaster.setVisible(false);
        
        this.facultyMaster = new FacultyMaster(this);
        this.facultyMaster.setVisible(false);
        
        this.roomMaster = new RoomMaster(this);
        this.roomMaster.setVisible(false);
        
        
        
        this.schoolYear = new SchoolYear(this);
        this.schoolYear.setVisible(false);
        
        this.subjectMaster = new SubjectMaster(this);
        this.subjectMaster.setVisible(false);
        
        this.load = new TeachersLoad(this);
        this.load.setVisible(false);
        
        this.loading = new TeachersLoading(this);
        this.loading.setVisible(false);
        this.facultyLoading = new FacultyLoading(this);
        this.facultyLoading.setVisible(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
       
    }
    public MainMenu(Login login) {
        this();
        this.login = login;
        changePassword = new ChangePassword(this);
        this.changePassword.setVisible(false);
        
    }
    
    public void setUserLogin(Users users){
        this.loginUser = users;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        department = new javax.swing.JMenuItem();
        course = new javax.swing.JMenuItem();
        subject = new javax.swing.JMenuItem();
        faculty = new javax.swing.JMenuItem();
        room = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        f_load = new javax.swing.JMenuItem();
        t_load = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        class_program = new javax.swing.JMenuItem();
        room_util = new javax.swing.JMenuItem();
        t_loading = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        sy = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BISU-Balilihan Class Scheduler");
        setMinimumSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(null);

        jLabel1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/MAin.png"))); // NOI18N
        jLabel1.setEnabled(false);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1580, 760);

        jMenuBar1.setBackground(new java.awt.Color(0, 102, 204));

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jMenuItem2.setText("Profile");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Logout");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Management");
        jMenu2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jMenu10.setText("Master Files");
        jMenu10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        department.setText("Department Master");
        department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentActionPerformed(evt);
            }
        });
        jMenu10.add(department);

        course.setText("Course Master");
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        jMenu10.add(course);

        subject.setText("Subject Master");
        subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectActionPerformed(evt);
            }
        });
        jMenu10.add(subject);

        faculty.setText("Faculty Master");
        faculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyActionPerformed(evt);
            }
        });
        jMenu10.add(faculty);

        room.setText("Room Master");
        room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomActionPerformed(evt);
            }
        });
        jMenu10.add(room);

        jMenu2.add(jMenu10);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Transactions");
        jMenu3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        f_load.setText("Faculty Loading");
        f_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_loadActionPerformed(evt);
            }
        });
        jMenu3.add(f_load);

        t_load.setText("Teachers Loading");
        t_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_loadActionPerformed(evt);
            }
        });
        jMenu3.add(t_load);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reports");
        jMenu4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        class_program.setText("Class Program");
        class_program.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class_programActionPerformed(evt);
            }
        });
        jMenu4.add(class_program);

        room_util.setText("Room Utilization");
        room_util.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room_utilActionPerformed(evt);
            }
        });
        jMenu4.add(room_util);

        t_loading.setText("Teachers Load");
        t_loading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_loadingActionPerformed(evt);
            }
        });
        jMenu4.add(t_loading);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("School Year");
        jMenu5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        sy.setText("Activation of Inactive");
        sy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syActionPerformed(evt);
            }
        });
        jMenu5.add(sy);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Account");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Change Password");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(Helper.confirmationMessage()){
            this.setVisible(false);
            this.login.clear();
            this.login.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        // TODO add your handling code here:
        courseMaster.setVisible(true);
        courseMaster.offScreen();
    }//GEN-LAST:event_courseActionPerformed

    private void departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentActionPerformed
        // TODO add your handling code here:
        departmentMaster.setVisible(true);
        departmentMaster.offScreen();
    }//GEN-LAST:event_departmentActionPerformed

    private void subjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectActionPerformed
        // TODO add your handling code here:
        this.subjectMaster.setVisible(true);
        this.subjectMaster.offScreen();
    }//GEN-LAST:event_subjectActionPerformed

    private void facultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyActionPerformed
        // TODO add your handling code here:
        this.facultyMaster.setVisible(true);
        this.facultyMaster.offScreen();
    }//GEN-LAST:event_facultyActionPerformed

    private void roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomActionPerformed
        // TODO add your handling code here:
        this.roomMaster.setVisible(true);
        this.roomMaster.offScreen();
    }//GEN-LAST:event_roomActionPerformed

    private void t_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_loadActionPerformed
        // TODO add your handling code here:
        this.loading.setVisible(true);
        this.loading.offScreen();
        
    }//GEN-LAST:event_t_loadActionPerformed

    private void t_loadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_loadingActionPerformed
        // TODO add your handling code here:
        this.load.setVisible(true);
        this.load.offScreen();
    }//GEN-LAST:event_t_loadingActionPerformed

    private void class_programActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_programActionPerformed
        // TODO add your handling code here:
        this.classProgram.setVisible(true);
        this.classProgram.offScreen();
    }//GEN-LAST:event_class_programActionPerformed

    private void syActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syActionPerformed
        // TODO add your handling code here:
        this.schoolYear.setVisible(true);
        this.schoolYear.offScreen();
    }//GEN-LAST:event_syActionPerformed

    private void room_utilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_utilActionPerformed
        // TODO add your handling code here:
        this.roomUtil.setVisible(true);
        this.roomUtil.offScreen();
    }//GEN-LAST:event_room_utilActionPerformed

    private void f_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_loadActionPerformed
        // TODO add your handling code here:
        this.facultyLoading.setVisible(true);
        this.facultyLoading.offScreen();
    }//GEN-LAST:event_f_loadActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        this.changePassword.setUserLoggin(loginUser);
        this.changePassword.setVisible(true);
        this.changePassword.offScreen();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem class_program;
    private javax.swing.JMenuItem course;
    private javax.swing.JMenuItem department;
    private javax.swing.JMenuItem f_load;
    private javax.swing.JMenuItem faculty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem room;
    private javax.swing.JMenuItem room_util;
    private javax.swing.JMenuItem subject;
    private javax.swing.JMenuItem sy;
    private javax.swing.JMenuItem t_load;
    private javax.swing.JMenuItem t_loading;
    // End of variables declaration//GEN-END:variables
}
