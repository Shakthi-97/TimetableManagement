/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author USER
 */
public class SessionsTime extends javax.swing.JFrame {

    /**
     * Creates new form SessionsTime
     */
    public SessionsTime() {
        initComponents();
        table_update();
        session_id_NotAvailable();
        not_available_update();
    }
    
    Connection con;
        PreparedStatement insert;
        
        //display in the table
        private void table_update()
        {
            int a;
            
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
            insert = con.prepareStatement("select * From session");
            
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData Rss = rs.getMetaData();
            a = Rss.getColumnCount();
            
            DefaultTableModel Df = (DefaultTableModel)consecutive.getModel();
            DefaultTableModel Df1 = (DefaultTableModel)parallel.getModel();
            DefaultTableModel Df2 = (DefaultTableModel)lapping.getModel();
            Df.setRowCount(0);
            
                while(rs.next()) {
                
                Vector vec = new Vector();
                
                for(int i=1; i<=a; i++) {
                    
                    vec.add(rs.getString("ses_id"));
                    vec.add(rs.getString("lec1"));
                    vec.add(rs.getString("lec2"));
                    vec.add(rs.getString("extra_lec"));
                    vec.add(rs.getString("ses_tag"));
                    vec.add(rs.getString("subject"));
                    vec.add(rs.getString("sub_code"));
                    vec.add(rs.getString("grp_ID"));
                    vec.add(rs.getString("no_Stds"));
                    vec.add(rs.getString("duration"));
                    
                }
                
                Df.addRow(vec);
                Df1.addRow(vec);
                Df2.addRow(vec);                  
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
//---------------------------------------------------------------------------------------------------
        
        private void session_id_NotAvailable(){
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
            
            insert = con.prepareStatement("select ses_id from session");
            
            ResultSet rs = insert.executeQuery();  
            
            while(rs.next()) {
                
                String Selectroom = rs.getString("ses_id");
                txtsessionid.addItem(Selectroom);
                 
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
//---------------------------------------------------------------------------------------------------
        
        public void not_available_update(){
            
            int c;
          
          try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
          
            insert = con.prepareStatement("select * From notavailable_session");
            
            ResultSet rs = insert.executeQuery();  
            ResultSetMetaData Rss = rs.getMetaData();
            c = Rss.getColumnCount();
            
            DefaultTableModel Df = (DefaultTableModel)sessiontab.getModel();
            Df.setRowCount(0);
            
            while(rs.next()) {
                
                Vector v2 = new Vector();
                
                for(int a=1; a<=c; a++) {
                    
                    v2.add(rs.getString("session_ID"));
                    v2.add(rs.getString("working_day"));
                    v2.add(rs.getInt("start_time_hour"));
                    v2.add(rs.getInt("start_time_minutes"));
                    v2.add(rs.getInt("end_time_hour"));
                    v2.add(rs.getInt("end_time_minutes"));
                    
                }
                
                Df.addRow(v2);
                  
            }
         
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
//---------------------------------------------------------------------------------------------------

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
        jLabel9 = new javax.swing.JLabel();
        home_btn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        consecutive = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        parallel = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        lapping = new javax.swing.JTable();
        NotAvailableTimes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        form = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtday = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtstarthour = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txtstartminute = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtendhour = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        txtendminutes = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        btn_NotAvailable_Add = new javax.swing.JButton();
        btn_NotAvailable_Update = new javax.swing.JButton();
        btn_NotAvailable_Delete = new javax.swing.JButton();
        txtsessionid = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        sessiontab = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1170, 762));

        jPanel1.setBackground(new java.awt.Color(89, 39, 74));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 733));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Desktop\\icons\\va.jpg")); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ABC Institute Timetable Management System");

