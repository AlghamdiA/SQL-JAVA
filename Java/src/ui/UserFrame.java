/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import db.DBManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amav22
 */
public class UserFrame extends javax.swing.JFrame {

    /**
     * Creates new form UserFrame
     */
    DBManager DB;
    String user_id;
    String[] Mycolumns=new String [] {
                "ID", "Title", "Description", "Price", "Status", "Date"};
    String[] Allcolumns=new String [] {
                "Title", "Description", "Price", "Date"};
    public UserFrame(DBManager DB, String user_id) {
        
        this.setTitle("Username" +" "+ user_id);
        this.DB=DB;
        this.user_id = user_id;
        initComponents();
        this.populate_myAdvertisements_table(); // All the user 
        this.populate_AllAdvertisements_table(); // All the user AddAdvertisement
    }
    
         
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        AddAdvertisement_button = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        search_box = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Advertisements_table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MyAdvertisements_table = new javax.swing.JTable();
        deleteUser_button = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddAdvertisement_button.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        AddAdvertisement_button.setText("Add Advertisement");
        AddAdvertisement_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAdvertisement_buttonActionPerformed(evt);
            }
        });

        jTabbedPane2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        search_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_boxActionPerformed(evt);
            }
        });
        search_box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_boxKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Title, Description:");

        Advertisements_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Description", "Price", "Date"
            }
        ));
        jScrollPane1.setViewportView(Advertisements_table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_box, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(search_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        search_box.getAccessibleContext().setAccessibleName("");
        search_box.getAccessibleContext().setAccessibleDescription("write advertisements title to find advertisements");
        search_box.getAccessibleContext().setAccessibleParent(this);

        jTabbedPane2.addTab(" Advertisements      ", jPanel1);

        MyAdvertisements_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Description", "Price", "Status", "Date"
            }
        ));
        jScrollPane2.setViewportView(MyAdvertisements_table);

        deleteUser_button.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        deleteUser_button.setText("Delete");
        deleteUser_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUser_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteUser_button, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(deleteUser_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("My Advertisements        ", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AddAdvertisement_button)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(AddAdvertisement_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddAdvertisement_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAdvertisement_buttonActionPerformed
        // TODO add your handling code here:
        AddAdvtFrame addFrame=new AddAdvtFrame(this,DB,user_id);
        addFrame.setVisible(true);
        
    }//GEN-LAST:event_AddAdvertisement_buttonActionPerformed

    private void search_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_boxActionPerformed

    private void deleteUser_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUser_buttonActionPerformed
        // TODO add your handling code here:
        
        int row = this.MyAdvertisements_table.getSelectedRow();
        boolean result=false;
        if(row>=0){
            String advertisement_id=(String)MyAdvertisements_table.getValueAt(row, 0);
            result=DB.deleteadvertisement(advertisement_id, user_id);
        }
        
        if(result){
             JOptionPane.showMessageDialog(this,
    "The advertisement was deleted correctly",
    "Confirmation",
    JOptionPane.INFORMATION_MESSAGE);
        }
        populate_myAdvertisements_table();
    }//GEN-LAST:event_deleteUser_buttonActionPerformed

    private void search_boxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_boxKeyReleased
        // TODO add your handling code here:
        Object[][] accounts_data=DB.getAdvertisements(this.search_box.getText());
        this.Advertisements_table.setModel(new DefaultTableModel(accounts_data,Allcolumns));
    }//GEN-LAST:event_search_boxKeyReleased
        //// Show user Advertisements
    public void populate_myAdvertisements_table(){
    Object[][] advertisements_data=DB.getMyAdvertisements(user_id);
    this.MyAdvertisements_table.setModel(new DefaultTableModel(advertisements_data,Mycolumns));
    /**
     * @param args the command line arguments
     */
  
    
    }
    public void populate_AllAdvertisements_table(){
    Object[][] advertisements_data=DB.getAllAdvertisements();
    this.Advertisements_table.setModel(new DefaultTableModel(advertisements_data,Allcolumns));
    /**
     * @param args the command line arguments
     */
  
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAdvertisement_button;
    private javax.swing.JTable Advertisements_table;
    private javax.swing.JTable MyAdvertisements_table;
    private javax.swing.JButton deleteUser_button;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField search_box;
    // End of variables declaration//GEN-END:variables
}
