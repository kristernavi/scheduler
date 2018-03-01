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
import com.bisu.dao.SchoolYear;
import com.bisu.entities.Courses;
import com.bisu.entities.Faculties;
import com.bisu.entities.SchoolYears;
import com.bisu.entities.Subjects;
import com.bisu.entities.TeachersLoadings;
import com.bisu.extras.Helper;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANGGIE
 */
public class FacultyLoading extends javax.swing.JFrame {

    /**
     * Creates new form FacultyLoading
     */
    MainMenu mainMenu;
    Course course;
    Teacher teacher;
    Subject subject;
    SubjectCourse sc;
    DefaultTableModel model;
    Loading teacherLoading;
    SchoolYear schoolYear;

    public FacultyLoading() {
        course = new Course();
        teacher = new Teacher();
        subject = new Subject();
        sc = new SubjectCourse();
        teacherLoading = new Loading();
        schoolYear = new SchoolYear();
        initComponents();
        opening();
        model = (DefaultTableModel) loadingTable.getModel();
          setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public void offScreen() {
        this.mainMenu.setVisible(false);
        opening();

    }

    public void onScreen() {
        this.mainMenu.setVisible(true);
        this.setVisible(false);
    }

    public FacultyLoading(MainMenu mainMenu) {
        this();
        this.mainMenu = mainMenu;
        int op = this.getDefaultCloseOperation(); // HIDE_ON_CLOSE
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
      

    }
    
    private void opening(){
        
        Integer semester = Integer.parseInt(""+this.schoolYear.getActive().getSemester());
    
       if(1 == semester){
           semLbl.setText("First Semester");
       }
       else if(2 == semester){
           semLbl.setText("Second Semester");
       }
       else{
            semLbl.setText("No Year Selected");
           
       }
    }

    private List comboSubjectItem(Integer year_level, Integer semester, Integer course) {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Subject"));
        Courses courseModel = (Courses) this.course.find(course);
        List<Integer> ids = sc.getByCourse(courseModel);
        List subject = null;
        if (ids.size() > 0) {
            subject = this.subject.loading_course(year_level, semester, ids);
        }

        try {

            for (Object obj : subject) {
                Subjects model = (Subjects) obj;
                combo.add(new ComboItem(model.getId(), model.getCode() + " - " + model.getDescription()));
            }
        } catch (Exception e) {

        }

        return combo;
    }

    private List comboSemItems() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Semester"));
        combo.add(new ComboItem(1, "First Semester"));
        combo.add(new ComboItem(2, "Second Semester"));

        return combo;
    }

    private List comboYearItems() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Year"));
        combo.add(new ComboItem(1, "First Year"));
        combo.add(new ComboItem(2, "Second Year"));
        combo.add(new ComboItem(3, "Third Year"));
        combo.add(new ComboItem(4, "Fourth Year"));

