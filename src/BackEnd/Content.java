/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author yaseen
 */
public abstract class Content 
{
    public static int countC=0;
    private final  String ContentId;
    private final String autherId;
    private String ContenText;
    private String ImgPath;
    private final long timestamp;

    public Content( UserAccount User, String ContenText) {
        this.ContentId = "contant"+String.format("%03d", countC++);
        this.autherId = User.getSearchKey();
        this.ContenText = ContenText;
        this.timestamp = System.currentTimeMillis();
    }

    public String getContentId() {
        return ContentId;
    }
    public String getSearchKey()
    {
        return autherId;
    }
    public String getContenText() {
        return ContenText;
    }

    public void setContenText(String ContenText) {
        this.ContenText = ContenText;
    }

    public String getImgPath() {
        return ImgPath;
    }

    public void setImgPath(String ImgPath) {
        this.ImgPath = ImgPath;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    
    
    
}
