/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author mathu
 */
public class Generate_TimeTables extends javax.swing.JFrame {

    /**
     * Creates new form Generate_TimeTables
     */
    public Generate_TimeTables() {
        
        initComponents();
        get_employee_id_();
        get_group_id_();
        get_location_id_();
    }
    
    Connection con1;
    PreparedStatement insert;
    
    String Monday ,Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday, timeslot;
    Integer days, hours ,minutes, timedifference;
        
        
    
    public void read_WorkingDaysHours_Lecturer(){
        
        
        String Employee = EmployeeID.getSelectedItem().toString();
          
          try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con1= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
            
            //if(){
                
            //}
          
            insert = con1.prepareStatement("select no_working_days,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday,hours_time_per_day,minutes_time_per_day,time_slot From working_days_hours where TT_ID=? ");
            
            insert.setString(1, Employee);
            ResultSet rs = insert.executeQuery();  
            
            while(rs.next()) {
                
                Integer days = rs.getInt("no_working_days");
                String Monday = rs.getString("Monday");
                String Tuesday = rs.getString("Tuesday");
                String Wednesday = rs.getString("Wednesday");
                String Thursday = rs.getString("Thursday");
                String Friday = rs.getString("Friday");
                String Saturday = rs.getString("Saturday");
                String Sunday = rs.getString("Sunday");
                Integer hours = rs.getInt("hours_time_per_day");
                Integer minutes = rs.getInt("minutes_time_per_day");
                String timeslot = rs.getString("time_slot");
                 
            } 
            
         
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
//-----------------------------------------------------------------------------------------------------------
    
    public void read_WorkingDaysHours_Student(){
        
        
        String Student = GroupID.getSelectedItem().toString();
          
          try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con1= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
            
            //if(){
                
            //}
          
            insert = con1.prepareStatement("select no_working_days,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday,hours_time_per_day,minutes_time_per_day,time_slot From working_days_hours where TT_ID=? ");
            
            insert.setString(1, Student);
            ResultSet rs = insert.executeQuery();  
            
            while(rs.next()) {
                
                Integer days = rs.getInt("no_working_days");
                String Monday = rs.getString("Monday");
                String Tuesday = rs.getString("Tuesday");
                String Wednesday = rs.getString("Wednesday");
                String Thursday = rs.getString("Thursday");
                String Friday = rs.getString("Friday");
                String Saturday = rs.getString("Saturday");
                String Sunday = rs.getString("Sunday");
                Integer hours = rs.getInt("hours_time_per_day");
                Integer minutes = rs.getInt("minutes_time_per_day");
                String timeslot = rs.getString("time_slot");
                 
            } 
            
         
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
//-----------------------------------------------------------------------------------------------------------
        
    public void read_WorkingDaysHours_Location(){
        
        
        String Location = LocationID.getSelectedItem().toString();
          
          try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con1= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
            
            //if(){
                
            //}
          
            insert = con1.prepareStatement("select no_working_days,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday,hours_time_per_day,minutes_time_per_day,time_slot From working_days_hours where TT_ID=? ");
            
            insert.setString(1, Location);
            ResultSet rs = insert.executeQuery();  
            
            while(rs.next()) {
                
                Integer days = rs.getInt("no_working_days");
                String Monday = rs.getString("Monday");
                String Tuesday = rs.getString("Tuesday");
                String Wednesday = rs.getString("Wednesday");
                String Thursday = rs.getString("Thursday");
                String Friday = rs.getString("Friday");
                String Saturday = rs.getString("Saturday");
                String Sunday = rs.getString("Sunday");
                Integer hours = rs.getInt("hours_time_per_day");
                Integer minutes = rs.getInt("minutes_time_per_day");
                String timeslot = rs.getString("time_slot");
                 
            } 
            
         
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
//-----------------------------------------------------------------------------------------------------------
    
    private void get_employee_id_(){
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con1= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
            
            insert = con1.prepareStatement("select emp_id from lecturer");
            
            ResultSet rs = insert.executeQuery();  
            
            while(rs.next()) {
                
                String Employee = rs.getString("emp_id");
                EmployeeID.addItem(Employee);
                 
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
//-----------------------------------------------------------------------------------------------------------
    
    private void get_group_id_(){
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con1= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
            
            insert = con1.prepareStatement("select groupID from student");
            
            ResultSet rs = insert.executeQuery();  
            
            while(rs.next()) {
                
                String Student = rs.getString("groupID");
                GroupID.addItem(Student);
                 
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
//-----------------------------------------------------------------------------------------------------------   
    
    private void get_location_id_(){
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con1= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
            
            insert = con1.prepareStatement("select l_id from room");
            
            ResultSet rs = insert.executeQuery();  
            
            while(rs.next()) {
                
                String Location = rs.getString("l_id");
                LocationID.addItem(Location);
                 
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
//-----------------------------------------------------------------------------------------------------------   

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Lecturer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Generate_Lecturer = new javax.swing.JButton();
        Print_Lecturer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Timetable_Lecturer = new javax.swing.JTable();
        EmployeeID = new javax.swing.JComboBox<>();
        Student = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Generate_Student = new javax.swing.JButton();
        Print_Student = new javax.swing.JButton();
        GroupID = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Timetable_Student = new javax.swing.JTable();
        Location = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        LocationID = new javax.swing.JComboBox<>();
        Generate_Location = new javax.swing.JButton();
        Print_Location = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Timetable_Location = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(89, 39, 74));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathu\\Downloads\\va.jpg")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ABC Institute Timetable Management System");

        btnHome.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathu\\Downloads\\home.png")); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Lecturer");

        Generate_Lecturer.setBackground(new java.awt.Color(0, 51, 102));
        Generate_Lecturer.setForeground(new java.awt.Color(255, 255, 255));
        Generate_Lecturer.setText("Generate");
        Generate_Lecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generate_LecturerActionPerformed(evt);
            }
        });

        Print_Lecturer.setBackground(new java.awt.Color(0, 51, 0));
        Print_Lecturer.setForeground(new java.awt.Color(255, 255, 255));
        Print_Lecturer.setText("Print");
        Print_Lecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_LecturerActionPerformed(evt);
            }
        });

