/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import BackEnd.Group;
import BackEnd.Post;
import BackEnd.UserAccount;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yaseen
 */
public class GroupCurrentPosts extends javax.swing.JPanel {

    /**
     * Creates new form GroupCurrentPosts
     */
    public GroupCurrentPosts(String username) {
        initComponents();
        Group group=LOGIN.groupdatabase.getRecord(username);
        ArrayList <Post> currentuserslist=new ArrayList<>();
        currentuserslist=group.getObjectPost();
        addToTable(currentuserslist);
    }
    public void addToTable(ArrayList<Post> currentuserslist)
    {
        
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        if( currentuserslist == null || currentuserslist.isEmpty())
        {
            System.out.println("Here");
            Object[] row = new Object[2];
            row[0] = "No requests";
            row[1] = "";
            model.addRow(row);
            return;
        }
        
        //System.out.println("Requests"+requests.get(0).getUsername());
        for (Post c : currentuserslist) {
            
            Object[] row = new Object[1];
            row[0] = c.getContentId();
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Group Current Posts"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Show");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (LOGIN.database.getCurrentUser().isCreatorGroup(Newsfeed.groupC)) {
            GroupCreatorManagment page =new GroupCreatorManagment();
            page.setVisible(true);
            LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(jButton3);
        if (parentFrame != null) {
            parentFrame.setContentPane(page);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
        } else {
            GroupAdminManagment page = new GroupAdminManagment();
            page.setVisible(true);
            LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(jButton3);
        if (parentFrame != null) {
            parentFrame.setContentPane(page);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String username = (String) jTable1.getValueAt(selectedRow, 0);
            Newsfeed.PostC=username;
            if(username.equals("No requests"))
            {
                JOptionPane.showMessageDialog(null,"No post to show !!","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String username = (String) jTable1.getValueAt(selectedRow, 0);

            if (username.equals("No requests")) {
                JOptionPane.showMessageDialog(null, "No Posts to delete !!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            LOGIN.groupdatabase.getRecord(Newsfeed.groupC).getPosts().remove(username);
            LOGIN.groupdatabase.saveToFile();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(selectedRow);
            if (model.getRowCount() == 0) {
                Object[] row = new Object[2];
                row[0] = "No requests";
                row[1] = "";
                model.addRow(row);
            }
            JOptionPane.showMessageDialog(null, "You deleted the Post", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
