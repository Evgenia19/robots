package test;

import gui.*;
import org.junit.Test;
import org.junit.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MultiUsersTest {
    private String userId_1 = "one";
    private String userId_2 = "two";
    private MultiUser multiUser = new MultiUser();

    @Test
    public void testCreate() {
        new RobotsProgram(userId_1);
    }

    @Test
    public void testUserInDict() {
        Assert.assertEquals(multiUser.addUser(userId_1), true);
    }

    @Test
    public void testUserNotInDict() {
        multiUser.addUser(userId_1);
        Assert.assertEquals(multiUser.addUser(userId_1), false);
    }

    @Test
    public void testWorkBots() {
        multiUser.addUser(userId_1);
        Message msg_1 = multiUser.users(new Message(userId_1, new Point(10, 10)));
        Assert.assertEquals(msg_1.content, new Point(10, 10));
    }

    @Test
    public void testWorkTwoBots() {
        multiUser.addUser(userId_1);multiUser.users(new Message(userId_1, new Point(10, 10)));
        multiUser.addUser(userId_2);
        multiUser.users(new Message(userId_2, new Point(30, 30)));
        Message msg_1 = multiUser.users(new Message(userId_1, new Point(10, 10)));
        Assert.assertEquals(msg_1.content, multiUser.getRobot(userId_1).getTarget());
    }
}
