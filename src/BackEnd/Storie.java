/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author yaseen
 */
public class Storie extends Content {
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 24 hours in milliseconds

    private Storie(UserAccount user, String contentText, String imgPath) {
        super(user, contentText, imgPath, "Storie");
    }

    @Override
    public String getType() {
        return "Storie";
    }

    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        return currentTime >= (this.getTimestamp() + EXPIRATION_TIME);
    }

    // Static Builder Class
    public static class Builder {
        private UserAccount user;
        private String contentText;
        private String imgPath;

        public Builder setUser(UserAccount user) {
            this.user = user;
            return this;
        }

        public Builder setContentText(String contentText) {
            this.contentText = contentText;
            return this;
        }

        public Builder setImgPath(String imgPath) {
            this.imgPath = imgPath;
            return this;
        }

        public Storie build() {
            return new Storie(user, contentText, imgPath);
        }
    }
}

   