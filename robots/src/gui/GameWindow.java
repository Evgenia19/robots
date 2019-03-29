package gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class GameWindow extends JInternalFrame
{
    private final GameVisualizer m_visualizer;
    private String userId;
    public GameWindow(String id)
    {
        super("Игровое поле", true, true, true, true);
        userId = id;
        m_visualizer = new GameVisualizer(id);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
    }
}