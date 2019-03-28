package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.EventHandler;
import java.util.Scanner;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class RobotsProgram
{
    private String userId;
    public RobotsProgram(String id) {
        userId = id;
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//          UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
            SwingUtilities.invokeLater(() -> {
                MainApplicationFrame frame = new MainApplicationFrame(userId);
                frame.pack();
                frame.setVisible(true);
                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            });
    }

    public Message process(Message msg)
    {
        GameVisualizer.setTargetPosition(msg.content);
        return new Message(userId, msg.content);
    }

}
