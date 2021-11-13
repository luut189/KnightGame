package Obstacle;

import java.awt.*;

public class Obstacle extends Rectangle {
    
    public int x, y, width, height;

    public Obstacle(int xO, int yO, int width, int height) {
        x = xO;
        y = yO;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, width, height);
    }
}
