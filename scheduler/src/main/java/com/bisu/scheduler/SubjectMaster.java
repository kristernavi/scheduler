/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.scheduler;

import com.bisu.dao.Course;
import com.bisu.dao.Subject;
import com.bisu.dao.SubjectCourse;
import com.bisu.entities.Courses;
import com.bisu.entities.SubjectCourses;
import com.bisu.entities.Subjects;
import com.bisu.extras.Helper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class SubjectMaster extends javax.swing.JFrame {

    /**
     * Creates new form SubjectMaster
     */
    private Subject subject;
    private Course course;
    DefaultTableModel model;
    DefaultTableModel model2;
    JPopupMenu popupMenu;
    MainMenu mainMenu;
    SubjectCourse subjectCourse;
    
    public SubjectMaster(MainMenu mainMenu) {
    this();
    this.mainMenu = mainMenu;
        int op = this.getDefaultCloseOperation(); // HIDE_ON_CLOSE
    this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    
    }
    public void offScreen(){
     this.mainMenu.setVisible(false);
     coursetItems.setModel(new javax.swing.DefaultComboBoxModel(comboItems().toArray()));

    }
    public void onScreen(){
      this.mainMenu.setVisible(true);
      this.setVisible(false);
    }
    public SubjectMaster() {
        this.course = new Course();
        subject = new Subject();
        this.subjectCourse = new SubjectCourse();
        initComponents();
        popupMenu = new JPopupMenu();
        model = (DefaultTableModel) subjectsTable.getModel();
        model2 = (DefaultTableModel) courseTable.getModel();
        JMenuItem menuItemEdit = new JMenuItem("Edit");
        JMenuItem menuItemDelete = new JMenuItem("Delete");
        menuItemEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                String id = subjectsTable.getValueAt(subjectsTable.getSelectedRow(), 8).toString();
                populate_inputs(Integer.parseInt(id));
                save.setEnabled(true);
                nav_pane.setSelectedIndex(0);

            }
        });
        menuItemDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                String id = subjectsTable.getValueAt(subjectsTable.getSelectedRow(), 8).toString();
                System.err.println("The subject ID "+id);
                populate_inputs(Integer.parseInt(id));
                nav_pane.setEnabledAt(0, true);
                nav_pane.setSelectedIndex(0);
                delete.setEnabled(true);
            }
        });
        popupMenu.add(menuItemEdit);
        popupMenu.add(menuItemDelete);
        nav_pane.setSelectedIndex(0);
    }

    public void populate_inputs(Integer id) {
        Subjects sub= (Subjects) subject.find(id);
        yearCB.setSelectedIndex(sub.getYearLevel());
        semCb.setSelectedIndex(sub.getSemester());
//        ComboItem item = new ComboItem(sub.getCourses().getId(),sub.getCourses().getCode());
//        coursetItems.getModel().setSelectedItem(item);
        this.populateTable2(sub);
        code.setText(sub.getCode());
        description.setText(sub.getDescription());
        units.setText(""+sub.getUnits());
        lec_hr.setText(""+sub.getLecHours());
        lab_hr.setText(""+sub.getLabHours());
        hiddenID.setText(""+sub.getId());
        
        if(sub.getType().equals("general")){
            gen_ed.setSelected(true);
        }
        else if(sub.getType().equals("major")){
            major.setSelected(true);
        }
        else{
            elective.setSelected(true);
        }
        requisite.setText(sub.getPreRequisite());

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

    private List comboItems() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Course"));
        try {
            for (Object obj : course.all()) {
                Courses model = (Courses) obj;
                combo.add(new ComboItem(model.getId(), model.getCode()));
            }
        } catch (Exception e) {

        }
        return combo;
    }

    private List comboSubjectItems() {

        List<ComboItem> combo = new ArrayList<ComboItem>();
        combo.add(new ComboItem(0, "Select Subject"));

        try {
            for (Object obj : subject.all()) {
                Subjects model = (Subjects) obj;
                combo.add(new ComboItem(model.getId(), model.getCode()));
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

        typeGroup = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        cancel1 = new javax.swing.JButton();
        nav_pane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        jLabel9 = new javax.swing.JLabel();
        yearCB = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        semCb = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        hiddenID = new javax.swing.JLabel();
        requisite = new javax.swing.JTextField();
        addCourse = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add.setText("New");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        edit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel.setText("Cancel");

        cancel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel1.setText("Back ");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                .addComponent(cancel1)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(edit)
                    .addComponent(save)
                    .addComponent(delete)
                    .addComponent(cancel)
                    .addComponent(cancel1))
                .addContainerGap())
        );

        nav_pane.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Subject Information"));

        jLabel1.setText("Subject Code:");

        jLabel2.setText("Description");

        jLabel4.setText("Units:");

        jLabel5.setText("Lecture Hours:");

        jLabel6.setText("Laboratory Hours:");

        jLabel7.setText("Subject Type:");

        jLabel8.setText("Pre-requisite:");

        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });

        units.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitsActionPerformed(evt);
            }
        });

        coursetItems.setModel(new javax.swing.DefaultComboBoxModel(comboItems().toArray()));
        coursetItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursetItemsActionPerformed(evt);
            }
        });

        typeGroup.add(major);
        major.setText("Major");
        major.setActionCommand("major");

        typeGroup.add(gen_ed);
        gen_ed.setText("General Education");
        gen_ed.setActionCommand("general");

        typeGroup.add(elective);
        elective.setText("Elective");
        elective.setActionCommand("elective");

        lec_hr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lec_hrActionPerformed(evt);
            }
        });

        lab_hr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lab_hrActionPerformed(evt);
            }
        });

        jLabel9.setText("Year Level:");

        yearCB.setModel(new javax.swing.DefaultComboBoxModel(comboYearItems().toArray()));
        yearCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCBActionPerformed(evt);
            }
        });

        jLabel10.setText("Course:");

        semCb.setModel(new javax.swing.DefaultComboBoxModel(comboSemItems().toArray()));
        semCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semCbActionPerformed(evt);
            }
        });

        jLabel11.setText("Semester:");

        hiddenID.setText("hiddenID");
        hiddenID.setVisible(false);

        requisite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requisiteActionPerformed(evt);
            }
        });

        addCourse.setText("+");
        addCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseActionPerformed(evt);
            }
        });

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Action", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        courseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(courseTable);
        if (courseTable.getColumnModel().getColumnCount() > 0) {
            courseTable.getColumnModel().getColumn(2).setMinWidth(0);
            courseTable.getColumnModel().getColumn(2).setPreferredWidth(0);
            courseTable.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(20, 20, 20)
                        .addComponent(major)
                        .addGap(18, 18, 18)
                        .addComponent(gen_ed)
                        .addGap(5, 5, 5)
                        .addComponent(elective))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(hiddenID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(coursetItems, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(semCb, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5))
                                    .addGap(27, 27, 27)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lec_hr, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lab_hr)
                                    .addComponent(units))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(addCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(requisite)))))
                .addGap(30, 30, 30))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {code, description, lab_hr, lec_hr});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {coursetItems, semCb, yearCB});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(semCb, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(addCourse, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(coursetItems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lec_hr, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lab_hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(units, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(requisite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gen_ed)
                            .addComponent(elective)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(major)))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(hiddenID))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {code, description, lab_hr, lec_hr, requisite, units});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {coursetItems, semCb, yearCB});

        nav_pane.addTab("Details", jPanel1);

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
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subjectsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                subjectsTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(subjectsTable);
        if (subjectsTable.getColumnModel().getColumnCount() > 0) {
            subjectsTable.getColumnModel().getColumn(8).setMinWidth(0);
            subjectsTable.getColumnModel().getColumn(8).setPreferredWidth(0);
            subjectsTable.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

        nav_pane.addTab("List", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nav_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nav_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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
            } catch (Exception e) {
                row[2] = "N/A";
            }
            try {
                row[7] = dept.getPreRequisite();
            } catch (Exception e) {
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

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        save.setEnabled(true);
        nav_pane.setSelectedIndex(0);


    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        Subjects model;

     

        if (Helper.isNumeric(hiddenID.getText())) {
            model = (Subjects) subject.find(Integer.parseInt(hiddenID.getText()));
            this.subjectCourse.deleteBySubject(model.getId());
        } else {
            model = new Subjects();
        }
        //  ComboItem selected_subject = (ComboItem) subjectItems.getSelectedItem();
        ComboItem yr_lvl = (ComboItem) yearCB.getSelectedItem();
        ComboItem semester = (ComboItem) semCb.getSelectedItem();
        // Subjects pre_requisite = null;
        Integer lec = 0;
        Integer lab = 0;
        Short unit = 0;
        Short yr = Short.parseShort(""+yr_lvl.getValue());
        Short sem = Short.parseShort(""+semester.getValue());
//        if(selected_subject.getValue() != 0){
//        pre_requisite = (Subjects) subject.find(selected_subject.getValue());
//        }
        if(Helper.isNumeric(units.getText())){
            unit = Short.parseShort(units.getText());
        }
        if (Helper.isNumeric(lab_hr.getText())) {
            lab = Integer.parseInt(lab_hr.getText());
        }
        if (Helper.isNumeric(lec_hr.getText())) {
            lec = Integer.parseInt(lec_hr.getText());
        }
        

       
        String type = "";
        if (this.typeGroup.getSelection() != null) {
            type = this.typeGroup.getSelection().getActionCommand();
        }
        try{
       
        model.setCode(code.getText());
        model.setYearLevel(yr);
        model.setSemester(sem);
        model.setDescription(description.getText());
        model.setLabHours(lab);
        model.setLecHours(lec);
        model.setPreRequisite(requisite.getText());
        model.setUnits(unit);
        model.setType(type);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Subjects>> constraintViolations = validator.validate(model);
        if (!constraintViolations.isEmpty()) {
            String msg = "";
            for (ConstraintViolation<Subjects> constraintViolation : constraintViolations) {
                String name = constraintViolation.getPropertyPath().toString();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                msg += name + " " + constraintViolation.getMessage() + "\n";

            }

            Helper.errorMessage(msg, "Error");
        } else {
            if(courseTable.getRowCount() > 0){
             
            subject.save(model);
            for(int index = 0 ; index < courseTable.getRowCount(); index++){
                SubjectCourses sc = new SubjectCourses();
                Courses c = (Courses) this.course.find((Integer)courseTable.getValueAt(index, 2));
                sc.setCourses(c);
                sc.setSubjects(model);
                model.getSubjectCourseses().add(sc);
                subjectCourse.save(sc);
            }
            Helper.successMessage();
            this.clear();
            }
            else{
                Helper.errorMessage("Course is required atleast 1", "error");
            }

        }
        }
        catch(Exception ex){
                            Helper.closeSession();
            Helper.errorMessage("Duplicate Course Code", "Woopss! Somethin went wrong");
        }
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
                edit.setEnabled(false);
                delete.setEnabled(false);
                cancel.setEnabled(false);
                add.setEnabled(true);
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

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeActionPerformed

    private void semCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semCbActionPerformed

    private void requisiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requisiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requisiteActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        if(Helper.confirmationMessage()){
            try{
        Subjects sub = (Subjects) subject.find(Integer.parseInt(hiddenID.getText()));
        subject.delete(sub);
        Helper.successMessage();
        nav_pane.setSelectedIndex(1);
            }catch(Exception ex){
            Helper.errorMessage("Constrait fail might be the subject connected somewhere", "Opss somethin when wrong!");
            Helper.closeSession();
            }
        }
    }//GEN-LAST:event_deleteActionPerformed
    private void populateTable2 (Subjects subject){
        
            model2.setRowCount(0);
              Object row[] = new Object[3];
            for(SubjectCourses sc: subject.getSubjectCourseses()){
                row[0] = sc.getCourses().getCode();
                row[1] = "Delete";
                row[2] = sc.getCourses().getId();
            model2.addRow(row);
            }
        
          
            
        
    
    }
    private void addCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseActionPerformed
        // TODO add your handling code here:
        ComboItem item = (ComboItem) coursetItems.getSelectedItem();
        if(item.getValue() > 0 ){
            boolean addable = true;
            for(int index = 0 ; index < this.courseTable.getRowCount() ; index++){
                if(item.getValue() == this.courseTable.getValueAt(index, 2)){
                Helper.errorMessage("Course already exsist", "Error");
                addable = false;
                }
            }
            if(addable){
            Object row[] = new Object[3];
            row[0] = item.getLabel();
            row[1] = "Delete";
            row[2] = item.getValue();
            model2.addRow(row);
            }

        }
        
        else{
            Helper.errorMessage("Select a course", "Error");
        }
    }//GEN-LAST:event_addCourseActionPerformed

    private void courseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTableMouseClicked
        // TODO add your handling code here:
        int row = courseTable.rowAtPoint(evt.getPoint());
        int col = courseTable.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 1) {
            model2.removeRow(row);
        }
    }//GEN-LAST:event_courseTableMouseClicked

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed
        // TODO add your handling code here:
      this.onScreen();
    }//GEN-LAST:event_cancel1ActionPerformed

    private void lab_hrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lab_hrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lab_hrActionPerformed

    private void yearCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearCBActionPerformed

    private void lec_hrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lec_hrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lec_hrActionPerformed

    private void clear() {
        code.setText("");
        description.setText("");
        lab_hr.setText("1");
        lec_hr.setText("1");
        units.setText("1");
        yearCB.setSelectedIndex(0);
        this.semCb.setSelectedIndex(0);
        this.model2.setRowCount(0);
        this.coursetItems.setSelectedIndex(0);
        this.requisite.setText("");

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
    private javax.swing.JButton add;
    private javax.swing.JButton addCourse;
    private javax.swing.JButton cancel;
    private javax.swing.JButton cancel1;
    private javax.swing.JTextField code;
    private javax.swing.JTable courseTable;
    private javax.swing.JComboBox<String> coursetItems;
    private javax.swing.JButton delete;
    private javax.swing.JTextField description;
    private javax.swing.JButton edit;
    private javax.swing.JRadioButton elective;
    private javax.swing.JRadioButton gen_ed;
    private javax.swing.JLabel hiddenID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lab_hr;
    private javax.swing.JTextField lec_hr;
    private javax.swing.JRadioButton major;
    private javax.swing.JTabbedPane nav_pane;
    private javax.swing.JTextField requisite;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> semCb;
    private javax.swing.JTable subjectsTable;
    private javax.swing.ButtonGroup typeGroup;
    private javax.swing.JTextField units;
    private javax.swing.JComboBox<String> yearCB;
    // End of variables declaration//GEN-END:variables
}
