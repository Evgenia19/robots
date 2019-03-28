package gui;

import java.awt.*;
import java.util.Scanner;

public class Main {
    static Point target = new Point(321, 320);

    public static void setTarget(Point point, String id)
    {
        target = point;
    }
    public static void main(String[] args) {
        String userId = null;
        MultiUser multiUser = new MultiUser();
        Scanner input = new Scanner(System.in);
        System.out.println("Please, choose your userId");
        try {
            if (userId == null && input.hasNext()) {
                String msg = input.nextLine();
                if (multiUser.addUser(msg)) {
                    userId = msg;
                    System.out.println("\n" + "ok");
                } else
                    System.out.println("\n" + "There is this userId, choose different");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (true) {
            if (target != null) {
                multiUser.users(new Message(userId, target));
            }
        }
    }
}
