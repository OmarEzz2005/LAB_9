/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author yaseen
 */

public class Post extends Content {
    
    private ArrayList<String> comments = new ArrayList<>();
    private int likes = 0; // Store the number of likes
    private Set<String> likedUsers = new HashSet<>(); // Set of usernames who liked the post

    private Post(UserAccount user, String contentText, String imgPath) {
        super(user, contentText, imgPath, "Post");
    }

    @Override
    public String getType() {
        return "Post";
    }

    // Add a comment to the post
    public void addComment(String username, String comment) {
        if (username != null && comment != null && !comment.trim().isEmpty()) {
            comments.add(username + ": " + comment);
        }
    }

    // Get all comments
    public ArrayList<String> getComments() {
        return new ArrayList<>(comments); // Return a copy to prevent direct modification
    }

    // Toggle like on the post (like if not already liked, dislike if already liked)
    public void toggleLike(String username) {
        if (likedUsers.contains(username)) {
            likedUsers.remove(username); // User is removing their like (dislike)
            likes--; // Decrement like count
        } else {
            likedUsers.add(username); // User is liking the post
            likes++; // Increment like count
        }
    }

    // Get the number of likes
    public int getLikes() {
        return likes;
    }

    // Static Builder Class
    public static class Builder {
        private UserAccount user;
        private String contentText;
        private String imgPath;

        public Builder setUser(UserAccount user) {
            this.user = user;
            return this; // Return Builder instance for chaining
        }

        public Builder setContentText(String contentText) {
            this.contentText = contentText;
            return this;
        }

        public Builder setImgPath(String imgPath) {
            this.imgPath = imgPath;
            return this;
        }

        public Post build() {
            return new Post(user, contentText, imgPath);
        }
    }
}
