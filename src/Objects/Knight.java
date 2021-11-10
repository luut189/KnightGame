package Objects;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import SwingFiles.*;

public class Knight extends Rectangle {
    
    public static boolean isJumping, right, left, zAction, isFired;

    Timer timer;

    int x, y, width, height;

    public Knight(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }

    public void move() {
		ActionListener taskPerformer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//JUMP
				if(isJumping && y > dotPanel.maxHeight) {
					if(dotPanel.P_SIZE == 1) {
						y -= dotPanel.P_SIZE;
					} else {
						y -= dotPanel.P_SIZE/5;
					}
				}
				
				if(!isJumping && y < dotPanel.Y_GROUND - dotPanel.Y_HEIGHT) {
					if(dotPanel.P_SIZE == 1) {
						y += dotPanel.P_SIZE;
					} else {
						y += dotPanel.P_SIZE/5;
					}
				}
				
				//LEFT
				if(left) {
					if(x <= 0) {} 
					else {
						x -= dotPanel.xVelo;
					}
				}
				
				//RIGHT
				if(right) {
					if(x >= dotPanel.WIDTH-dotPanel.X_WIDTH) {} 
					else {
						x += dotPanel.xVelo;
					}
				}
			}
		};
		
		timer = new Timer(dotPanel.delay, taskPerformer);	
		timer.setRepeats(true);
		timer.start();
		
		if(y <= dotPanel.maxHeight) {
			isJumping = false;
		}
	}


    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(y >= dotPanel.Y_GROUND - dotPanel.Y_HEIGHT) {
                isJumping = true;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_Z) {
            zAction = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
        if(e.getKeyCode() == KeyEvent.VK_Z) {
            zAction = false;
            isFired = true;
        }
    }
}