        return combo;
    }

    private List comboCourseItem() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Course"));

        try {
            for (Object obj : course.all()) {
                Courses model = (Courses) obj;
                combo.add(new ComboItem(model.getId(), "" + model.getCode()));
            }
        } catch (Exception e) {

        }

        return combo;
    }

    private void subject_populate() {
        ComboItem year_level = (ComboItem) year_levelCb.getSelectedItem();
        Integer semester = Integer.parseInt(""+this.schoolYear.getActive().getSemester());
        ComboItem course = (ComboItem) courseCb.getSelectedItem();

        if (year_level.getValue() > 0 && course.getValue() > 0) {
            subjectCb.setModel(new javax.swing.DefaultComboBoxModel(comboSubjectItem(year_level.getValue(),semester, course.getValue()).toArray()));

        }
    }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        year_levelCb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        courseCb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        subjectCb = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        instructorCb = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        loadingTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        overloadLbl = new javax.swing.JLabel();
        loadLbl = new javax.swing.JLabel();
        deloadLbl = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tLoadLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        loadsLbl = new javax.swing.JLabel();
        semLbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        timeTb = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teachers Load");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Cancel");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Year Level:");

        year_levelCb.setModel(new javax.swing.DefaultComboBoxModel(comboYearItems().toArray()));
        year_levelCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_levelCbActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Course:");

        courseCb.setModel(new javax.swing.DefaultComboBoxModel(comboCourseItem().toArray()));
        courseCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCbActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Semester:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Subject Code:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Instructor:");

        instructorCb.setModel(new javax.swing.DefaultComboBoxModel(comboTeacherItem().toArray()));
        instructorCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorCbActionPerformed(evt);
            }
        });

        loadingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "Load", "Lec Hours", "Lab Hours", "Actions", "id", "subject_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loadingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadingTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(loadingTable);
        if (loadingTable.getColumnModel().getColumnCount() > 0) {
            loadingTable.getColumnModel().getColumn(5).setMinWidth(0);
            loadingTable.getColumnModel().getColumn(5).setPreferredWidth(0);
            loadingTable.getColumnModel().getColumn(5).setMaxWidth(0);
            loadingTable.getColumnModel().getColumn(6).setMinWidth(0);
            loadingTable.getColumnModel().getColumn(6).setPreferredWidth(0);
            loadingTable.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Load");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Deloading");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Overload");

        overloadLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        overloadLbl.setText("0");

        loadLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loadLbl.setText("0");

        deloadLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deloadLbl.setText("0");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Total Units");

        tLoadLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tLoadLbl.setText("0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Teacher Load");

        loadsLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loadsLbl.setText("0");

        semLbl.setText("jLabel11");

        jLabel11.setText("Times:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(subjectCb, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                        .addComponent(courseCb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(instructorCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(year_levelCb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(semLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeTb, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deloadLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overloadLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loadsLbl)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(30, 30, 30)
                .addComponent(tLoadLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(overloadLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deloadLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(tLoadLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(loadsLbl))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(semLbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(year_levelCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(courseCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(subjectCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(instructorCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(timeTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Teachers Loading");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void clear() {
        this.year_levelCb.setSelectedIndex(0);
        this.courseCb.setSelectedIndex(0);
        this.subjectCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        this.instructorCb.setSelectedIndex(0);
        this.model.setRowCount(0);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.clear();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            ComboItem faculty_item = (ComboItem) instructorCb.getSelectedItem();
            ComboItem subject_item = (ComboItem) subjectCb.getSelectedItem();

            System.err.println("" + subjectCb.getSelectedItem());
            SchoolYears sy = (SchoolYears) schoolYear.getActive();
            if (faculty_item.getValue() == 0) {
                throw new Exception("Must select an instructor");
            }
            if (subject_item.getValue() == 0 || subjectCb.getSelectedItem() == null) {
                throw new Exception("Must select a subject");
            }
            Subjects sub = (Subjects) subject.find(subject_item.getValue());
            Faculties faculties = (Faculties) teacher.find(faculty_item.getValue());
            Integer currentLoad = Integer.parseInt(loadsLbl.getText());
            Integer subjectUnit = sub.getLecHours() + sub.getLabHours();
            Integer maxload = (faculties.getRegularLoad() - faculties.getDeloading()) + faculties.getOverload();
            Integer loadAdded = currentLoad + subjectUnit;
            
            Integer units = Integer.parseInt(tLoadLbl.getText());

            if (maxload < loadAdded) {
                throw new Exception("Unable to add subject due to the hours exceed to the max limit");
            }
            for (int index = 0; index < loadingTable.getRowCount(); index++) {
                int sub_id = Integer.parseInt(loadingTable.getValueAt(index, 6).toString());
                if (subject_item.getValue() == sub_id) {
                    throw new Exception("Subject already exisit");
                }
            }

            Integer overload = (faculties.getRegularLoad() - faculties.getDeloading()) - loadAdded;
            Integer over = overload < 0 ? (overload * -1) : 0;

            TeachersLoadings loadings = new TeachersLoadings();
            loadings.setSchoolYears(sy);
            loadings.setFaculties(faculties);
            loadings.setSubjects(sub);
            loadings.setTimes(Integer.parseInt(timeTb.getText()));
            overloadLbl.setText("" + over);
            teacherLoading.save(loadings);
            loadsLbl.setText(""+loadAdded);
            
            Integer unit_added =  sub.getLecHours() + (sub.getLabHours() /3);
            units = units + sub.getLecHours() + (sub.getLabHours() /3);
            tLoadLbl.setText("" + units);
            Object row[] = new Object[7];
            Integer unit = sub.getLecHours() + (sub.getLabHours() / 3);
            row[0] = sub.getCode();
            row[1] = unit;
            row[2] = sub.getLecHours();
            row[3] = sub.getLabHours();
            row[4] = "Delete";
            row[5] = loadings.getId();
            row[6] = sub.getId();
            model.addRow(row);

            Helper.successMessage();
        } catch (Exception e) {

            Helper.closeSession();
            Helper.errorMessage(e.getMessage(), "Whoopss!");

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.onScreen();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void year_levelCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_levelCbActionPerformed
        // TODO add your handling code here:
        subject_populate();

    }//GEN-LAST:event_year_levelCbActionPerformed

    private void courseCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCbActionPerformed
        // TODO add your handling code here:
        subject_populate();

    }//GEN-LAST:event_courseCbActionPerformed

    private void instructorCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorCbActionPerformed
        // TODO add your handling code here:
        ComboItem item = (ComboItem) instructorCb.getSelectedItem();
        model.setRowCount(0);
        if (item.getValue() > 0) {
            Faculties faculty = (Faculties) teacher.find(item.getValue());
            Object row[] = new Object[7];
            Integer lecHrs = 0;
            Integer labHrs = 0;
            Integer units = 0;
            for (TeachersLoadings loadings : faculty.getTeachersLoadingses()) {
                if (loadings.getSchoolYears().isActived()) {
                    Subjects sub = loadings.getSubjects();
                    Integer unit = sub.getLecHours() + (sub.getLabHours() / 3);

                    lecHrs += sub.getLecHours() * loadings.getTimes();
                    labHrs += sub.getLabHours() * loadings.getTimes();
                    row[0] = sub.getCode();
                    row[1] = unit;
                    row[2] = sub.getLecHours() * loadings.getTimes();
                    row[3] = sub.getLabHours() * loadings.getTimes();
                    row[4] = "Delete";
                    row[5] = loadings.getId();
                    row[6] = sub.getId();
                    model.addRow(row);
                }
            }
            units += lecHrs;
            units += (labHrs / 3);
            Integer overload = (faculty.getRegularLoad() - faculty.getDeloading()) - (lecHrs + labHrs);
            Integer over = overload < 0 ? overload * -1 : 0;
            loadLbl.setText("" + faculty.getRegularLoad());
            deloadLbl.setText("" + faculty.getDeloading());
            overloadLbl.setText("" + over);
            tLoadLbl.setText("" + units);
            loadsLbl.setText("" + (lecHrs + labHrs));

        }
    }//GEN-LAST:event_instructorCbActionPerformed

    private void loadingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadingTableMouseClicked
        // TODO add your handling code here:
        int row = loadingTable.rowAtPoint(evt.getPoint());
        int col = loadingTable.columnAtPoint(evt.getPoint());
        Integer currentLoad = Integer.parseInt(tLoadLbl.getText());
        Integer overload = Integer.parseInt(overloadLbl.getText());
        Integer t_load = Integer.parseInt(loadsLbl.getText());
        if (row >= 0 && col >= 4) {
            if (Helper.confirmationMessage()) {
                try {

                    Integer id = Integer.parseInt(loadingTable.getValueAt(row, 5).toString());
                    TeachersLoadings tl = (TeachersLoadings) this.teacherLoading.find(id);
                    Integer subtracted = tl.getSubjects().getLecHours() + tl.getSubjects().getLabHours();
                    currentLoad = currentLoad - (tl.getSubjects().getLecHours() + (tl.getSubjects().getLabHours()/3));
                    if(overload > 0 ){
                    overload = overload - subtracted;
                    }
                    if(overload < 0){
                     overload = 0;
                    }
                    t_load = t_load - (tl.getSubjects().getLecHours() + tl.getSubjects().getLabHours());
                    this.teacherLoading.delete(tl);
                    model.removeRow(row);
                    overloadLbl.setText(""+overload);
                    tLoadLbl.setText("" + currentLoad);
                    loadsLbl.setText(""+t_load);
                } catch (Exception ex) {
                    Helper.errorMessage("This might have a schedule already", "Whoppps!");
                    Helper.closeSession();
                }
            }
        }
    }//GEN-LAST:event_loadingTableMouseClicked

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
            java.util.logging.Logger.getLogger(FacultyLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacultyLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacultyLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacultyLoading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> courseCb;
    private javax.swing.JLabel deloadLbl;
    private javax.swing.JComboBox<String> instructorCb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loadLbl;
    private javax.swing.JTable loadingTable;
    private javax.swing.JLabel loadsLbl;
    private javax.swing.JLabel overloadLbl;
    private javax.swing.JLabel semLbl;
    private javax.swing.JComboBox<String> subjectCb;
    private javax.swing.JLabel tLoadLbl;
    private javax.swing.JTextField timeTb;
    private javax.swing.JComboBox<String> year_levelCb;
    // End of variables declaration//GEN-END:variables
}