        Timetable_Lecturer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time Slots", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Timetable_Lecturer);
        if (Timetable_Lecturer.getColumnModel().getColumnCount() > 0) {
            Timetable_Lecturer.getColumnModel().getColumn(0).setResizable(false);
            Timetable_Lecturer.getColumnModel().getColumn(1).setResizable(false);
            Timetable_Lecturer.getColumnModel().getColumn(2).setResizable(false);
            Timetable_Lecturer.getColumnModel().getColumn(3).setResizable(false);
            Timetable_Lecturer.getColumnModel().getColumn(4).setResizable(false);
            Timetable_Lecturer.getColumnModel().getColumn(5).setResizable(false);
            Timetable_Lecturer.getColumnModel().getColumn(6).setResizable(false);
            Timetable_Lecturer.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout LecturerLayout = new javax.swing.GroupLayout(Lecturer);
        Lecturer.setLayout(LecturerLayout);
        LecturerLayout.setHorizontalGroup(
            LecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LecturerLayout.createSequentialGroup()
                .addGroup(LecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LecturerLayout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(Generate_Lecturer)
                        .addGap(39, 39, 39)
                        .addComponent(Print_Lecturer))
                    .addGroup(LecturerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        LecturerLayout.setVerticalGroup(
            LecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LecturerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LecturerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Generate_Lecturer)
                    .addComponent(Print_Lecturer)
                    .addComponent(EmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lecturer", Lecturer);

        jLabel4.setText("Group");

        Generate_Student.setBackground(new java.awt.Color(0, 51, 102));
        Generate_Student.setForeground(new java.awt.Color(255, 255, 255));
        Generate_Student.setText("Generate");
        Generate_Student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generate_StudentActionPerformed(evt);
            }
        });

        Print_Student.setBackground(new java.awt.Color(0, 51, 0));
        Print_Student.setForeground(new java.awt.Color(255, 255, 255));
        Print_Student.setText("Print");
        Print_Student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_StudentActionPerformed(evt);
            }
        });

        Timetable_Student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time Slots", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(Timetable_Student);
        if (Timetable_Student.getColumnModel().getColumnCount() > 0) {
            Timetable_Student.getColumnModel().getColumn(0).setResizable(false);
            Timetable_Student.getColumnModel().getColumn(1).setResizable(false);
            Timetable_Student.getColumnModel().getColumn(2).setResizable(false);
            Timetable_Student.getColumnModel().getColumn(3).setResizable(false);
            Timetable_Student.getColumnModel().getColumn(4).setResizable(false);
            Timetable_Student.getColumnModel().getColumn(5).setResizable(false);
            Timetable_Student.getColumnModel().getColumn(6).setResizable(false);
            Timetable_Student.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout StudentLayout = new javax.swing.GroupLayout(Student);
        Student.setLayout(StudentLayout);
        StudentLayout.setHorizontalGroup(
            StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentLayout.createSequentialGroup()
                .addGroup(StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentLayout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GroupID, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(Generate_Student)
                        .addGap(65, 65, 65)
                        .addComponent(Print_Student))
                    .addGroup(StudentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        StudentLayout.setVerticalGroup(
            StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Generate_Student)
                    .addComponent(Print_Student)
                    .addComponent(GroupID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student", Student);

        jLabel5.setText("Location");

        Generate_Location.setBackground(new java.awt.Color(0, 51, 102));
        Generate_Location.setForeground(new java.awt.Color(255, 255, 255));
        Generate_Location.setText("Generate");
        Generate_Location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generate_LocationActionPerformed(evt);
            }
        });

        Print_Location.setBackground(new java.awt.Color(0, 51, 0));
        Print_Location.setForeground(new java.awt.Color(255, 255, 255));
        Print_Location.setText("Print");
        Print_Location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_LocationActionPerformed(evt);
            }
        });

        Timetable_Location.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time Slots", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(Timetable_Location);
        if (Timetable_Location.getColumnModel().getColumnCount() > 0) {
            Timetable_Location.getColumnModel().getColumn(0).setResizable(false);
            Timetable_Location.getColumnModel().getColumn(1).setResizable(false);
            Timetable_Location.getColumnModel().getColumn(2).setResizable(false);
            Timetable_Location.getColumnModel().getColumn(3).setResizable(false);
            Timetable_Location.getColumnModel().getColumn(4).setResizable(false);
            Timetable_Location.getColumnModel().getColumn(5).setResizable(false);
            Timetable_Location.getColumnModel().getColumn(6).setResizable(false);
            Timetable_Location.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout LocationLayout = new javax.swing.GroupLayout(Location);
        Location.setLayout(LocationLayout);
        LocationLayout.setHorizontalGroup(
            LocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LocationLayout.createSequentialGroup()
                .addGroup(LocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LocationLayout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(LocationID, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(Generate_Location)
                        .addGap(67, 67, 67)
                        .addComponent(Print_Location))
                    .addGroup(LocationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        LocationLayout.setVerticalGroup(
            LocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LocationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LocationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Generate_Location)
                    .addComponent(Print_Location))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Location", Location);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1062, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome)
                .addGap(95, 95, 95)
                .addComponent(jLabel2)
                .addGap(347, 347, 347))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        dashboardnw dbn = new dashboardnw();
        dbn.show();    //display the dashboard

        dispose();     //close the current jframe and open the new jframe
    }//GEN-LAST:event_btnHomeActionPerformed

    private void Generate_LecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Generate_LecturerActionPerformed
        // TODO add your handling code here:
        read_WorkingDaysHours_Lecturer();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable Timetable = new JTable(tableModel);
        
        switch(timeslot){
            case "1 hour time slot":
                timedifference = 60;
                break;
            case "30 minutes time slot":
                timedifference = 30;
                break;
        }
        
        int r = (hours*60 + minutes)/timedifference ;
        double m = 08.30;
        double n = 09.30;
        double o = 09.00;
        String value = Double.toString(m)+" - "+Double.toString(n);
        String value1 = Double.toString(m)+" - "+Double.toString(o);
        
        if(timeslot == "1 hour time slot"){
                for(int i = 1; i > r; i++){
                    tableModel.insertRow(i, new Object[] { value});
                    tableModel.setValueAt(value, i, 1);
                    m = m + 1.00;
                    n = n + 1.00;
                }
            }
        if(timeslot == "30 minutes time slot"){
                for(int i = 1; i > r; i++){
                    tableModel.insertRow(i, new Object[] { value1});
                    tableModel.setValueAt(value1, i, 1);
                    if(m%1 == 0.30){
                        m = m + 0.70;
                        o = o + 0.30;
                    }
                    if(o%1 == 0.30){
                        o = o + 0.70;
                        m = m + 0.30;
                    }
                    else{
                        m = m + 0.30;
                        o = o + 0.30;
                    }
                }
            }
        
        /*try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con1= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
            
            insert = con1.prepareStatement("insert into timetable()values()");
            
            
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }//GEN-LAST:event_Generate_LecturerActionPerformed

    private void Print_LecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_LecturerActionPerformed
        // TODO add your handling code here:
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int x = j.showSaveDialog(this);
        
        if(x==JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        
        Document doc = new Document();
        
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(path+"LecturerTimetable.pdf"));
            
            doc.open();
            
            PdfPTable tbl = new PdfPTable(8);
            
            
            
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_Print_LecturerActionPerformed

    private void Generate_StudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Generate_StudentActionPerformed
        // TODO add your handling code here:
        read_WorkingDaysHours_Student();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable Timetable = new JTable(tableModel);
        
        switch(timeslot){
            case "1 hour time slot":
                timedifference = 60;
                break;
            case "30 minutes time slot":
                timedifference = 30;
                break;
        }
        
        int r = (hours*60 + minutes)/timedifference ;
        double m = 08.30;
        double n = 09.30;
        double o = 09.00;
        String value = Double.toString(m)+" - "+Double.toString(n);
        String value1 = Double.toString(m)+" - "+Double.toString(o);
        
        if(timeslot == "1 hour time slot"){
                for(int i = 1; i > r; i++){
                    tableModel.insertRow(i, new Object[] { value});
                    tableModel.setValueAt(value, i, 1);
                    m = m + 1.00;
                    n = n + 1.00;
                }
            }
        if(timeslot == "30 minutes time slot"){
                for(int i = 1; i > r; i++){
                    tableModel.insertRow(i, new Object[] { value1});
                    tableModel.setValueAt(value1, i, 1);
                    if(m%1 == 0.30){
                        m = m + 0.70;
                        o = o + 0.30;
                    }
                    if(o%1 == 0.30){
                        o = o + 0.70;
                        m = m + 0.30;
                    }
                    else{
                        m = m + 0.30;
                        o = o + 0.30;
                    }
                }
            }
        
    }//GEN-LAST:event_Generate_StudentActionPerformed

    private void Print_StudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_StudentActionPerformed
        // TODO add your handling code here:
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int x = j.showSaveDialog(this);
        
        if(x==JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        
        Document doc = new Document();
        
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(path+"StudentTimetable.pdf"));
            
            doc.open();
            
            PdfPTable tbl = new PdfPTable(8);
            
            
            
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_Print_StudentActionPerformed

    private void Generate_LocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Generate_LocationActionPerformed
        // TODO add your handling code here:
        read_WorkingDaysHours_Location();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable Timetable = new JTable(tableModel);
        
        switch(timeslot){
            case "1 hour time slot":
                timedifference = 60;
                break;
            case "30 minutes time slot":
                timedifference = 30;
                break;
        }
        
        int r = (hours*60 + minutes)/timedifference ;
        double m = 08.30;
        double n = 09.30;
        double o = 09.00;
        String value = Double.toString(m)+" - "+Double.toString(n);
        String value1 = Double.toString(m)+" - "+Double.toString(o);
        
        if(timeslot == "1 hour time slot"){
                for(int i = 1; i > r; i++){
                    tableModel.insertRow(i, new Object[] { value});
                    tableModel.setValueAt(value, i, 1);
                    m = m + 1.00;
                    n = n + 1.00;
                }
            }
        if(timeslot == "30 minutes time slot"){
                for(int i = 1; i > r; i++){
                    tableModel.insertRow(i, new Object[] { value1});
                    tableModel.setValueAt(value1, i, 1);
                    if(m%1 == 0.30){
                        m = m + 0.70;
                        o = o + 0.30;
                    }
                    if(o%1 == 0.30){
                        o = o + 0.70;
                        m = m + 0.30;
                    }
                    else{
                        m = m + 0.30;
                        o = o + 0.30;
                    }
                }
            }
    }//GEN-LAST:event_Generate_LocationActionPerformed

    private void Print_LocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_LocationActionPerformed
        // TODO add your handling code here:
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int x = j.showSaveDialog(this);
        
        if(x==JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        
        Document doc = new Document();
        
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(path+"LocationTimetable.pdf"));
            
            doc.open();
            
            PdfPTable tbl = new PdfPTable(8);
            
            
            
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Generate_TimeTables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_Print_LocationActionPerformed

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
            java.util.logging.Logger.getLogger(Generate_TimeTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Generate_TimeTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Generate_TimeTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Generate_TimeTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Generate_TimeTables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> EmployeeID;
    private javax.swing.JButton Generate_Lecturer;
    private javax.swing.JButton Generate_Location;
    private javax.swing.JButton Generate_Student;
    private javax.swing.JComboBox<String> GroupID;
    private javax.swing.JPanel Lecturer;
    private javax.swing.JPanel Location;
    private javax.swing.JComboBox<String> LocationID;
    private javax.swing.JButton Print_Lecturer;
    private javax.swing.JButton Print_Location;
    private javax.swing.JButton Print_Student;
    private javax.swing.JPanel Student;
    private javax.swing.JTable Timetable_Lecturer;
    private javax.swing.JTable Timetable_Location;
    private javax.swing.JTable Timetable_Student;
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
