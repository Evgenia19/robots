package gui;

import java.awt.*;

public class Message {
    final String userId;
    final Point content;

    public Message(String id, Point newContent) {
        this.userId = id;
        this.content = newContent;
    }
}
