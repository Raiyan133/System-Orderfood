/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author yomi chan
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }
    String uname;
    public Home(String val1){
        initComponents();
        
        this.uname=val1;
        
        
        Adddata();   
    }

    void Adddata(){
        
        this.uuname.setText(""+uname);
             
    }
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        Order = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        uuname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setMinimumSize(new java.awt.Dimension(610, 350));
        setPreferredSize(new java.awt.Dimension(610, 380));
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Action Man Shaded", 1, 60)); // NOI18N
        jLabel4.setText("W E L C O M E");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, 60));

        Order.setBackground(new java.awt.Color(0, 0, 0));
        Order.setForeground(new java.awt.Color(255, 51, 0));
        Order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Order.png"))); // NOI18N
        Order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderActionPerformed(evt);
            }
        });
        getContentPane().add(Order, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        Add.setBackground(new java.awt.Color(0, 0, 0));
        Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ADD.png"))); // NOI18N
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("teddy", 1, 24)); // NOI18N
        jLabel2.setText("Order Menu");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 140, 20));

        jLabel3.setFont(new java.awt.Font("teddy", 1, 24)); // NOI18N
        jLabel3.setText("Add Menu");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 90, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/125.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(630, 361));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, -1));

        uuname.setText("jTextField1");
        getContentPane().add(uuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        String uname = uuname.getText();
        new ProfileCustomer(uname).setVisible(true);
        
    }//GEN-LAST:event_OrderActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        TableAdd ob=new TableAdd();
        ob.setVisible(true);
    }//GEN-LAST:event_AddActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Order;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField uuname;
    // End of variables declaration//GEN-END:variables
}
