/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import BackEnd.UserAccount;


import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author lenovo
 */
public class FriendManagement extends javax.swing.JPanel{

    /**
     * Creates new form FriendManagement
     */
    
    public UserAccount current;
  
    
    
    
    public FriendManagement(UserAccount current) {
        initComponents();
        this.current = current;
    }
    
    
    
    /*
    public String[] getRequestsData() {

        String[] Data = new String[current.getRequests().toArray().length];
        for (int i = 0; i < current.getRequests().size(); i++) {
            Data[i] = current.getRequests().get(i).LineRepresentation();
        }
        return Data;
    }*/
    
    public String[] getSuggestionData() {

        String[] Data = new String[current.getFriendSuggestions().toArray().length];
        for (int i = 0; i < current.getFriendSuggestions().size(); i++) {
            Data[i] = current.getFriendSuggestions().get(i).getUsername();
        }
        return Data;
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ShowSuggestions = new javax.swing.JButton();
        SendFriendRequest = new javax.swing.JButton();
        RemoveFriend = new javax.swing.JButton();
        ShowRequests = new javax.swing.JButton();
        Block = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        jLabel2.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        ShowSuggestions.setBackground(new java.awt.Color(0, 153, 102));
        ShowSuggestions.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ShowSuggestions.setText("Show Friend Suggestions");
        ShowSuggestions.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ShowSuggestions.setOpaque(true);
        ShowSuggestions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowSuggestionsActionPerformed(evt);
            }
        });

        SendFriendRequest.setBackground(new java.awt.Color(0, 153, 102));
        SendFriendRequest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SendFriendRequest.setText("Send Friend Request");
        SendFriendRequest.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SendFriendRequest.setOpaque(true);
        SendFriendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendFriendRequestActionPerformed(evt);
            }
        });

        RemoveFriend.setBackground(new java.awt.Color(0, 153, 102));
        RemoveFriend.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RemoveFriend.setText("Remove Friend");
        RemoveFriend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RemoveFriend.setOpaque(true);
        RemoveFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveFriendActionPerformed(evt);
            }
        });

        ShowRequests.setBackground(new java.awt.Color(0, 153, 102));
        ShowRequests.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ShowRequests.setText("Show Friend Requests");
        ShowRequests.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ShowRequests.setOpaque(true);
        ShowRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowRequestsActionPerformed(evt);
            }
        });

        Block.setBackground(new java.awt.Color(0, 153, 102));
        Block.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Block.setText("Block User");
        Block.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Block.setOpaque(true);
        Block.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlockActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                                               Friend Managment System     ");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Back)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SendFriendRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(RemoveFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(Block, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ShowSuggestions, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)
                                .addComponent(ShowRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Back)))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SendFriendRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Block, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowSuggestions, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ShowSuggestionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowSuggestionsActionPerformed
        
        ViewFriendSuggestion page = new ViewFriendSuggestion();
        page.setVisible(true);

        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(Back);
        if (parentFrame != null) {
            parentFrame.setContentPane(page);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
        
    }//GEN-LAST:event_ShowSuggestionsActionPerformed

    private void SendFriendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendFriendRequestActionPerformed

        int option = JOptionPane.showConfirmDialog(null, jPanel1, "Send Friend Request ", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String user = jTextField1.getText();
            if(user == null || user.isEmpty())
            {
                return;
            }
            if (current.isFriends(user)) {
                JOptionPane.showMessageDialog(this, "You are already friends");
            } else {
                boolean done = current.sendFriendRequest(user);
                if (done) {
                    JOptionPane.showMessageDialog(this, "Friend Request sent to " + user + " Successfully ");
                } else {
                    JOptionPane.showMessageDialog(this, " User not found ");
                }
            }

        }
    }//GEN-LAST:event_SendFriendRequestActionPerformed

    private void RemoveFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveFriendActionPerformed
        JTextField name = new JTextField();
        Object[] message = {
            "Enter Username:", name
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Remove Friend ", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String user = name.getText();
            if (!current.isFriends(user)) {
                JOptionPane.showMessageDialog(this, "User is not one of your friends");
            } else {
                current.removeFriend(user);
                JOptionPane.showMessageDialog(this, user + " Removed Successfully ");
            }
        }
    }//GEN-LAST:event_RemoveFriendActionPerformed

    private void ShowRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowRequestsActionPerformed
        ViewFriendRequests page = new ViewFriendRequests();
        page.setVisible(true);

        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(Back);
        if (parentFrame != null) {
            parentFrame.setContentPane(page);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
    }//GEN-LAST:event_ShowRequestsActionPerformed

    private void BlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlockActionPerformed
        JTextField name = new JTextField();
        Object[] message = {
            "Enter Username:", name
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Block User ", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String user = name.getText();
            System.out.println(user);
            System.out.println(current.getUsername());
            if (!current.isBlocked(user)) {
                boolean done = current.blockUser(user);
                if (done){
                    JOptionPane.showMessageDialog(this, user + " Blocked Successfully ");}
                if(!done) {
                    JOptionPane.showMessageDialog(this, user + " could not be found ");
                }
            }
            else
            JOptionPane.showMessageDialog(this, user + " Already blocked ");
        }
    }//GEN-LAST:event_BlockActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        Newsfeed create = new Newsfeed();
        create.setVisible(true);

        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(Back);
        if (parentFrame != null) {
            parentFrame.setContentPane(create);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }

    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Block;
    private javax.swing.JButton RemoveFriend;
    private javax.swing.JButton SendFriendRequest;
    private javax.swing.JButton ShowRequests;
    private javax.swing.JButton ShowSuggestions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

   
}
