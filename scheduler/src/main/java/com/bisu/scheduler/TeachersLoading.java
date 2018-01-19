/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import com.bisu.dao.Course;
import com.bisu.dao.Loading;
import com.bisu.dao.LoadingDetail;
import com.bisu.dao.Room;
import com.bisu.dao.Subject;
import com.bisu.dao.Teacher;
import com.bisu.dao.SchoolYear;
import com.bisu.dao.SubjectCourse;
import com.bisu.entities.Courses;
import com.bisu.entities.Faculties;
import com.bisu.entities.Rooms;
import com.bisu.entities.Subjects;
import com.bisu.entities.TeachersLoadingDetails;
import com.bisu.entities.TeachersLoadings;
import com.bisu.extras.Helper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANGGIE
 */
public class TeachersLoading extends javax.swing.JFrame {

    /**
     * Creates new form TeachersLoading
     */
    DefaultTableModel model;
    Subject subject;
    Course course;
    Room room;
    Teacher teacher;
    Loading load;
    LoadingDetail loadDetail;
    SchoolYear schoolYear;
    MainMenu mainMenu;
    SubjectCourse sc;

    public TeachersLoading(MainMenu mainMenu) {
        this();
        this.mainMenu = mainMenu;
        int op = this.getDefaultCloseOperation(); // HIDE_ON_CLOSE
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

    }

    public void offScreen() {
        this.mainMenu.setVisible(false);
        instructorCb.setModel(new javax.swing.DefaultComboBoxModel(comboTeacherItem().toArray()));

    }

    public void onScreen() {
        this.mainMenu.setVisible(true);
        this.setVisible(false);
    }

