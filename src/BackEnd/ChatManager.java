package BackEnd;
import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private List<Message> messages = new ArrayList<>();

    public void sendMessage(String sender, String receiver, String content) {
        messages.add(new Message(sender, receiver, content));
    }

    public List<Message> getMessages(String user1, String user2) {
        List<Message> chatHistory = new ArrayList<>();
        for (Message message : messages) {
            if ((message.getSender().equals(user1) && message.getReceiver().equals(user2)) ||
                (message.getSender().equals(user2) && message.getReceiver().equals(user1))) {
                chatHistory.add(message);
            }
        }
        return chatHistory;
    }}
