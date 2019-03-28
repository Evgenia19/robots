package test;

import gui.GameVisualizer;
import org.junit.Test;
import org.junit.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameVisualizerTest {

    @Test
    public void targetPositionOnWallTest() {

        GameVisualizer game = new GameVisualizer("12");
        int x = game.m_targetPositionX = 10;
        int y = game.m_targetPositionY = 10;
        game.setTargetPosition(new Point(305, 250));
        Assert.assertEquals(x , game.m_targetPositionX);
        Assert.assertEquals(y, game.m_targetPositionY);
    }

    @Test
    public void targetPositionOnMineTest() {

        GameVisualizer game = new GameVisualizer("12");
        int x = game.m_targetPositionX = 90;
        int y = game.m_targetPositionY = 90;
        game.setTargetPosition(new Point(145,145));
        Assert.assertEquals(x , game.m_targetPositionX);
        Assert.assertEquals(y, game.m_targetPositionY);
    }

    @Test
    public void testGetWalls() {
        GameVisualizer game = new GameVisualizer("12");
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < game.walls.length; i += 2) {
            Random rnd = new Random();
            int x = game.walls[i].x + rnd.nextInt(game.walls[i+1].x - game.walls[i].x);
            int y = game.walls[i].y + rnd.nextInt(game.walls[i+1].y - game.walls[i].y);
            points.add(new Point(x, y));
        }
        for (Point p: points){
            boolean result = game.getWalls(p.x, p.y);
            Assert.assertTrue(result);
        }
    }

    @Test
    public void conflictWithWalls()
    {
        GameVisualizer game = new GameVisualizer("12");
        game.m_robotDirection = 1;
        game.m_robotPositionX = 400;
        game.m_robotPositionY = 250;
        game.m_targetPositionX = 412;
        game.m_targetPositionY = 250;
        boolean result = game.getWalls(401, 250);
        game.onModelUpdateEvent();
        Assert.assertTrue(result);
        Assert.assertEquals(game.m_robotDirection, 1.09, 0.0001);
        Assert.assertEquals(game.m_robotPositionX, 399, 0.0001);
        Assert.assertEquals(game.m_robotPositionY, 250, 0.0001);
    }

    @Test
    public void testGetMines() {
        GameVisualizer game = new GameVisualizer("12");
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < game.mines.length; i += 1){
            boolean result = game.getMines(game.mines[i].x, game.mines[i].y);
            Assert.assertTrue(result);
            Random rnd = new Random();
            int x = rnd.nextInt(900);
            int y = rnd.nextInt(900);
            if (x != game.mines[i].x & y != game.mines[i].y){
                points.add(new Point(x, y));
            }
        }
        for (Point p: points){
            boolean result = game.getMines(p.x, p.y);
            Assert.assertFalse(result);
        }
    }
}
