package Objects;

import java.awt.*;

public class Ground extends Rectangle {
    
    public Ground(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
}
