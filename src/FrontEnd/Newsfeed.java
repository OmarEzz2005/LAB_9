/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;


import BackEnd.Content;
import BackEnd.ContentDatabase;
import BackEnd.Group;
import BackEnd.Post;
import BackEnd.Storie;
import BackEnd.UserAccount;
import BackEnd.UserDatabase;
import static FrontEnd.profileManagementPage.bio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class Newsfeed extends javax.swing.JPanel {

    /**
     * Creates new form Newsfeed
     */
    
    
    UserDatabase users;
    public static String groupC ;
    public static String PostC ;
    public static ContentDatabase contents = new ContentDatabase("Content.json");
    public static JPanel jPanel3;
    public static JPanel jPanel4;
    private UserAccount currentUser;
    
    
    public Newsfeed() {
        
        jPanel3 = new JPanel();
        jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));
        jPanel4 = new JPanel();
        jPanel4.setLayout(new BoxLayout(jPanel4, BoxLayout.X_AXIS));
        initComponents();
        users = LOGIN.database;
        ImageIcon icon = new ImageIcon(getClass().getResource("/FrontEnd/image.png"));
        Image image = icon.getImage();
        contents.readFromFile();
        currentUser = users.getCurrentUser();
        
        
        

     if (image != null && image.getWidth(null) > 0 && image.getHeight(null) > 0) {
    
    Image scaledImage = image.getScaledInstance(25,30 , Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);

    // Set the icon to the button
    Refresh.setIcon(scaledIcon);
    } else {
    System.out.println("Error: Image not found or invalid dimensions.");
    }
     
     contents.loadPosts();
     contents.loadStories();
     this.addToTable();
     addOtherToTable();
    }

    
    
    
    
    public void addToTable()
    {
        
        ArrayList<Group> groups = LOGIN.database.getCurrentUser().getJoinedGroups();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        
        if( groups == null || groups.isEmpty())
        {
            System.out.println("Here");
            Object[] row = new Object[1];
            row[0] = "No Groups";
            model.addRow(row);
            return;
        }
        
        //System.out.println("Requests"+requests.get(0).getUsername());
        for (Group c : groups) {
            
            Object[] row = new Object[1];
            row[0] = c.getName();
            model.addRow(row);
        }
    
    
    }
    
    public void addOtherToTable()
    {
        
        ArrayList<Group> groups = LOGIN.groupdatabase.getgroups();
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        
        if( groups == null || groups.isEmpty())
        {
           // System.out.println("Here");
            Object[] row = new Object[1];
            row[0] = "No Groups";
            model.addRow(row);
            return;
        }
        
        //System.out.println("Requests"+requests.get(0).getUsername());
        for (Group c : groups) {
            if(LOGIN.database.getCurrentUser().isJoinedGroup(c.getName()))
            {
                continue;
            }
            Object[] row = new Object[1];
            row[0] = c.getName();
            model.addRow(row);
        }
    
        if (model.getRowCount() == 0) {
            Object[] row = new Object[1];
            row[0] = "No Groups";
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        Refresh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CreatePost = new javax.swing.JButton();
        CreateStory = new javax.swing.JButton();
        Profile = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane(new javax.swing.JScrollPane(jPanel3));
        jScrollPane3 = new javax.swing.JScrollPane(jPanel4);
        FriendManagement = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Show = new javax.swing.JButton();
        Leave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        ShowOthers = new javax.swing.JButton();
        Join = new javax.swing.JButton();
        CreateGroup = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Contacts");

        jList2.setModel(new javax.swing.AbstractListModel<String>() {

            UserAccount current = LOGIN.database.getCurrentUser();
            String[] strings;

            {
                ArrayList<UserAccount> friends = current.getFriends();
                if (current.getFriends() == null || current.getFriends().isEmpty()) {
                    strings = new String[]{"No friends"};
                } else {
                    strings = new String[friends.size()];
                    for (int i = 0; i < friends.size(); i++) {
                        strings[i] = friends.get(i).getUsername() + " " + friends.get(i).getStatus();
                    }
                }
            }

            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 178, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Connect HUB");

        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("What's on your mind ?");

        CreatePost.setText("Create Post");
        CreatePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePostActionPerformed(evt);
            }
        });

        CreateStory.setText("Create story");
        CreateStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateStoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(CreatePost)
                .addGap(41, 41, 41)
                .addComponent(CreateStory)
                .addGap(124, 124, 124))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePost)
                    .addComponent(CreateStory))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        Profile.setText("Profile");
        Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileActionPerformed(evt);
            }
        });

        LogOut.setText("Log out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setViewportView(jPanel3);

        jScrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        FriendManagement.setText("Friend management");
        FriendManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriendManagementActionPerformed(evt);
            }
        });

        jLabel4.setText("Your Groups");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Group Name"
            }
        ));
        jScrollPane5.setViewportView(jTable2);

        Show.setText("Show");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });

        Leave.setText("Leave");
        Leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Show)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Leave)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Show)
                    .addComponent(Leave))
                .addContainerGap())
        );

        jLabel5.setText("Other Groups");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Group Name"
            }
        ));
        jScrollPane6.setViewportView(jTable3);

        ShowOthers.setText("Show");
        ShowOthers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowOthersActionPerformed(evt);
            }
        });

        Join.setText("Join");
        Join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ShowOthers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Join)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowOthers)
                    .addComponent(Join))
                .addGap(13, 13, 13))
        );

        CreateGroup.setText("Create Group");
        CreateGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateGroupActionPerformed(evt);
            }
        });

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton1.setText("Group Creator management");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton2.setText("Group Admin management");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FriendManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LogOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Profile)
                        .addGap(12, 12, 12)
                        .addComponent(jButton2)
                        .addGap(7, 7, 7)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FriendManagement)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateGroup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CreatePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePostActionPerformed
        // TODO add your handling code here:
        CreatePost create = new CreatePost(null);
        create.setVisible(true);
        
        
         LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(CreatePost);
        if (parentFrame != null) {
            parentFrame.setContentPane(create);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
        
        
    }//GEN-LAST:event_CreatePostActionPerformed

    private void CreateStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateStoryActionPerformed
        // TODO add your handling code here:
        CreateStorie create = new CreateStorie();
        create.setVisible(true);
        
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(CreateStory);
        if (parentFrame != null) {
            parentFrame.setContentPane(create);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
    }//GEN-LAST:event_CreateStoryActionPerformed

    private void ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileActionPerformed
        // TODO add your handling code here:
        
        String BIO;
        
        profileManagementPage page = new profileManagementPage(LOGIN.database.getCurrentUser());
        page.setVisible(true);
        
            if(users.getCurrentUser().getProfile().getBio() != null && !users.getCurrentUser().getProfile().getBio().isEmpty()){
            BIO = users.getCurrentUser().getProfile().getBio();
            System.out.println(BIO);
            bio.setText(BIO);
            }
        
        
        
        
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(CreateStory);
        if (parentFrame != null) {
            parentFrame.setContentPane(page);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
        
        
    }//GEN-LAST:event_ProfileActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        LOGIN.database.readFromFile();
        LOGIN.groupdatabase.readFromFile();
        Newsfeed page = new Newsfeed();
        page.setVisible(true);
        
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(Refresh);
        if (parentFrame != null) {
            parentFrame.setContentPane(page);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
    }//GEN-LAST:event_RefreshActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
        currentUser.makeOffline();
        LOGIN.database.saveToFile();
        LOGIN log = new LOGIN();
        log.setVisible(true);     
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(LogOut);
        if (parentFrame != null) {
            this.setVisible(false);   
            parentFrame.dispose(); 
            log.setVisible(true);
        }
    }//GEN-LAST:event_LogOutActionPerformed

    private void FriendManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FriendManagementActionPerformed
        // TODO add your handling code here:
        
        FriendManagement create = new FriendManagement(this.currentUser);
        create.setVisible(true);
        
        
         LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(FriendManagement);
        if (parentFrame != null) {
            parentFrame.setContentPane(create);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
    }//GEN-LAST:event_FriendManagementActionPerformed

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow != -1) {
                String groupName = (String) jTable2.getValueAt(selectedRow, 0);
                if(groupName.equals("No Groups"))
                {
                    JOptionPane.showMessageDialog(null,"No Groups to show !!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                GroupUser create = new GroupUser(LOGIN.groupdatabase.getRecord(groupName));
                create.setVisible(true);
        
        
                LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(Show);
                if (parentFrame != null) {
                parentFrame.setContentPane(create);
                parentFrame.revalidate();
                parentFrame.repaint();
                parentFrame.pack();
                }
                
                      
        }
    }//GEN-LAST:event_ShowActionPerformed

    private void LeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveActionPerformed
        // TODO add your handling code here:
         int selectedRow = jTable2.getSelectedRow();
        if (selectedRow != -1) {
                String groupname = (String) jTable2.getValueAt(selectedRow, 0);
                if(groupname.equals("No Groups"))
                {
                    JOptionPane.showMessageDialog(null,"No groups to leave !!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                   
                LOGIN.groupdatabase.getRecord(groupname).getUsers().remove(LOGIN.database.getCurrentUser().getUsername());
                if(LOGIN.database.getCurrentUser().isCreatorGroup(groupname) && LOGIN.groupdatabase.getRecord(groupname).getOtherAdmins().isEmpty())
                {
                    LOGIN.groupdatabase.deleteRecord(groupname);
                }
                LOGIN.groupdatabase.saveToFile();
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.removeRow(selectedRow);
                if (model.getRowCount() == 0) {
                Object[] row = new Object[1];
                row[0] = "No Groups";
                model.addRow(row);
                }
                JOptionPane.showMessageDialog(null, "You left the group", "Success", JOptionPane.INFORMATION_MESSAGE);       
        }
    }//GEN-LAST:event_LeaveActionPerformed

    private void ShowOthersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowOthersActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable3.getSelectedRow();
        if (selectedRow != -1) {
                String groupName = (String) jTable3.getValueAt(selectedRow, 0);
                if(groupName.equals("No Groups"))
                {
                    JOptionPane.showMessageDialog(null,"No Groups to show !!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                GroupUser create = new GroupUser(LOGIN.groupdatabase.getRecord(groupName));
                create.setVisible(true);
        
        
                LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(Show);
                if (parentFrame != null) {
                parentFrame.setContentPane(create);
                parentFrame.revalidate();
                parentFrame.repaint();
                parentFrame.pack();
                }
                
                      
        }
        
        
    }//GEN-LAST:event_ShowOthersActionPerformed

    private void JoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoinActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable3.getSelectedRow();
        if (selectedRow != -1) {
                String groupname = (String) jTable3.getValueAt(selectedRow, 0);
                if(groupname.equals("No Groups"))
                {
                    JOptionPane.showMessageDialog(null,"No groups to join !!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                LOGIN.groupdatabase.getRecord(groupname).getUsers().add(LOGIN.database.getCurrentUser().getUsername());
                LOGIN.groupdatabase.saveToFile();
                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                model.removeRow(selectedRow);
                if (model.getRowCount() == 0) {
                Object[] row = new Object[1];
                row[0] = "No Groups";
                model.addRow(row);
                }
                JOptionPane.showMessageDialog(null, "You joined the group", "Success", JOptionPane.INFORMATION_MESSAGE);       
        }
    }//GEN-LAST:event_JoinActionPerformed

    private void CreateGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateGroupActionPerformed
        // TODO add your handling code here:
        CreateGroup create = new CreateGroup();
        create.setVisible(true);
        
        
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(CreateGroup);
        if (parentFrame != null) {
            parentFrame.setContentPane(create);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
        
        
        
    }//GEN-LAST:event_CreateGroupActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        SearchWindow window = new SearchWindow();
        window.setVisible(true);
        
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(Search);
        if (parentFrame != null) {
            parentFrame.setContentPane(window);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
        
        
    }//GEN-LAST:event_SearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GroupCreatorManagment create = new GroupCreatorManagment();
        create.setVisible(true);
        
        
         LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(jButton1);
        if (parentFrame != null) {
            parentFrame.setContentPane(create);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         GroupAdminManagment create = new GroupAdminManagment();
        create.setVisible(true);
        
        
         LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(jButton2);
        if (parentFrame != null) {
            parentFrame.setContentPane(create);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }       
        
    }//GEN-LAST:event_jButton2ActionPerformed


    
   
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateGroup;
    private javax.swing.JButton CreatePost;
    private javax.swing.JButton CreateStory;
    private javax.swing.JButton FriendManagement;
    private javax.swing.JButton Join;
    private javax.swing.JButton Leave;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton Profile;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Search;
    private javax.swing.JButton Show;
    private javax.swing.JButton ShowOthers;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
