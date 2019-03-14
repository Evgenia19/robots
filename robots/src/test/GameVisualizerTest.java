package test;

import gui.GameVisualizer;
import org.junit.Test;
import org.junit.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameVisualizerTest {

    @Test
    public void setTargetPositionTest() {

        GameVisualizer game = new GameVisualizer();
        int x = game.m_targetPositionX = 10;
        int y = game.m_targetPositionY = 10;
        game.setTargetPosition(new Point(305, 250));
        Assert.assertEquals(x , game.m_targetPositionX);
        Assert.assertEquals(y, game.m_targetPositionY);
    }

    @Test
    public void testGetWalls() {
        GameVisualizer g = new GameVisualizer();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < g.walls.length; i += 2) {
            Random rnd = new Random();
            int x = g.walls[i].x + rnd.nextInt((int)g.walls[i+1].x - (int)g.walls[i].x);
            int y = g.walls[i].y + rnd.nextInt((int)g.walls[i+1].y - (int)g.walls[i].y);
            points.add(new Point(x, y));
        }
        for (Point p: points){
            boolean result = g.getWalls(p.x, p.y);
            Assert.assertTrue(result);
        }
    }

    @Test
    public void testGetMines() {
        GameVisualizer g = new GameVisualizer();
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < g.mines.length; i += 1){
            boolean result = g.getMines(g.mines[i].x, g.mines[i].y);
            Assert.assertTrue(result);
            Random rnd = new Random();
            int x = rnd.nextInt(900);
            int y = rnd.nextInt(900);
            if (x != g.mines[i].x & y != g.mines[i].y){
                points.add(new Point(x, y));
            }
        }
        for (Point p: points){
            boolean result = g.getMines(p.x, p.y);
            Assert.assertFalse(result);
        }
    }
}