        home_btn.setBackground(new java.awt.Color(255, 255, 255));
        home_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Desktop\\icons\\home.png")); // NOI18N
        home_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        home_btn.setBorderPainted(false);
        home_btn.setPreferredSize(new java.awt.Dimension(20, 20));
        home_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_btnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Add Consecutive Session");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        consecutive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Session ID", "Select Lecturer", "Selected Lecturer", "Extra Lecturer", "Tag", "Subject", "Subject Code", "Group ID", "No of Students", "Duration"
            }
        ));
        consecutive.setSelectionBackground(new java.awt.Color(89, 39, 74));
        jScrollPane2.setViewportView(consecutive);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(425, 425, 425))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consecutive", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton7.setBackground(new java.awt.Color(0, 102, 102));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Add Parallel Session");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        parallel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Session ID", "Select Lecturer", "Selected Lecturer", "Extra Lecturer", "Tag", "Subject", "Subject Code", "Group ID", "No of Students", "Duration"
            }
        ));
        parallel.setSelectionBackground(new java.awt.Color(89, 39, 74));
        jScrollPane4.setViewportView(parallel);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Parallel", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Add Non Overlapping Session");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        lapping.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Session ID", "Select Lecturer", "Selected Lecturer", "Extra Lecturer", "Tag", "Subject", "Subject Code", "Group ID", "No of Students", "Duration"
            }
        ));
        lapping.setSelectionBackground(new java.awt.Color(89, 39, 74));
        jScrollPane5.setViewportView(lapping);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(462, 462, 462)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Non Overlapping", jPanel9);

        NotAvailableTimes.setBackground(new java.awt.Color(255, 255, 255));
        NotAvailableTimes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Calisto MT", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 51));
        jLabel2.setText("NOT AVAILABLE TIME ALLOCATION FOR SESSIONS");

        form.setBackground(new java.awt.Color(255, 255, 255));
        form.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 39, 74), 3));
        form.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(89, 39, 74));

        jLabel3.setFont(new java.awt.Font("Calisto MT", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ADD NOT AVAILABLE TIME");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Session ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Working day");

        txtday.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        txtday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdayActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Start time");

        jLabel7.setText("hour");

        jLabel8.setText("minutes");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("End time");

        jLabel11.setText("hour");

        jLabel12.setText("minutes");

        btn_NotAvailable_Add.setBackground(new java.awt.Color(0, 51, 0));
        btn_NotAvailable_Add.setForeground(new java.awt.Color(255, 255, 255));
        btn_NotAvailable_Add.setText("Add");
        btn_NotAvailable_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotAvailable_AddActionPerformed(evt);
            }
        });

        btn_NotAvailable_Update.setBackground(new java.awt.Color(0, 51, 102));
        btn_NotAvailable_Update.setForeground(new java.awt.Color(255, 255, 255));
        btn_NotAvailable_Update.setText("Update");
        btn_NotAvailable_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotAvailable_UpdateActionPerformed(evt);
            }
        });

        btn_NotAvailable_Delete.setBackground(new java.awt.Color(153, 0, 51));
        btn_NotAvailable_Delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_NotAvailable_Delete.setText("Delete");
        btn_NotAvailable_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotAvailable_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(formLayout.createSequentialGroup()
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtendhour, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstarthour, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(26, 26, 26)
                                .addComponent(txtstartminute, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(formLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtendminutes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))))
                    .addGroup(formLayout.createSequentialGroup()
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(51, 51, 51)
                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtday, 0, 87, Short.MAX_VALUE)
                                    .addComponent(txtsessionid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(formLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(formLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btn_NotAvailable_Add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_NotAvailable_Update)
                        .addGap(35, 35, 35)
                        .addComponent(btn_NotAvailable_Delete)))
                .addContainerGap())
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtsessionid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstarthour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtstartminute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtendhour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtendminutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_NotAvailable_Add)
                    .addComponent(btn_NotAvailable_Update)
                    .addComponent(btn_NotAvailable_Delete))
                .addGap(20, 20, 20))
        );

        sessiontab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Session ID", "Lecturer", "Subject Code", "Group ID", "Working day", "Start time hour", "Start time minutes", "End time hour", "End time minutes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sessiontab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sessiontabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sessiontab);
        if (sessiontab.getColumnModel().getColumnCount() > 0) {
            sessiontab.getColumnModel().getColumn(0).setResizable(false);
            sessiontab.getColumnModel().getColumn(0).setPreferredWidth(70);
            sessiontab.getColumnModel().getColumn(1).setResizable(false);
            sessiontab.getColumnModel().getColumn(1).setPreferredWidth(110);
            sessiontab.getColumnModel().getColumn(2).setResizable(false);
            sessiontab.getColumnModel().getColumn(2).setPreferredWidth(90);
            sessiontab.getColumnModel().getColumn(3).setResizable(false);
            sessiontab.getColumnModel().getColumn(3).setPreferredWidth(80);
            sessiontab.getColumnModel().getColumn(4).setResizable(false);
            sessiontab.getColumnModel().getColumn(4).setPreferredWidth(90);
            sessiontab.getColumnModel().getColumn(5).setResizable(false);
            sessiontab.getColumnModel().getColumn(5).setPreferredWidth(50);
            sessiontab.getColumnModel().getColumn(6).setResizable(false);
            sessiontab.getColumnModel().getColumn(6).setPreferredWidth(50);
            sessiontab.getColumnModel().getColumn(7).setResizable(false);
            sessiontab.getColumnModel().getColumn(7).setPreferredWidth(50);
            sessiontab.getColumnModel().getColumn(8).setResizable(false);
            sessiontab.getColumnModel().getColumn(8).setPreferredWidth(50);
        }

        btnClear.setBackground(new java.awt.Color(204, 0, 0));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear History");

        javax.swing.GroupLayout NotAvailableTimesLayout = new javax.swing.GroupLayout(NotAvailableTimes);
        NotAvailableTimes.setLayout(NotAvailableTimesLayout);
        NotAvailableTimesLayout.setHorizontalGroup(
            NotAvailableTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotAvailableTimesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(240, 240, 240))
            .addGroup(NotAvailableTimesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(NotAvailableTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotAvailableTimesLayout.createSequentialGroup()
                        .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        NotAvailableTimesLayout.setVerticalGroup(
            NotAvailableTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NotAvailableTimesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NotAvailableTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Not Available Times", NotAvailableTimes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(home_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(home_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void home_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btnActionPerformed
        // TODO add your handling code here:
        dashboardnw dbn = new dashboardnw();
        dbn.show();

        dispose();
    }//GEN-LAST:event_home_btnActionPerformed

    private void txtdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdayActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

         TableModel model1 = consecutive.getModel();
        int indexs[] = consecutive.getSelectedRows();
        
        Object[] row = new Object[10];
        
        sample sam1 = new sample();
        DefaultTableModel model5 = (DefaultTableModel)sam1.cons.getModel();
        
        for(int i = 0; i < indexs.length; i++)
        {
            row[0] = model1.getValueAt(indexs[i], 0);
            row[1] = model1.getValueAt(indexs[i], 1);
            row[2] = model1.getValueAt(indexs[i], 2);
            row[3] = model1.getValueAt(indexs[i], 3);
            row[4] = model1.getValueAt(indexs[i], 4);
            row[5] = model1.getValueAt(indexs[i], 5);
            row[6] = model1.getValueAt(indexs[i], 6);
            row[7] = model1.getValueAt(indexs[i], 7);
            row[8] = model1.getValueAt(indexs[i], 8);
            row[9] = model1.getValueAt(indexs[i], 9);
            
            model5.addRow(row);
        }
        sam1.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         TableModel model2 = lapping.getModel();
        int indexs[] = lapping.getSelectedRows();
        
        Object[] row = new Object[10];
        
        sampleOverlap samL = new sampleOverlap();
        DefaultTableModel model6 = (DefaultTableModel)samL.over.getModel();
        
        for(int i = 0; i < indexs.length; i++)
        {
            row[0] = model2.getValueAt(indexs[i], 0);
            row[1] = model2.getValueAt(indexs[i], 1);
            row[2] = model2.getValueAt(indexs[i], 2);
            row[3] = model2.getValueAt(indexs[i], 3);
            row[4] = model2.getValueAt(indexs[i], 4);
            row[5] = model2.getValueAt(indexs[i], 5);
            row[6] = model2.getValueAt(indexs[i], 6);
            row[7] = model2.getValueAt(indexs[i], 7);
            row[8] = model2.getValueAt(indexs[i], 8);
            row[9] = model2.getValueAt(indexs[i], 9);
            
            model6.addRow(row);
        }
        samL.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private boolean ID_validateFields(){
      
        if(txtsessionid.getSelectedItem().toString() == "")
        {
            JOptionPane.showMessageDialog(this,"Select the relevant session ID for the session time allocation");
            txtsessionid.requestFocus();
           
            return false;
        }
        
        if(txtday.getSelectedItem().toString() == ""){
            JOptionPane.showMessageDialog(this,"Select the relevant working day for the session time allocation");
            txtday.requestFocus();
           
            return false;
        }
        
        if((Integer)txtstarthour.getValue() == 0)
        {
            JOptionPane.showMessageDialog(this,"Enter the hour of the starting time for the session time allocation");
            txtstarthour.requestFocus();
           
            return false;
        }
        
        if((Integer)txtendhour.getValue() == 0)
        {
            JOptionPane.showMessageDialog(this,"Enter the hour of the end time for the session time allocation");
            txtendhour.requestFocus();
           
            return false;
        }
        
        return true;
    }
    
    private void btn_NotAvailable_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NotAvailable_AddActionPerformed
        // TODO add your handling code here:
        String session_id = txtsessionid.getSelectedItem().toString();
        String workingday = txtday.getSelectedItem().toString();
        Integer starthour = (Integer)txtstarthour.getValue();
        Integer startminute = (Integer)txtstartminute.getValue();
        Integer endhour = (Integer)txtendhour.getValue();
        Integer endminute = (Integer)txtendminutes.getValue();
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/university","root","");
            insert = con.prepareStatement("insert into notavailable_session (session_ID,workingday,NotAvailable_start_hr,NotAvailable_start_min,NotAvailable_end_hr,NotAvailable_end_min)values(?,?,?,?,?,?)");
            
            insert.setString(1, session_id);
            insert.setString(2, workingday);
            insert.setInt(3, starthour);
            insert.setInt(4, startminute);
            insert.setInt(5, endhour);
            insert.setInt(6, endminute);
            
            insert.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Successfully not available time inserted for the session");
            table_update();
            
            // To clear the rcords in the form
            txtsessionid.setSelectedIndex(0);
            txtday.setSelectedIndex(0);
            txtstarthour.setValue(0);
            txtstartminute.setValue(0);
            txtendhour.setValue(0);
            txtendminutes.setValue(0);
            txtsessionid.requestFocus(); 
            
            
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_NotAvailable_AddActionPerformed

    private void btn_NotAvailable_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NotAvailable_UpdateActionPerformed
        // TODO add your handling code here:
        TableModel model = sessiontab.getModel();
        int j = sessiontab.getSelectedRow();   // to get the data in form when the row is selected
        
        if(j == -1){
            JOptionPane.showMessageDialog(this,"Select the session from the table you want to update");
        }
        
        else{
        try {

            String session_id = txtsessionid.getSelectedItem().toString();
            String workingday = txtday.getSelectedItem().toString();
            Integer starthour = (Integer)txtstarthour.getValue();
            Integer startminute = (Integer)txtstartminute.getValue();
            Integer endhour = (Integer)txtendhour.getValue();
            Integer endminute = (Integer)txtendminutes.getValue();
            
            int dialogResult = JOptionPane.showConfirmDialog(null,"Do you want to update this record of Not Available time for session ?","Warning",JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {

                Class.forName("com.mysql.jdbc.Driver");

                con= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");

                insert = con.prepareStatement("update notavailable_session set workingday=?, NotAvailable_start_hr=?, NotAvailable_start_min=?, NotAvailable_end_hr=?, NotAvailable_end_min=? where session_ID=? ");

                insert.setString(1, workingday);
                insert.setInt(2, starthour);
                insert.setInt(3, startminute);
                insert.setInt(4, endhour);
                insert.setInt(5, endminute);
                insert.setString(6, session_id);

                insert.executeUpdate();

                JOptionPane.showMessageDialog(this,"record of Not Available time for session is Updated");
                table_update();

                // To clear the rcords in the form
                txtsessionid.setSelectedIndex(0);
                txtday.setSelectedIndex(0);
                txtstarthour.setValue(0);
                txtstartminute.setValue(0);
                txtendhour.setValue(0);
                txtendminutes.setValue(0);
                txtsessionid.requestFocus(); 

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      } 
    }//GEN-LAST:event_btn_NotAvailable_UpdateActionPerformed

    private void btn_NotAvailable_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NotAvailable_DeleteActionPerformed
        // TODO add your handling code here:
        TableModel model = sessiontab.getModel();
        int j = sessiontab.getSelectedRow();   // to get the data in form when the row is selected
        
        if(j == -1){
            JOptionPane.showMessageDialog(this,"Select the session from the table you want to delete");
        }
        
        else{
        try {

            String session_id = txtsessionid.getSelectedItem().toString();
            
            int dialogResult = JOptionPane.showConfirmDialog(null,"Do you want to delete this record of Not Available time for session ?","Warning",JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {

                Class.forName("com.mysql.jdbc.Driver");

                con= DriverManager.getConnection("jdbc:mysql://localhost/university","root","");

                insert = con.prepareStatement("delete from notavailable_session where session_ID=? ");

                insert.setString(1, session_id);

                insert.executeUpdate();

                JOptionPane.showMessageDialog(this,"record of Not Available time for session is Deleted");
                table_update();

                // To clear the rcords in the form
                txtsessionid.setSelectedIndex(0);
                txtday.setSelectedIndex(0);
                txtstarthour.setValue(0);
                txtstartminute.setValue(0);
                txtendhour.setValue(0);
                txtendminutes.setValue(0);
                txtsessionid.requestFocus(); 

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessionsTime.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      }
    }//GEN-LAST:event_btn_NotAvailable_DeleteActionPerformed

    private void sessiontabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sessiontabMouseClicked
        // TODO add your handling code here:
        TableModel model = sessiontab.getModel();
        int j = sessiontab.getSelectedRow();   // to get the data in form when the row is selected
        
        Object o = sessiontab.getValueAt(j, 0);
        txtsessionid.setSelectedItem(o);
        
        String day = model.getValueAt(j, 1).toString();
        switch(day){
            case "Monday":
                txtday.setSelectedIndex(1);
                break;
            case "Tuesday":
                txtday.setSelectedIndex(2);
                break;
            case "Wednesday":
                txtday.setSelectedIndex(3);
                break;
            case "Thursday":
                txtday.setSelectedIndex(4);
                break;
            case "Friday":
                txtday.setSelectedIndex(5);
                break;
            case "Saturday":
                txtday.setSelectedIndex(6);
                break;
            case "Sunday":
                txtday.setSelectedIndex(7);
                break;
        }
        
        txtstarthour.setValue(model.getValueAt(j, 2));
        txtstartminute.setValue(model.getValueAt(j, 3));
        
        txtendhour.setValue(model.getValueAt(j, 4));
        txtendminutes.setValue(model.getValueAt(j, 5));
    }//GEN-LAST:event_sessiontabMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        TableModel model3 = parallel.getModel();
        int indexs[] = parallel.getSelectedRows();
        
        Object[] row = new Object[10];
        
        sampleParallel samP = new sampleParallel();
        DefaultTableModel model7 = (DefaultTableModel)samP.paral.getModel();
        
        for(int i = 0; i < indexs.length; i++)
        {
            row[0] = model3.getValueAt(indexs[i], 0);
            row[1] = model3.getValueAt(indexs[i], 1);
            row[2] = model3.getValueAt(indexs[i], 2);
            row[3] = model3.getValueAt(indexs[i], 3);
            row[4] = model3.getValueAt(indexs[i], 4);
            row[5] = model3.getValueAt(indexs[i], 5);
            row[6] = model3.getValueAt(indexs[i], 6);
            row[7] = model3.getValueAt(indexs[i], 7);
            row[8] = model3.getValueAt(indexs[i], 8);
            row[9] = model3.getValueAt(indexs[i], 9);
            
            model7.addRow(row);
        }
        samP.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(SessionsTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SessionsTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SessionsTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SessionsTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SessionsTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NotAvailableTimes;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btn_NotAvailable_Add;
    private javax.swing.JButton btn_NotAvailable_Delete;
    private javax.swing.JButton btn_NotAvailable_Update;
    private javax.swing.JTable consecutive;
    private javax.swing.JPanel form;
    private javax.swing.JButton home_btn;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable lapping;
    private javax.swing.JTable parallel;
    private javax.swing.JTable sessiontab;
    private javax.swing.JComboBox<String> txtday;
    private javax.swing.JSpinner txtendhour;
    private javax.swing.JSpinner txtendminutes;
    private javax.swing.JComboBox<String> txtsessionid;
    private javax.swing.JSpinner txtstarthour;
    private javax.swing.JSpinner txtstartminute;
    // End of variables declaration//GEN-END:variables
}
