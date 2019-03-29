package gui;

import java.awt.*;

public class Message {
    public final String userId;
    public final Point content;

    public Message(String id, Point newContent) {
        this.userId = id;
        this.content = newContent;
    }
}