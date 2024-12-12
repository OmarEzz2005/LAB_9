/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import BackEnd.UserAccount;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

/**
 *
 * @author lenovo
 */
public class ViewFriendSuggestion extends javax.swing.JPanel {

    /**
     * Creates new form ViewFriends
     */
    public ViewFriendSuggestion() {
        initComponents();
        addToTable();
        
    }

    
    public void addToTable()
    {
        
        ArrayList<UserAccount> friends = LOGIN.database.getCurrentUser().getFriendSuggestions();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        if( friends == null || friends.isEmpty())
        {
           // System.out.println("Here");
            Object[] row = new Object[2];
            row[0] = "No Suggestions";
            row[1] = "";
            model.addRow(row);
            return;
        }
        
        //System.out.println("Requests"+requests.get(0).getUsername());
        for (UserAccount c : friends) {
            
            Object[] row = new Object[2];
            row[0] = c.getUsername();
            row[1] = c.getStatus();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        SendRequest = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "UserName", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        SendRequest.setText("Send Friend request");
        SendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(Back)
                        .addGap(51, 51, 51)
                        .addComponent(SendRequest)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back)
                    .addComponent(SendRequest))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        Newsfeed admin = new Newsfeed();
        admin.setVisible(true);
        
        
         LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(Back);
        if (parentFrame != null) {
            parentFrame.setContentPane(admin);
            parentFrame.revalidate(); 
            parentFrame.repaint();
            parentFrame.pack();
        }
    }//GEN-LAST:event_BackActionPerformed

    private void SendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
                String username = (String) jTable1.getValueAt(selectedRow, 0);
                if(username.equals("No Suggestions"))
                {
                    JOptionPane.showMessageDialog(null,"No friend request to accept !!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (LOGIN.database.getCurrentUser().isFriends(username)) {
                JOptionPane.showMessageDialog(this, "You are already friends");
                return;
                } else {
                boolean done = LOGIN.database.getCurrentUser().sendFriendRequest(username);
                    if (done) {
                        JOptionPane.showMessageDialog(this, "Friend Request sent to " + username + " Successfully ");
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.removeRow(selectedRow);
                        if (model.getRowCount() == 0) {
                        Object[] row = new Object[2];
                        row[0] = "No Suggestions";
                        row[1] = "";
                        model.addRow(row);
                        }
                    } else {
                    JOptionPane.showMessageDialog(this, " User not found ");
                    }     
                }      
        }
        
        
        
    }//GEN-LAST:event_SendRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton SendRequest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
