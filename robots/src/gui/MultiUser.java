package gui;

import java.util.HashMap;
import java.util.Map;

public class MultiUser {
    private Map<String, RobotsProgram> games;

    public MultiUser() {
        games = new HashMap<String, RobotsProgram>();
    }

    public User users(User user) {
        RobotsProgram handler = games.get(user.userId);
        return handler.process(user);
    }

    public boolean addUser(String id) {
        if (!games.containsKey(id)) {
            games.put(id, new RobotsProgram(id));
            return true;
        }
        else
            return false;
    }
}
