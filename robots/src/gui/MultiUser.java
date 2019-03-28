package gui;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MultiUser {
    private Map<String, RobotsProgram> bots;

    public MultiUser() {
        bots = new HashMap<String, RobotsProgram>();
    }

    public Message users(Message msg) {
        RobotsProgram handler = bots.get(msg.userId);
        return handler.process(msg);
    }

    public boolean addUser(String id) {
        if (!bots.containsKey(id)) {
            bots.put(id, new RobotsProgram(id));
            return true;
        }
        else
            return false;
    }
}
