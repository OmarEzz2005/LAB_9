
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import FrontEnd.LOGIN;
import FrontEnd.Newsfeed;
import static FrontEnd.Newsfeed.contents;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author yaseen
 */
public class ContentDatabase implements Database <Content>{

    UserDatabase users;
    private final String FileName;
    private final ArrayList<Content> contentList = new ArrayList<>();

    public ContentDatabase(String file) {
        this.FileName = file;
        users = LOGIN.database;
    }

    public ArrayList<Content> getContentList() {
        return contentList;
    }
    
    @Override
    public void saveToFile() {
    Gson gson = new Gson();
    File file = new File(this.FileName);
    if (!file.exists()) {
        try {
            
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(contentList, writer);
                System.out.println("File created and data successfully saved to file: " + this.FileName);
            }
        } catch (IOException e) {
            System.err.println("Error creating and saving to file: " + e.getMessage());
        }
    } else {
        try {
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(contentList, writer);
                System.out.println("Data successfully saved to existing file: " + this.FileName);
            }
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }
}

    @Override
    public void readFromFile() {
    Gson gson = new GsonBuilder()
        .registerTypeAdapter(Content.class, new ContentDeserializer())
        .create();
    try (FileReader reader = new FileReader(FileName)) {
        ArrayList<Content> loadedContent = gson.fromJson(reader, new TypeToken<List<Content>>() {}.getType());
        if (loadedContent != null) {
            contentList.clear();
            contentList.addAll(loadedContent);
        }
    } catch (IOException e) {
        System.out.println("Cannot read the file: " + e.getMessage());
    }
}
    
    @Override
    public boolean contains(String key) {
        for (Content c : contentList) {
            if (c.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Content getRecord(String key) {
        for (Content c : contentList) {
            if (c.getSearchKey().equals(key)) {
                return c;
            }
        }
        return null;
    }
    
    @Override
     public void deleteRecord(String key) {
        if (!contains(key)) {
            JOptionPane.showMessageDialog(null, "content not found !!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
          Iterator<Content> iterator = contentList.iterator();
    
          while (iterator.hasNext()) {
        
              Content c = iterator.next();
        
              if (c.getSearchKey().equals(key)) {
            
                  iterator.remove();
           
                  JOptionPane.showMessageDialog(null, "Post with ID " + key + " was successfully removed", "Message", JOptionPane.INFORMATION_MESSAGE);
            
                  saveToFile();
            
                  return;
        }
    }}
     
    
     public int getSize()
     {
         return this.contentList.size();
     }
     
     
     
     
     
     
     public void displayPosts(ArrayList<Post> posts) {
    Newsfeed.jPanel3.removeAll();
    Newsfeed.jPanel3.setLayout(new BoxLayout(Newsfeed.jPanel3, BoxLayout.Y_AXIS)); 

    for (Post post : posts) {
        boolean isFriend = LOGIN.database.getCurrentUser()
                .isFriends(LOGIN.database.getRecord(post.getAutherId()).getUsername());
        boolean isInSharedGroup = false;

        // Check if the post author belongs to any group the current user has joined
        for (Group group : LOGIN.groupdatabase.getgroups()) {
            if (LOGIN.database.getCurrentUser().isJoinedGroup(group.getName()) &&
                group.getPosts().contains(post.getContentId())) {
                isInSharedGroup = true;
                break;
            }
        }

        // Skip posts if the author is neither a friend nor in a shared group
        if (!isFriend && !isInSharedGroup && !LOGIN.database.getCurrentUser().getUserID().equals(post.getAutherId())) {
            continue;
        }

        // Create the main panel for the post
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new BorderLayout());
        postPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create a header panel for group name and username
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setOpaque(false);

        // Add group name if applicable
        for (Group group : LOGIN.groupdatabase.getgroups()) {
            if (LOGIN.database.getCurrentUser().isJoinedGroup(group.getName()) &&
                group.getPosts().contains(post.getContentId())) {
                JLabel groupLabel = new JLabel(group.getName());
                groupLabel.setFont(new Font("Arial", Font.BOLD, 18));
                headerPanel.add(groupLabel);
                break;
            }
        }

        // Add username
        JLabel usernameLabel = new JLabel(users.getRecord(post.getAutherId()).getUsername());
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(usernameLabel);

        // Add the header to the top of the post panel
        postPanel.add(headerPanel, BorderLayout.NORTH);

        // Add post content
        JTextArea contentArea = new JTextArea(post.getContenText());
        contentArea.setWrapStyleWord(true);
        contentArea.setLineWrap(true);
        contentArea.setEditable(false);
        contentArea.setOpaque(false);
        postPanel.add(contentArea, BorderLayout.CENTER);

        // Add post image if present
        if (post.getImgPath() != null && !post.getImgPath().isEmpty()) {
            try {
                ImageIcon imageIcon = new ImageIcon(post.getImgPath());
                Image image = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                JLabel imageLabel = new JLabel(new ImageIcon(image));
                postPanel.add(imageLabel, BorderLayout.SOUTH);
            } catch (Exception e) {
                System.err.println("Error loading image from path: " + post.getImgPath());
                e.printStackTrace();
            }
        }

        // Add the post panel to the main panel
        Newsfeed.jPanel3.add(postPanel);
    }

    // Adjust the size and refresh the view
    int totalHeight = posts.size() * 200;
    Newsfeed.jPanel3.setPreferredSize(new Dimension(Newsfeed.jPanel3.getWidth(), totalHeight));
    Newsfeed.jPanel3.revalidate();
    Newsfeed.jPanel3.repaint();
    Newsfeed.jScrollPane2.revalidate();
    Newsfeed.jScrollPane2.repaint();
}

   
    public void loadPosts() {
    ArrayList<Post> posts = new ArrayList<>();
    ArrayList<Content> content = contents.getContentList();
    for(Content c : content)
    {
        if(c instanceof Post)
        {
            posts.add((Post) c);
           // System.out.println("Post Found" + ((Post) c).getContentId());
        }
        
    }
    
    displayPosts(posts);          
    }
   
    
    
    
    
    
    
    
    
    public void displayStorie(ArrayList<Storie> stories) {
    Newsfeed.jPanel4.removeAll();
    Newsfeed.jPanel4.setLayout(new BoxLayout(Newsfeed.jPanel4, BoxLayout.Y_AXIS)); 

   
    for (Storie storie : stories) {
        if(!LOGIN.database.getCurrentUser().isFriends(storie.getAutherId()))
        {
            continue;
        }
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
       
        Newsfeed.jPanel4.add(postPanel);
        Newsfeed.jPanel4.add(Box.createRigidArea(new Dimension(30,20)));
    //    System.out.println("Added post: " + storie.getContentId());
    }

    
    int totalHeight = stories.size() * 200;  
//    System.out.println("TOTAL height: " + totalHeight);

    
    Newsfeed.jPanel4.setPreferredSize(new Dimension(Newsfeed.jPanel4.getWidth(), totalHeight));

    
    Newsfeed.jPanel4.revalidate();
    Newsfeed.jPanel4.repaint();
    Newsfeed.jScrollPane3.revalidate();  
    Newsfeed.jScrollPane3.repaint();     

   
}






    
    
    public void loadStories() {
    ArrayList<Storie> stories = new ArrayList<>();
    ArrayList<Content> content = contents.getContentList();
    for(Content c : content)
    {
        if(c instanceof Storie)
        {
            stories.add((Storie) c);
          //  System.out.println("Story Found" + ((Storie) c).getContentId());
        }
        
    }
    displayStorie(stories);
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
}
