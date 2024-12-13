/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author yaseen
 */
public class Post extends Content {
    private Post(UserAccount user, String contentText, String imgPath) {
        super(user, contentText, imgPath, "Post");
    }

    @Override
    public String getType() {
        return "Post";
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
