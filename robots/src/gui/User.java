package gui;

public class User {

    final String userId;
    final RobotsProgram game;

    public User(String id, RobotsProgram newGame) {
        this.userId = id;
        this.game = newGame;
    }
}
