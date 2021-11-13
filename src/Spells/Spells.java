package Spells;

import java.awt.*;
import Objects.Knight;

public class Spells extends Rectangle {
    
    public static int x, y;

    public Spells(int[] xY) {
        x = xY[0];
        y = xY[1];
    }

    public static void getXY() {
        x = Knight.x + Knight.width + 2;
        y = Knight.y + Knight.height/2;
    }

    public static void RESET() {
        x = 0;
        y = 0;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 10, 5);
    }

}
