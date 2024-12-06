/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import frontend.FriendManagementInterface;
import BackEnd.Content;
import BackEnd.ContentDatabase;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author lenovo
 */
public class Newsfeed extends javax.swing.JPanel {

    /**
     * Creates new form Newsfeed
     */
    
    
    UserDatabase users;
    
    public static ContentDatabase contents = new ContentDatabase("Content.json");
    private JPanel jPanel3;
    private JPanel jPanel4;
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
    jButton1.setIcon(scaledIcon);
    } else {
    System.out.println("Error: Image not found or invalid dimensions.");
    }
     
     this.loadPosts();
     this.loadStories();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane(new javax.swing.JScrollPane(jPanel3));
        jScrollPane3 = new javax.swing.JScrollPane(jPanel4);
        jButton6 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Contacts");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {

            UserAccount current = LOGIN.database.getCurrentUser();
            String[] strings;

            {
                ArrayList<UserAccount> friends = current.getFriends();
                if (current.getFriends() == null) {
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
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Connect HUB");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("What's on your mind ?");

        jButton2.setText("Create Post");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Create story");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                .addComponent(jButton2)
                .addGap(41, 41, 41)
                .addComponent(jButton3)
                .addGap(124, 124, 124))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jButton4.setText("Profile");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Log out");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setViewportView(jPanel3);

        jScrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jButton6.setText("Friend management");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(134, 134, 134)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(53, 53, 53)
                        .addComponent(jButton6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CreatePost create = new CreatePost();
        create.setVisible(true);
        
        
         LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(jButton2);
        if (parentFrame != null) {
            parentFrame.setContentPane(create);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        CreateStorie create = new CreateStorie();
        create.setVisible(true);
        
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(jButton3);
        if (parentFrame != null) {
            parentFrame.setContentPane(create);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        String BIO;
        
        profileManagementPage page = new profileManagementPage();
        page.setVisible(true);
        
            if(users.getCurrentUser().getProfile().getBio() != null && !users.getCurrentUser().getProfile().getBio().isEmpty()){
            BIO = users.getCurrentUser().getProfile().getBio();
            System.out.println(BIO);
            bio.setText(BIO);
            }
        
        
        
        
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(jButton3);
        if (parentFrame != null) {
            parentFrame.setContentPane(page);
            parentFrame.revalidate();
            parentFrame.repaint();
            parentFrame.pack();
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.loadPosts();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        currentUser.makeOffline();
        LOGIN log = new LOGIN();
        log.setVisible(true);     
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(jButton5);
        if (parentFrame != null) {
            this.setVisible(false);   
            parentFrame.dispose(); 
            log.setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        FriendManagementInterface page = new FriendManagementInterface(this.currentUser);
        page.setSize(1000, 500);  // Adjust the size of the new window
        page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        page.setVisible(true);  // Show the page as a new frame

       // Optionally, close the current frame or minimize it
        LOGIN parentFrame = (LOGIN) SwingUtilities.getWindowAncestor(jButton1);
        if (parentFrame != null) {
            parentFrame.setVisible(false);  // Hide the current frame if necessary
        }
    }//GEN-LAST:event_jButton6ActionPerformed


    
   public void displayPosts(ArrayList<Post> posts) {
    jPanel3.removeAll();
    jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS)); 

    
    for (Post post : posts) {
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new BorderLayout());
        postPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        JLabel titleLabel = new JLabel(users.getRecord(post.getAutherId()).getUsername());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        postPanel.add(titleLabel, BorderLayout.NORTH);

        
        JTextArea contentArea = new JTextArea(post.getContenText());
        contentArea.setWrapStyleWord(true);
        contentArea.setLineWrap(true);
        contentArea.setEditable(false);
        contentArea.setOpaque(false); 
        postPanel.add(contentArea, BorderLayout.CENTER);
        
        //Adding Image 
        if (post.getImgPath() != null && !post.getImgPath().isEmpty()) {
            try {
                // Load the image from the path
                ImageIcon imageIcon = new ImageIcon(post.getImgPath());
                Image image = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH); // Resize the image
                JLabel imageLabel = new JLabel(new ImageIcon(image));
                postPanel.add(imageLabel, BorderLayout.SOUTH); // Add image below the text
                
            } catch (Exception e) {
                System.err.println("Error loading image from path: " + post.getImgPath());
                e.printStackTrace();
            }
        }
        jPanel3.add(postPanel);
        System.out.println("Added post: " + post.getContentId());
    }
    

    
    int totalHeight = posts.size() * 200; 
    jPanel3.setPreferredSize(new Dimension(jPanel3.getWidth(), totalHeight));
   
    
    jPanel3.revalidate();
    jPanel3.repaint();
    jScrollPane1.revalidate();
    jScrollPane1.repaint();
}
   
    public void loadPosts() {
    ArrayList<Post> posts = new ArrayList<>();
    ArrayList<Content> content = contents.getContentList();
    for(Content c : content)
    {
        if(c instanceof Post)
        {
            posts.add((Post) c);
            System.out.println("Post Found" + ((Post) c).getContentId());
        }
        
    }
    
    displayPosts(posts);          
    }
   
    
    
    
    
    
    
    
    
    public void displayStorie(ArrayList<Storie> stories) {
    jPanel4.removeAll();
    jPanel4.setLayout(new BoxLayout(jPanel4, BoxLayout.Y_AXIS)); 

   
    for (Storie storie : stories) {
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new BorderLayout());
        postPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        postPanel.setPreferredSize(new Dimension(250,150));
        
        JLabel titleLabel = new JLabel(users.getRecord(storie.getAutherId()).getUsername());
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        postPanel.add(titleLabel, BorderLayout.NORTH);

        
        JTextArea contentArea = new JTextArea(storie.getContenText());
        contentArea.setWrapStyleWord(true);
        contentArea.setLineWrap(true);
        contentArea.setEditable(false);
        contentArea.setOpaque(false); 
        postPanel.add(contentArea, BorderLayout.CENTER);

        //Adding Image 
        if (storie.getImgPath() != null && !storie.getImgPath().isEmpty()) {
            try {
                // Load the image from the path
                ImageIcon imageIcon = new ImageIcon(storie.getImgPath());
                Image image = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH); // Resize the image
                JLabel imageLabel = new JLabel(new ImageIcon(image));
                postPanel.add(imageLabel, BorderLayout.SOUTH); // Add image below the text
                
            } catch (Exception e) {
                System.err.println("Error loading image from path: " + storie.getImgPath());
                e.printStackTrace();
            }
        }
       
        jPanel4.add(postPanel);
        jPanel4.add(Box.createRigidArea(new Dimension(30,20)));
        System.out.println("Added post: " + storie.getContentId());
    }

    
    int totalHeight = stories.size() * 200;  
    System.out.println("TOTAL height: " + totalHeight);

    
    jPanel4.setPreferredSize(new Dimension(jPanel4.getWidth(), totalHeight));

    
    jPanel4.revalidate();
    jPanel4.repaint();
    jScrollPane3.revalidate();  
    jScrollPane3.repaint();     

   
}






    
    
    public void loadStories() {
    ArrayList<Storie> stories = new ArrayList<>();
    ArrayList<Content> content = contents.getContentList();
    for(Content c : content)
    {
        if(c instanceof Storie)
        {
            stories.add((Storie) c);
            System.out.println("Story Found" + ((Storie) c).getContentId());
        }
        
    }
    displayStorie(stories);
    }
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
