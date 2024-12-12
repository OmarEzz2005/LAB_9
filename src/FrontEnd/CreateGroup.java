/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import BackEnd.Group;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author lenovo
 */
public class CreateGroup extends javax.swing.JPanel {

    /**
     * Creates new form CreateGroup
     */
    public CreateGroup() {
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        CreateGroup = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        jLabel1.setText("Group Name");

        jLabel2.setText("Description");

        CreateGroup.setText("Create Group");
        CreateGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateGroupActionPerformed(evt);
            }
        });

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
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(CreateGroup))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Back)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(CreateGroup)
                .addGap(63, 63, 63))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void CreateGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateGroupActionPerformed
        // TODO add your handling code here:
        String name = jTextField1.getText();
        String description = jTextField2.getText();
        if(name.isEmpty() || name == null || description.isEmpty() || description == null)
        {
            JOptionPane.showMessageDialog(null,"Some fields are Empty !!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Group group = new Group(name,description,LOGIN.database.getCurrentUser().getUsername());
        group.getUsers().add(LOGIN.database.getCurrentUser().getUsername());
        LOGIN.groupdatabase.insertRecord(group);
        LOGIN.groupdatabase.saveToFile();
        
        GroupUser create = new GroupUser(group);
        create.setVisible(true);
        
        
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(CreateGroup);
        if (parentFrame != null) {
        parentFrame.setContentPane(create);
        parentFrame.revalidate();
        parentFrame.repaint();
        parentFrame.pack();
        }
        
    }//GEN-LAST:event_CreateGroupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton CreateGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}