/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jana
 */
import fms.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class course_details extends javax.swing.JFrame {
    
    DefaultTableModel model;

    /**
     * Creates new form course_details
     */
    public course_details() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setRecordTable();
       
    }
    
    public void setRecordTable()
      {
          
          try{
              Connection conn=ConnectionProvider.getConnection();
              PreparedStatement pst=conn.prepareStatement("select *from course");
              ResultSet rs=pst.executeQuery();
              while(rs.next()){
                  /*int Receipt_no=rs.getInt("rno");
                  String Student_name=rs.getString("receivedfrom");
                  String USN=rs.getString("USN");
                  String Course=rs.getString("course");
                  String UPI=rs.getString("UPI");
                  String Bank_name=rs.getString("bankname");
                  int From_year=rs.getInt("yearfrom");
                  int To_year=rs.getInt("yearto");
                  int Total_amount=rs.getInt("total");
                  String In_words=rs.getString("twords");
                  String remarks=rs.getString("remarks");
                  String date=rs.getString("tdate");/*
                  
                  */
                  int sl_no=rs.getInt("courseid");
                  String Course_name=rs.getString("coursename");
                  int fee=rs.getInt("fees");
                  
                  //Object[] obj={Receipt_no,Student_name,USN,Course,UPI,Bank_name,From_year,To_year,Total_amount,In_words,remarks,date};
                  Object[] obj={sl_no,Course_name,fee};
                  model=(DefaultTableModel)coursetable.getModel();
                  model.addRow(obj);
                  
                  
              }
          }
          catch(Exception e){
              e.printStackTrace();
          }
          
      }
    
    public void clear(){
        DefaultTableModel model=(DefaultTableModel)coursetable.getModel();
        model.setRowCount(0);
    }
    public void addCourse(int id,String cname,int fee){
        try{
            Connection conn=ConnectionProvider.getConnection();
            PreparedStatement pst=conn.prepareStatement("insert into course values(?,?,?)");
            pst.setInt(1, id);
            pst.setString(2,cname);
            pst.setInt(3,fee);
            
            int rowcount=pst.executeUpdate();
            
            if(rowcount==1){
                 Object[] obj={id,cname,fee};
                  model=(DefaultTableModel)coursetable.getModel();
                  model.addRow(obj);
                JOptionPane.showMessageDialog(null,"Successfully inserted");
                
            }
            else{
                JOptionPane.showMessageDialog(null,"insertion failed");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"insertion failed");
            e.printStackTrace();
        }
        
    }
    
    public void update(int id,String cname,int fee){
        try{
            Connection conn=ConnectionProvider.getConnection();
            PreparedStatement pst=conn.prepareStatement("update course set coursename=?,fees=? where courseid=?");
           
            pst.setString(1,cname);
            pst.setInt(2,fee);
            pst.setInt(3,id);
            
            int rowcount=pst.executeUpdate();
            if(rowcount==1){
                
                JOptionPane.showMessageDialog(null,"Successfully updated");
                clear();
                setRecordTable();
            }
            else{
                JOptionPane.showMessageDialog(null,"updation  failed");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"updation failed");
            e.printStackTrace();
        }
    }
    
    public void delete(int id){
        try{
            Connection conn=ConnectionProvider.getConnection();
            PreparedStatement pst=conn.prepareStatement("delete from course where courseid=?");
           
            
            
            pst.setInt(1, id);
            int rowcount=pst.executeUpdate();
            if(rowcount==1){
                
                JOptionPane.showMessageDialog(null,"Successfully deleted");
                clear();
                setRecordTable();
            }
            else{
                JOptionPane.showMessageDialog(null,"deletion  failed");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"deletion failed");
            e.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        coursetable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        tslno = new javax.swing.JTextField();
        tcname = new javax.swing.JTextField();
        tfee = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        coursetable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        coursetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course_id", "Course_name", "Fees"
            }
        ));
        coursetable.setShowGrid(true);
        coursetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coursetableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(coursetable);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sl No.:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 83, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course name:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fees:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 179, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 51, 51));
        jButton4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("INSERT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 273, -1, -1));

        jButton5.setBackground(new java.awt.Color(0, 51, 51));
        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        jButton6.setBackground(new java.awt.Color(0, 51, 51));
        jButton6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("UPDATE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        tslno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tslnoActionPerformed(evt);
            }
        });
        jPanel3.add(tslno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 210, -1));
        jPanel3.add(tcname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 210, -1));
        jPanel3.add(tfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 210, -1));

        jButton7.setBackground(new java.awt.Color(0, 51, 51));
        jButton7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wback.png"))); // NOI18N
        jButton7.setText("BACK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 51, 51));
        jButton8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/log.png"))); // NOI18N
        jButton8.setText("LOGOUT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(189, 189, 189))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(178, 178, 178))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tslnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tslnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tslnoActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       new home().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void coursetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coursetableMouseClicked
      int rowno=coursetable.getSelectedRow();
      TableModel model=coursetable.getModel();
      tslno.setText(model.getValueAt(rowno,0).toString());
      tcname.setText((String)model.getValueAt(rowno,1));
      tfee.setText(model.getValueAt(rowno,2).toString());
    }//GEN-LAST:event_coursetableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int id=Integer.parseInt(tslno.getText());
       String cname=tcname.getText();
       int fee=Integer.parseInt(tfee.getText());
       addCourse(id,cname,fee);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int id=Integer.parseInt(tslno.getText());
       String cname=tcname.getText();
       int fee=Integer.parseInt(tfee.getText());
       update(id,cname,fee);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       int id=Integer.parseInt(tslno.getText());
       //String cname=tcname.getText();
       //int fee=Integer.parseInt(tfee.getText());
       delete(id);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(course_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(course_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(course_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(course_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new course_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable coursetable;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tcname;
    private javax.swing.JTextField tfee;
    private javax.swing.JTextField tslno;
    // End of variables declaration//GEN-END:variables
}
