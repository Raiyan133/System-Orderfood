package project;

import classfood.Icecream;
import classfood.fastfood;
import classfood.juice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yomi chan
 */
public class TableAdd extends javax.swing.JFrame {
    
    
    /**
     * Creates new form Bingsu
     */
    public TableAdd() {
        initComponents();
        getConnection();
        JTable_I();
        JTable_F();
        JTable_Ju();
    }
    
    public Connection getConnection()
    {
        Connection con = null;
       
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/order?zeroDateTimeBehavior=convertToNull","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(TableAdd.class.getName()).log(Level.SEVERE, null, ex);
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
       DefaultTableModel model = (DefaultTableModel)DTable_I.getModel();
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
               DefaultTableModel model = (DefaultTableModel)DTable_I.getModel();
               model.setRowCount(0);
               JTable_I();
               
               
           }else{
               
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
       DefaultTableModel model = (DefaultTableModel)DTable_F.getModel();
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
               DefaultTableModel model = (DefaultTableModel)DTable_F.getModel();
               model.setRowCount(0);
               JTable_F();
               
               
           }else{
               
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
       DefaultTableModel model = (DefaultTableModel)DTable_Ju.getModel();
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
               DefaultTableModel model = (DefaultTableModel)DTable_Ju.getModel();
               model.setRowCount(0);
               JTable_Ju();
               
               
           }else{
               
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Add_I = new javax.swing.JButton();
        Update_I = new javax.swing.JButton();
        Delete_I = new javax.swing.JButton();
        Finish1 = new javax.swing.JButton();
        ID_I = new javax.swing.JTextField();
        Name_I = new javax.swing.JTextField();
        Price_I = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DTable_I = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ID_F = new javax.swing.JTextField();
        Name_F = new javax.swing.JTextField();
        Price_F = new javax.swing.JTextField();
        Add_F = new javax.swing.JButton();
        Update_F = new javax.swing.JButton();
        Deleate_F = new javax.swing.JButton();
        Finisg = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DTable_F = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DTable_Ju = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ID_Ju = new javax.swing.JTextField();
        Name_Ju = new javax.swing.JTextField();
        Price_Ju = new javax.swing.JTextField();
        Add_Ju = new javax.swing.JButton();
        Update_Ju = new javax.swing.JButton();
        Delete_J = new javax.swing.JButton();
        Finish = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setPreferredSize(new java.awt.Dimension(800, 500));

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(800, 500));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(800, 500));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel3.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel3.setPreferredSize(new java.awt.Dimension(779, 450));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 51, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 397));

        jLabel4.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 102));
        jLabel4.setText("ID");

        jLabel5.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setText("Name");

        jLabel6.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setText("Price");

        Add_I.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Add_I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Folder-Add-icon.png"))); // NOI18N
        Add_I.setText("Add");
        Add_I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_IActionPerformed(evt);
            }
        });

        Update_I.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Update_I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/05-Edit-icon.png"))); // NOI18N
        Update_I.setText("Update");
        Update_I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_IActionPerformed(evt);
            }
        });

        Delete_I.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Delete_I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Folder-Delete-icon.png"))); // NOI18N
        Delete_I.setText("Delete");
        Delete_I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_IActionPerformed(evt);
            }
        });

        Finish1.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Finish1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Start-Menu-Prorgrams-icon.png"))); // NOI18N
        Finish1.setText("Finish");
        Finish1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Finish1ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("teddy", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("CREATE YOUR");

        jLabel24.setFont(new java.awt.Font("teddy", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("OWN ICE CREAM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Price_I)
                                .addComponent(Name_I)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(29, 29, 29)
                            .addComponent(ID_I, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Update_I, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(Finish1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(jLabel24))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel23))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(Add_I, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Delete_I, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ID_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Name_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Price_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_I)
                    .addComponent(Delete_I))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Update_I)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Finish1)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 240, 430));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ice-Cream22-icon.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Action Man Shaded", 1, 65)); // NOI18N
        jLabel2.setText("Ice Cream");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ice-Cream22-icon.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 153));

        DTable_I.setBackground(new java.awt.Color(255, 255, 102));
        DTable_I.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DTable_I.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DTable_IMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DTable_I);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 530, 310));

        jTabbedPane1.addTab("Ice Cream", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 153, 0));
        jPanel5.setForeground(new java.awt.Color(255, 153, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(779, 450));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(204, 51, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(195, 444));

        jLabel10.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 153));
        jLabel10.setText("ID");

        jLabel11.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 153));
        jLabel11.setText("Name");

        jLabel12.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 153));
        jLabel12.setText("Price");

        Add_F.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Add_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Folder-Add-icon.png"))); // NOI18N
        Add_F.setText("Add");
        Add_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_FActionPerformed(evt);
            }
        });

        Update_F.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Update_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/05-Edit-icon.png"))); // NOI18N
        Update_F.setText("Update");
        Update_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_FActionPerformed(evt);
            }
        });

        Deleate_F.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Deleate_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Folder-Delete-icon.png"))); // NOI18N
        Deleate_F.setText("Delete");
        Deleate_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Deleate_FActionPerformed(evt);
            }
        });

        Finisg.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Finisg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Start-Menu-Prorgrams-icon.png"))); // NOI18N
        Finisg.setText("Finish");
        Finisg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinisgActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("teddy", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("CREATE YOUR");

        jLabel22.setFont(new java.awt.Font("teddy", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("OWN FAST FOOD");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(Add_F, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Deleate_F, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Update_F, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(Finisg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addComponent(Name_F, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(5, 5, 5)
                        .addComponent(Price_F, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(29, 29, 29)
                        .addComponent(ID_F, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel10))
                    .addComponent(ID_F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel11))
                    .addComponent(Name_F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12))
                    .addComponent(Price_F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_F)
                    .addComponent(Deleate_F))
                .addGap(14, 14, 14)
                .addComponent(Update_F)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Finisg)
                .addContainerGap())
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 240, 430));

        jPanel7.setBackground(new java.awt.Color(255, 255, 153));
        jPanel7.setPreferredSize(new java.awt.Dimension(518, 216));

        DTable_F.setBackground(new java.awt.Color(255, 204, 153));
        DTable_F.setModel(new javax.swing.table.DefaultTableModel(
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
        DTable_F.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DTable_FMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(DTable_F);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 530, 310));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fast-Food22-icon (1).png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Action Man Shaded", 1, 58)); // NOI18N
        jLabel8.setText("Fast Food");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 204, 204));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Fast-Food22-icon (1).png"))); // NOI18N
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jTabbedPane1.addTab("Fast Food", jPanel5);

        jPanel8.setBackground(new java.awt.Color(255, 102, 102));
        jPanel8.setPreferredSize(new java.awt.Dimension(779, 450));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 135));
        jPanel10.setPreferredSize(new java.awt.Dimension(518, 216));

        DTable_Ju.setBackground(new java.awt.Color(255, 204, 204));
        DTable_Ju.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DTable_Ju.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DTable_JuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(DTable_Ju);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 530, 310));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Juice-icon 22.png"))); // NOI18N
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Action Man Shaded", 1, 70)); // NOI18N
        jLabel14.setText("Juice ");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Juice-icon 22.png"))); // NOI18N
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jPanel9.setBackground(new java.awt.Color(0, 204, 102));

        jLabel16.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 51));
        jLabel16.setText("ID");

        jLabel17.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 51));
        jLabel17.setText("Name");

        jLabel18.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 51));
        jLabel18.setText("Price");

        Add_Ju.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Add_Ju.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Folder-Add-icon.png"))); // NOI18N
        Add_Ju.setText("Add");
        Add_Ju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_JuActionPerformed(evt);
            }
        });

        Update_Ju.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Update_Ju.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/05-Edit-icon.png"))); // NOI18N
        Update_Ju.setText("Update");
        Update_Ju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_JuActionPerformed(evt);
            }
        });

        Delete_J.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Delete_J.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Folder-Delete-icon.png"))); // NOI18N
        Delete_J.setText("Delete");
        Delete_J.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_JActionPerformed(evt);
            }
        });

        Finish.setFont(new java.awt.Font("teddy", 1, 18)); // NOI18N
        Finish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Start-Menu-Prorgrams-icon.png"))); // NOI18N
        Finish.setText("Finish");
        Finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("teddy", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("CREATE YOUR ");

        jLabel20.setFont(new java.awt.Font("teddy", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText(" OWN JUICE");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Update_Ju, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Finish, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                            .addComponent(Add_Ju, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Delete_J, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Name_Ju)
                                .addComponent(Price_Ju, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ID_Ju, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel20))
                .addGap(35, 35, 35))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(ID_Ju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Name_Ju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Price_Ju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Ju)
                    .addComponent(Delete_J))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Update_Ju)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Finish)
                .addGap(52, 52, 52))
        );

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 240, 430));

        jTabbedPane1.addTab("Juice ", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home ob=new Home();
        ob.setVisible(true);
    }//GEN-LAST:event_FinishActionPerformed

    private void FinisgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinisgActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home ob=new Home();
        ob.setVisible(true);
    }//GEN-LAST:event_FinisgActionPerformed

    private void Finish1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Finish1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home ob=new Home();
        ob.setVisible(true);
    }//GEN-LAST:event_Finish1ActionPerformed

    private void Add_IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_IActionPerformed
        String Query = "INSERT INTO IceCream (ID_I,Name_I,Price_I)values('"+ID_I.getText()+"','"+Name_I.getText()+"','"+Price_I.getText()+"')";
        executeSQlQuery_I(Query, null);
    }//GEN-LAST:event_Add_IActionPerformed

    private void Update_IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_IActionPerformed
        String query = "UPDATE `IceCream` SET `ID_I`='"+ID_I.getText()+"',`Name_I`='"+Name_I.getText()+"',`Price_I`="+Price_I.getText()+" WHERE `ID_I` = "+ID_I.getText();
        executeSQlQuery_I(query, null);
    }//GEN-LAST:event_Update_IActionPerformed

    private void Delete_IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_IActionPerformed
        String query = "DELETE FROM `IceCream` WHERE ID_I = "+ID_I.getText();
        executeSQlQuery_I(query, null);
    }//GEN-LAST:event_Delete_IActionPerformed

    private void DTable_IMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DTable_IMouseClicked
        int i = DTable_I.getSelectedRow();
        TableModel model = DTable_I.getModel();
        ID_I.setText(model.getValueAt(i,0).toString());
        Name_I.setText(model.getValueAt(i,1).toString());
        Price_I.setText(model.getValueAt(i,2).toString());
    }//GEN-LAST:event_DTable_IMouseClicked

    private void Add_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_FActionPerformed
        String Query = "INSERT INTO FastFood (ID_F,Name_F,Price_F)values('"+ID_F.getText()+"','"+Name_F.getText()+"','"+Price_F.getText()+"')";
        executeSQlQuery_F(Query, null);
    }//GEN-LAST:event_Add_FActionPerformed

    private void Deleate_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Deleate_FActionPerformed
        String query = "DELETE FROM `FastFood` WHERE ID_F = "+ID_F.getText();
        executeSQlQuery_F(query, null);
    }//GEN-LAST:event_Deleate_FActionPerformed

    private void Update_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_FActionPerformed
        String query = "UPDATE `FastFood` SET `ID_F`='"+ID_F.getText()+"',`Name_F`='"+Name_F.getText()+"',`Price_F`="+Price_F.getText()+" WHERE `ID_F` = "+ID_F.getText();
        executeSQlQuery_F(query, null);
    }//GEN-LAST:event_Update_FActionPerformed

    private void DTable_FMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DTable_FMouseClicked
        int i = DTable_F.getSelectedRow();
        TableModel model = DTable_F.getModel();
        ID_F.setText(model.getValueAt(i,0).toString());
        Name_F.setText(model.getValueAt(i,1).toString());
        Price_F.setText(model.getValueAt(i,2).toString());
    }//GEN-LAST:event_DTable_FMouseClicked

    private void Add_JuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_JuActionPerformed
        String Query = "INSERT INTO Juice (ID_J,Name_J,Price_J)values('"+ID_Ju.getText()+"','"+Name_Ju.getText()+"','"+Price_Ju.getText()+"')";
        executeSQlQuery_J(Query, null);
    }//GEN-LAST:event_Add_JuActionPerformed

    private void Delete_JActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_JActionPerformed
        String query = "DELETE FROM `Juice` WHERE ID_J = "+ID_Ju.getText();
        executeSQlQuery_J(query, null);
    }//GEN-LAST:event_Delete_JActionPerformed

    private void Update_JuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_JuActionPerformed
        String query = "UPDATE `Juice` SET `ID_J`='"+ID_Ju.getText()+"',`Name_J`='"+Name_Ju.getText()+"',`Price_J`="+Price_Ju.getText()+" WHERE `ID_J` = "+ID_Ju.getText();
        executeSQlQuery_J(query, null);
    }//GEN-LAST:event_Update_JuActionPerformed

    private void DTable_JuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DTable_JuMouseClicked
        int i = DTable_Ju.getSelectedRow();
        TableModel model = DTable_Ju.getModel();
        ID_Ju.setText(model.getValueAt(i,0).toString());
        Name_Ju.setText(model.getValueAt(i,1).toString());
        Price_Ju.setText(model.getValueAt(i,2).toString());
    }//GEN-LAST:event_DTable_JuMouseClicked

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
            java.util.logging.Logger.getLogger(TableAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_F;
    private javax.swing.JButton Add_I;
    private javax.swing.JButton Add_Ju;
    private javax.swing.JTable DTable_F;
    private javax.swing.JTable DTable_I;
    private javax.swing.JTable DTable_Ju;
    private javax.swing.JButton Deleate_F;
    private javax.swing.JButton Delete_I;
    private javax.swing.JButton Delete_J;
    private javax.swing.JButton Finisg;
    private javax.swing.JButton Finish;
    private javax.swing.JButton Finish1;
    private javax.swing.JTextField ID_F;
    private javax.swing.JTextField ID_I;
    private javax.swing.JTextField ID_Ju;
    private javax.swing.JTextField Name_F;
    private javax.swing.JTextField Name_I;
    private javax.swing.JTextField Name_Ju;
    private javax.swing.JTextField Price_F;
    private javax.swing.JTextField Price_I;
    private javax.swing.JTextField Price_Ju;
    private javax.swing.JButton Update_F;
    private javax.swing.JButton Update_I;
    private javax.swing.JButton Update_Ju;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