    public TeachersLoading() {
        loadDetail = new LoadingDetail();
        schoolYear = new SchoolYear();
        course = new Course();
        subject = new Subject();
        sc = new SubjectCourse();
        room = new Room();
        load = new Loading();
        teacher = new Teacher();
        Date date = new Date();
        SpinnerDateModel sm2 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
        SpinnerDateModel sm1 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
        initComponents();
        end_timespinner.setModel(sm1);
        start_timespinner.setModel(sm2);
        JSpinner.DateEditor de = new JSpinner.DateEditor(end_timespinner, "hh:mm a");
        de.getTextField().setEditable(true);
        end_timespinner.setEditor(de);
        JSpinner.DateEditor de2 = new JSpinner.DateEditor(start_timespinner, "hh:mm a");
        de2.getTextField().setEditable(true);
        start_timespinner.setEditor(de2);
        Calendar c = Calendar.getInstance();

        c.set(Calendar.MINUTE, 30);
        c.set(Calendar.SECOND, 0);
        start_timespinner.setValue(c.getTime());
        end_timespinner.setValue(c.getTime());
        model = (DefaultTableModel) scheduleTable.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        daysGroup = new javax.swing.ButtonGroup();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        add_schedule = new javax.swing.JButton();
        monday = new javax.swing.JCheckBox();
        thursday = new javax.swing.JCheckBox();
        wednesday = new javax.swing.JCheckBox();
        tuesday = new javax.swing.JCheckBox();
        friday = new javax.swing.JCheckBox();
        roomCb = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        end_timespinner = new javax.swing.JSpinner();
        start_timespinner = new javax.swing.JSpinner();
        instructorCb = new javax.swing.JComboBox<>();
        subjectCb = new javax.swing.JComboBox<>();
        courseCb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        year_levelCb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        semesterCb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleTable = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teachers Loading");

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancel");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Plotting"));

        jLabel2.setText("Subject Code:");

        jLabel1.setText("Instructor:");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Room:");

        jLabel7.setText("Start:");

        jLabel8.setText("Day:");

        add_schedule.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add_schedule.setText("ADD SCHEDULE");
        add_schedule.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add_schedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_scheduleActionPerformed(evt);
            }
        });

        monday.setText("Monday");

        thursday.setText("Thursday");

        wednesday.setText("Wednesday");

        tuesday.setText("Tuesday");

        friday.setText("Friday");

        roomCb.setModel(new javax.swing.DefaultComboBoxModel(comboRoomItem().toArray()));

        jLabel9.setText("End:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add_schedule))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roomCb, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tuesday, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thursday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(friday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(wednesday, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(monday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(start_timespinner, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(end_timespinner, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {friday, monday, thursday, tuesday, wednesday});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(roomCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(monday))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tuesday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wednesday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thursday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(friday)
                        .addGap(9, 9, 9)
                        .addComponent(add_schedule))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(start_timespinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(end_timespinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {friday, monday, thursday, tuesday, wednesday});

        instructorCb.setModel(new javax.swing.DefaultComboBoxModel(comboTeacherItem().toArray()));

        courseCb.setModel(new javax.swing.DefaultComboBoxModel(comboCourseItem().toArray()));
        courseCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCbActionPerformed(evt);
            }
        });

        jLabel4.setText("Year Level:");

        year_levelCb.setModel(new javax.swing.DefaultComboBoxModel(comboYearItems().toArray()));
        year_levelCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_levelCbActionPerformed(evt);
            }
        });

        jLabel5.setText("Course:");

        semesterCb.setModel(new javax.swing.DefaultComboBoxModel(comboSemItems().toArray()));
        semesterCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterCbActionPerformed(evt);
            }
        });

        jLabel6.setText("Semester:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(year_levelCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(courseCb, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(semesterCb, 0, 138, Short.MAX_VALUE))
                            .addComponent(instructorCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subjectCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(semesterCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(year_levelCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(courseCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(subjectCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(instructorCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        scheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room", "Hr Start", "Hr End", "Mon", "Tue", "Wed", "Thu", "Fri", "Action", "room_id", "d1", "d2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(scheduleTable);
        if (scheduleTable.getColumnModel().getColumnCount() > 0) {
            scheduleTable.getColumnModel().getColumn(9).setMinWidth(0);
            scheduleTable.getColumnModel().getColumn(9).setPreferredWidth(0);
            scheduleTable.getColumnModel().getColumn(9).setMaxWidth(0);
            scheduleTable.getColumnModel().getColumn(10).setMinWidth(0);
            scheduleTable.getColumnModel().getColumn(10).setPreferredWidth(0);
            scheduleTable.getColumnModel().getColumn(10).setMaxWidth(0);
            scheduleTable.getColumnModel().getColumn(11).setMinWidth(0);
            scheduleTable.getColumnModel().getColumn(11).setPreferredWidth(0);
            scheduleTable.getColumnModel().getColumn(11).setMaxWidth(0);
        }

        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(38, 38, 38)
                        .addComponent(jButton6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jButton5))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private List comboSemItems() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Semester"));
        combo.add(new ComboItem(1, "First Semester"));
        combo.add(new ComboItem(2, "Second Semester"));

        return combo;
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

    private List comboYearItems() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Year"));
        combo.add(new ComboItem(1, "First Year"));
        combo.add(new ComboItem(2, "Second Year"));
        combo.add(new ComboItem(3, "Third Year"));
        combo.add(new ComboItem(4, "Fourth Year"));

        return combo;
    }

    private boolean IsConflict(Date s1, Date e1, Date s2, Date e2) {
        return (s1.compareTo(e2) < 0) && (e1.compareTo(s2) > 0);
    }
    
    
    private boolean hasDay(){
        boolean selected = false;
                if (monday.isSelected()) {
                   selected = true;
                }
                if (tuesday.isSelected()) {
                  
                   selected = true;

                }
                if (wednesday.isSelected()) {
                   
                   selected = true;

                }
                if (thursday.isSelected()) {
                   
                   selected = true;

                }
                if (friday.isSelected()) {
                    selected = true;
                 
                }
               

    
        return selected;
    }

    private void add_scheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_scheduleActionPerformed
        Object row[] = new Object[12];
        ComboItem item = (ComboItem) roomCb.getSelectedItem();
        Date d1 = (Date) this.start_timespinner.getValue();
        Date d2 = (Date) this.end_timespinner.getValue();
        boolean conflict = false;
        try {
            if(!this.hasDay()){
                throw new Exception("No day/days selected");
            }
            if(d1.compareTo(d2) > 0){
                throw new Exception("Time end must be greater than start");
            }
        for (int index = 0; index < scheduleTable.getRowCount(); index++) {
            if (true) {
            //if (Integer.parseInt(scheduleTable.getValueAt(index, 9).toString()) == item.getValue()) {
                Date d3 = (Date) scheduleTable.getValueAt(index, 10);
                Date d4 = (Date) scheduleTable.getValueAt(index, 11);
                if (monday.isSelected()) {
                    conflict = this.IsConflict(d3, d4,d1, d2);
                }
                if (tuesday.isSelected()) {
                    conflict = this.IsConflict(d3, d4,d1, d2);

                }
                if (wednesday.isSelected()) {
                    conflict = this.IsConflict(d3, d4,d1, d2);

                }
                if (thursday.isSelected()) {
                    conflict = this.IsConflict(d3, d4,d1, d2);

                }
                if (friday.isSelected()) {
                    conflict = this.IsConflict(d3, d4,d1, d2);

                }
                if(conflict){
                    throw new Exception("Unabled to add time conflict");
                }

            }

        }
        

        row[0] = item.getLabel();
        row[1] = Helper.timeFormat(d1);
        row[2] = Helper.timeFormat(d2);
        row[3] = monday.isSelected(); //m
        row[4] = tuesday.isSelected(); //t
        row[5] = wednesday.isSelected(); //w
        row[6] = thursday.isSelected(); //th
        row[7] = friday.isSelected(); //f
        row[8] = "Delete";
        row[9] = item.getValue();
        row[10] = d1;
        row[11] = d2;

        model.addRow(row);
        scheduleClear();
        }catch (Exception e) {
            System.err.println(""+e.getMessage());
            Helper.errorMessage(e.getMessage(), "Whoopss!");
        }
    }//GEN-LAST:event_add_scheduleActionPerformed

    private void scheduleClear() {
        monday.setSelected(false);
        tuesday.setSelected(false);
        wednesday.setSelected(false);
        thursday.setSelected(false);
        friday.setSelected(false);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
        ComboItem faculty_item = (ComboItem) instructorCb.getSelectedItem();
        ComboItem subject_item = (ComboItem) subjectCb.getSelectedItem();

        Faculties instructor = (Faculties) teacher.find(faculty_item.getValue());
        Subjects subject = (Subjects) this.subject.find(subject_item.getValue());
        TeachersLoadings sched = new TeachersLoadings();
        sched.setFaculties(instructor);
        sched.setSchoolYears(schoolYear.getActive());
        sched.setSubjects(subject);
        TeachersLoadings res = (TeachersLoadings) load.save(sched);

        for (int i = 0; i < scheduleTable.getRowCount(); i++) {
            TeachersLoadingDetails detail = new TeachersLoadingDetails();
            Integer room_id = (Integer) scheduleTable.getValueAt(i, 9);
            Rooms room = (Rooms) this.room.find(room_id);
            Date date1 = (Date) scheduleTable.getValueAt(i, 10);
            Date date2 = (Date) scheduleTable.getValueAt(i, 11);
            detail.setHourStart(date1);
            detail.setHourEnd(date2);
            detail.setRooms(room);
            detail.setM((Boolean) scheduleTable.getValueAt(i, 3));
            detail.setT((Boolean) scheduleTable.getValueAt(i, 4));
            detail.setW((Boolean) scheduleTable.getValueAt(i, 5));
            detail.setTh((Boolean) scheduleTable.getValueAt(i, 6));
            detail.setF((Boolean) scheduleTable.getValueAt(i, 7));
            detail.setTeachersLoadings(res);
            loadDetail.save(detail);

        }
        Helper.successMessage();
        }catch(Exception ex){
            Helper.errorMessage("No Active SchoolYear", "Whoopss! Something went wrong");
            Helper.closeSession();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void year_levelCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_levelCbActionPerformed
        // TODO add your handling code here:
        subject_populate();
    }//GEN-LAST:event_year_levelCbActionPerformed

    private void semesterCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterCbActionPerformed
        // TODO add your handling code here:
        subject_populate();

    }//GEN-LAST:event_semesterCbActionPerformed

    private void courseCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCbActionPerformed
        // TODO add your handling code here:
        subject_populate();
    }//GEN-LAST:event_courseCbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.onScreen();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void subject_populate() {
        ComboItem year_level = (ComboItem) year_levelCb.getSelectedItem();
        ComboItem semester = (ComboItem) semesterCb.getSelectedItem();
        ComboItem course = (ComboItem) courseCb.getSelectedItem();

        if (year_level.getValue() > 0 && semester.getValue() > 0 && course.getValue() > 0) {
            subjectCb.setModel(new javax.swing.DefaultComboBoxModel(comboSubjectItem(year_level.getValue(), semester.getValue(), course.getValue()).toArray()));

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
            java.util.logging.Logger.getLogger(TeachersLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeachersLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeachersLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeachersLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeachersLoading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_schedule;
    private javax.swing.JComboBox<String> courseCb;
    private javax.swing.ButtonGroup daysGroup;
    private javax.swing.JSpinner end_timespinner;
    private javax.swing.JCheckBox friday;
    private javax.swing.JComboBox<String> instructorCb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox monday;
    private javax.swing.JComboBox<String> roomCb;
    private javax.swing.JTable scheduleTable;
    private javax.swing.JComboBox<String> semesterCb;
    private javax.swing.JSpinner start_timespinner;
    private javax.swing.JComboBox<String> subjectCb;
    private javax.swing.JCheckBox thursday;
    private javax.swing.JCheckBox tuesday;
    private javax.swing.JCheckBox wednesday;
    private javax.swing.JComboBox<String> year_levelCb;
    // End of variables declaration//GEN-END:variables
}
