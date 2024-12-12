package FrontEnd;
import java.util.*;
import BackEnd.*;
import javax.swing.*;
/**
 *
 * @author NOUR
 */
public class SearchFrameWindow extends javax.swing.JFrame {

    /**
     * Creates new form SearchFrameWindow
     */
    private SearchFunctionality searchManager;
    private UserDatabase userDatabase;
    private GroupDatabase groupDatase;
    private UserAccount currentUser;
    searchManager = new SearchFunctionality(UserDatabase userDatabase, GroupDatabase groupDatabase, UserAccount currentUser);
    

    public SearchFrameWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        searchField = new javax.swing.JTextField();
        addFriendButton = new javax.swing.JButton();
        blockUserButton = new javax.swing.JButton();
        removeFriendButton = new javax.swing.JButton();
        viewProfileButton = new javax.swing.JButton();
        viewGroupButton = new javax.swing.JButton();
        joinGroupButton = new javax.swing.JButton();
        leaveGroupButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchLabel.setText("Search:");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));

        resultArea.setColumns(20);
        resultArea.setRows(5);
        resultArea.setText("Results Area");
        jScrollPane1.setViewportView(resultArea);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        searchField.setText("search here...");

        addFriendButton.setText("Add Friend");
        addFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendButtonActionPerformed(evt);
            }
        });

        blockUserButton.setText("Block User");
        blockUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockUserButtonActionPerformed(evt);
            }
        });

        removeFriendButton.setText("Remove Friend");
        removeFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFriendButtonActionPerformed(evt);
            }
        });

        viewProfileButton.setText("View Profile");

        viewGroupButton.setText("View Group");

        joinGroupButton.setText("Join Group");
        joinGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinGroupButtonActionPerformed(evt);
            }
        });

        leaveGroupButton.setText("Leave Group");
        leaveGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveGroupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton)
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addFriendButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(blockUserButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(removeFriendButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewProfileButton)
                        .addGap(43, 43, 43)
                        .addComponent(joinGroupButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leaveGroupButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(viewGroupButton)
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(searchButton)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addFriendButton)
                            .addComponent(blockUserButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeFriendButton)
                            .addComponent(viewProfileButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewGroupButton)
                            .addComponent(joinGroupButton)
                            .addComponent(leaveGroupButton))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String query = searchField.getText();
            if (!query.isEmpty()) {
                StringBuilder results = new StringBuilder();

                // User search
                results.append("User Results:\n");
                ArrayList<UserAccount> userResults = searchManager.searchUsers(query);
                for (UserAccount user : userResults) {
                    results.append(user.getUsername()).append("\n");
                }

                // Group search
                results.append("\nGroup Results:\n");
                ArrayList<Group> groupResults = searchManager.searchGroups(query);
                for (Group group : groupResults) {
                    results.append(group.getName()).append("\n");
                }

                resultArea.setText(results.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a search query.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendButtonActionPerformed
        // TODO add your handling code here:
            String username = JOptionPane.showInputDialog("Enter username to send friend request:");
            if (currentUser.sendFriendRequest(username)) {
                JOptionPane.showMessageDialog(null, "Friend request sent to " + username);
            }
    }//GEN-LAST:event_addFriendButtonActionPerformed

    private void blockUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockUserButtonActionPerformed
        // TODO add your handling code here:
            String username = JOptionPane.showInputDialog("Enter username to block:");
            if (currentUser.blockUser(username)) {
                JOptionPane.showMessageDialog(null, "User " + username + " has been blocked.");
            }
    }//GEN-LAST:event_blockUserButtonActionPerformed

    private void joinGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinGroupButtonActionPerformed
        // TODO add your handling code here:
        String groupName = JOptionPane.showInputDialog("Enter group name to join:");
            for (Group group : searchManager.searchGroups(groupName)) {
                if (!group.getUsers().contains(currentUser.getUsername())) {
                    group.getUsers().add(currentUser.getUsername());
                    JOptionPane.showMessageDialog(null, "You joined the group: " + groupName);
                    break;
                }
            }
    }//GEN-LAST:event_joinGroupButtonActionPerformed

    private void leaveGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveGroupButtonActionPerformed
        // TODO add your handling code here:
        String groupName = JOptionPane.showInputDialog("Enter group name to leave:");
            for (Group group : searchManager.searchGroups(groupName)) {
                if (group.getUsers().contains(currentUser.getUsername())) {
                    group.getUsers().remove(currentUser.getUsername());
                    JOptionPane.showMessageDialog(null, "You left the group: " + groupName);
                    break;
                }
            }
    }//GEN-LAST:event_leaveGroupButtonActionPerformed

    private void removeFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFriendButtonActionPerformed
        // TODO add your handling code here:
        String username = JOptionPane.showInputDialog("Enter username to remove from friends:");
        if (currentUser.removeFriend(username)) {
            JOptionPane.showMessageDialog(null, "Friend " + username + " has been removed.");
        } else {
            JOptionPane.showMessageDialog(null, "User " + username + " is not in your friends list.");
        }
    }//GEN-LAST:event_removeFriendButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SearchFrameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchFrameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchFrameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFrameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchFrameWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFriendButton;
    private javax.swing.JButton blockUserButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton joinGroupButton;
    private javax.swing.JButton leaveGroupButton;
    private javax.swing.JButton removeFriendButton;
    private javax.swing.JTextArea resultArea;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JButton viewGroupButton;
    private javax.swing.JButton viewProfileButton;
    // End of variables declaration//GEN-END:variables
}
