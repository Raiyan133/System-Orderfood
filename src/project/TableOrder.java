/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import classfood.Icecream;
import classfood.fastfood;
import classfood.juice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author yomi chan
 */
public class TableOrder extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
               

    /**
     * Creates new form Table2
     */
    public TableOrder() {
        initComponents();
        getConnection();
        JTable_I();
        JTable_F();
        JTable_Ju();        
    }
    
    
    
    
    
    
    
    
    
    String idp, namep, nump,numt,date,uname, sum;
    
    public TableOrder(String val1, String val2,String val3, String val4, String val5, String val6){
        initComponents();
        getConnection();
        JTable_I();
        JTable_F();
        JTable_Ju();
        
        this.idp=val1;
        this.namep=val2;
        this.nump=val3;
        this.numt=val4;
        this.date=val5;
        this.uname=val6;
        
        Adddata();   
    }

    void Adddata(){
        
        this.idpp.setText(""+idp);
        this.namepp.setText(""+namep);
        this.numppp.setText(""+nump);
        this.numtpp.setText(""+numt);
        this.datepp.setText(""+date);  
        this.uuname.setText(""+uname);      
    }
   
    public Connection getConnection()
    {
        Connection con = null;
       
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/order?zeroDateTimeBehavior=convertToNull","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(TableOrder.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /////////////////// I  C  E    C  R  E  A  M //////////////////
    
    
 
    // get a list of users from mysql database
   public ArrayList<Icecream> getIcecreamList()
   {
       ArrayList<Icecream> IcecreamsList = new ArrayList<Icecream>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM `IceCream` ";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           Icecream NewI;
           while(rs.next())
           {
               NewI = new Icecream(rs.getInt("ID_I"),rs.getString("Name_I"),rs.getInt("Price_I"));
               IcecreamsList.add(NewI);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return IcecreamsList;
   }
   
   
    public void JTable_I()
   {
       ArrayList<Icecream> list = getIcecreamList();
       DefaultTableModel model = (DefaultTableModel)Table_I.getModel();
       Object[] row = new Object[3];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getId();
           row[1] = list.get(i).getName();
           row[2] = list.get(i).getPrice();
           
           
           model.addRow(row);
       }
    }
    
    
     // Execute The Insert Update And Delete Querys
  
    public void executeSQlQuery_I(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)Table_I.getModel();
               model.setRowCount(0);
               JTable_I();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
    
   
    
    /////////////////// F  A  S  T      F  O  O  D //////////////////
  
    // get a list of users from mysql database
   public ArrayList<fastfood> getfastfoodList()
   {
       ArrayList<fastfood> fastfoodsList = new ArrayList<fastfood>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM `FastFood`";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           fastfood NewF;
           while(rs.next())
           {
               NewF = new fastfood(rs.getInt("ID_F"),rs.getString("Name_F"),rs.getInt("Price_F"));
               fastfoodsList.add(NewF);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return fastfoodsList;
   }
   
   
    public void JTable_F()
   {
       ArrayList<fastfood> list = getfastfoodList();
       DefaultTableModel model = (DefaultTableModel)Table_F.getModel();
       Object[] row = new Object[3];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getId();
           row[1] = list.get(i).getName();
           row[2] = list.get(i).getPrice();
           
           
           model.addRow(row);
       }
    }
    
    
     // Execute The Insert Update And Delete Querys
  
    public void executeSQlQuery_F(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)Table_F.getModel();
               model.setRowCount(0);
               JTable_F();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
    
    
    /////////////////// J   U   I   C   E //////////////////
  
    // get a list of users from mysql database
   public ArrayList<juice> getjuiceList()
   {
       ArrayList<juice> juiceList = new ArrayList<juice>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM `Juice`";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           juice NewJ;
           while(rs.next())
           {
               NewJ = new juice(rs.getInt("ID_J"),rs.getString("Name_J"),rs.getInt("Price_J"));
               juiceList.add(NewJ);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return juiceList;
   }
   
   
    public void JTable_Ju()
   {
       ArrayList<juice> list = getjuiceList();
       DefaultTableModel model = (DefaultTableModel)Table_Ju.getModel();
       Object[] row = new Object[3];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getId();
           row[1] = list.get(i).getName();
           row[2] = list.get(i).getPrice();
           
           
           model.addRow(row);
       }
    }
    
    
     // Execute The Insert Update And Delete Querys
  
    public void executeSQlQuery_J(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)Table_Ju.getModel();
               model.setRowCount(0);
               JTable_Ju();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
    
    
    
    
   
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datepp = new javax.swing.JTextField();
        namepp = new javax.swing.JTextField();
        numppp = new javax.swing.JTextField();
        uuname = new javax.swing.JTextField();
        idpp = new javax.swing.JTextField();
        numtpp = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_I = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_F = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_Ju = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Total = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Cancel = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table_C = new javax.swing.JTable();
        Total_A = new javax.swing.JTextField();
        Summery = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(826, 500));

        uuname.setText("jTextField1");

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        Table_I.setBackground(new java.awt.Color(255, 204, 255));
        Table_I.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table_I.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_IMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_I);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 560, 330));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ice-Cream22-icon.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ice-Cream22-icon.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Action Man Shaded", 1, 60)); // NOI18N
        jLabel3.setText("Ice Cream");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jTabbedPane1.addTab("Ice Cream", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 135));
        jPanel4.setLayout(null);

        Table_F.setBackground(new java.awt.Color(255, 204, 102));
        Table_F.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table_F.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_FMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_F);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(60, 40, 460, 210);

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 560, 330));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fast-Food22-icon (1).png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fast-Food22-icon (1).png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Action Man Shaded", 1, 60)); // NOI18N
        jLabel6.setText("Fast Food");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jTabbedPane1.addTab("Fast Food", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 153));

        Table_Ju.setBackground(new java.awt.Color(255, 204, 204));
        Table_Ju.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table_Ju.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_JuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Table_Ju);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 560, 330));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Juice-icon 22.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Juice-icon 22.png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Action Man Shaded", 1, 70)); // NOI18N
        jLabel9.setText("Juice");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        jTabbedPane1.addTab("Juice", jPanel5);

        jPanel7.setBackground(new java.awt.Color(204, 51, 0));

        Total.setBackground(new java.awt.Color(255, 153, 153));
        Total.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Total.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CCCC.png"))); // NOI18N
        Total.setText("Total");
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("teddy", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ORDER FOODS");

        Cancel.setFont(new java.awt.Font("teddy", 1, 20)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        Table_C.setBackground(new java.awt.Color(255, 153, 51));
        Table_C.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table_C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_CMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Table_C);

        Summery.setFont(new java.awt.Font("teddy", 0, 20)); // NOI18N
        Summery.setText("Summery");
        Summery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SummeryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Summery, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(Total))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel10))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(Total_A, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Total_A, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Summery, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(329, Short.MAX_VALUE)
                    .addComponent(numtpp, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(434, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 433, Short.MAX_VALUE)
                    .addComponent(numppp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 434, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 433, Short.MAX_VALUE)
                    .addComponent(datepp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 434, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 433, Short.MAX_VALUE)
                    .addComponent(namepp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 434, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(398, 398, 398)
                    .addComponent(uuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(399, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(328, 328, 328)
                    .addComponent(idpp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(432, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 32, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(239, Short.MAX_VALUE)
                    .addComponent(numtpp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(239, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(numppp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(datepp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(namepp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(239, 239, 239)
                    .addComponent(uuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(239, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(239, 239, 239)
                    .addComponent(idpp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(239, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        int sum=0;
        for (int i = 0; i < Table_C.getRowCount(); i++){
        sum+=Integer.parseInt(Table_C.getValueAt(i, 2).toString());   
        }
        Total_A.setText(sum+".0");
    }//GEN-LAST:event_TotalActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home ob=new Home();
        ob.setVisible(true);
    }//GEN-LAST:event_CancelActionPerformed

    private void SummeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SummeryActionPerformed
        setVisible(false);
        
        
        String idp = idpp.getText();
        String namep = namepp.getText();
        String nump = numppp.getText();
        String numt = numtpp.getText();
        String date = datepp.getText();
        String uname = uuname.getText();
        String sum = Total_A.getText();
        
        
        
        
        
        
        
      
   
       
            
       
        new Total(idp, namep, nump,numt,date,uname, sum).setVisible(true);
    }//GEN-LAST:event_SummeryActionPerformed

    private void Table_IMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_IMouseClicked
        TableModel model1 = Table_I.getModel();
        int[] indexs1 = Table_I.getSelectedRows();
        Object[] row = new Object[3];
        DefaultTableModel model2 = (DefaultTableModel)Table_C.getModel();
        
        for(int i = 0 ; i < indexs1.length;i++)
        {
            row[0]= model1.getValueAt(indexs1[i], 0);
            row[1]= model1.getValueAt(indexs1[i], 1);
            row[2]= model1.getValueAt(indexs1[i], 2);
            
            model2.addRow(row);
            
        }
    }//GEN-LAST:event_Table_IMouseClicked

    private void Table_FMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_FMouseClicked
        TableModel model1 = Table_F.getModel();
        int[] indexs1 = Table_F.getSelectedRows();
        Object[] row = new Object[3];
        DefaultTableModel model2 = (DefaultTableModel)Table_C.getModel();
        
        for(int i = 0 ; i < indexs1.length;i++)
        {
            row[0]= model1.getValueAt(indexs1[i], 0);
            row[1]= model1.getValueAt(indexs1[i], 1);
            row[2]= model1.getValueAt(indexs1[i], 2);
            
            model2.addRow(row);
            
        }
    }//GEN-LAST:event_Table_FMouseClicked

    private void Table_JuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_JuMouseClicked
        TableModel model1 = Table_Ju.getModel();
        int[] indexs1 = Table_Ju.getSelectedRows();
        Object[] row = new Object[3];
        DefaultTableModel model2 = (DefaultTableModel)Table_C.getModel();
        
        for(int i = 0 ; i < indexs1.length;i++)
        {
            row[0]= model1.getValueAt(indexs1[i], 0);
            row[1]= model1.getValueAt(indexs1[i], 1);
            row[2]= model1.getValueAt(indexs1[i], 2);
            
            model2.addRow(row);
            
        }
    }//GEN-LAST:event_Table_JuMouseClicked

    private void Table_CMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_CMouseClicked
        DefaultTableModel model2 = (DefaultTableModel)Table_C.getModel();
        try{
            int SelectedRowIndex = Table_C.getSelectedRow();
            model2.removeRow(SelectedRowIndex);
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null,ex);
           }
               
    }//GEN-LAST:event_Table_CMouseClicked

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
            java.util.logging.Logger.getLogger(TableOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    public javax.swing.JButton Summery;
    public javax.swing.JTable Table_C;
    private javax.swing.JTable Table_F;
    private javax.swing.JTable Table_I;
    private javax.swing.JTable Table_Ju;
    private javax.swing.JButton Total;
    private javax.swing.JTextField Total_A;
    private javax.swing.JTextField datepp;
    private javax.swing.JTextField idpp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField namepp;
    private javax.swing.JTextField numppp;
    private javax.swing.JTextField numtpp;
    private javax.swing.JTextField uuname;
    // End of variables declaration//GEN-END:variables

    
}
