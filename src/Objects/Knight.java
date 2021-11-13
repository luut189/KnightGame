package Objects;

import java.awt.*;
import java.awt.event.*;

import Spells.*;
import SwingFiles.*;

public class Knight extends Rectangle {
    
    public static boolean isJumping, right, left, zAction, isFired;
    public static double xVelo = 10;
    
    public static int x, y, width, height;

    public Knight(int x, int y, int width, int height) {
        Knight.x = x;
        Knight.y = y;
        Knight.height = height;
        Knight.width = width;
    }

    public double newSpeed(double increaseAmount) {
        return xVelo += increaseAmount;
    }

    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }

    public void move() {
        //JUMP
        if(isJumping && y > dotPanel.maxHeight) {
            y -= dotPanel.P_SIZE/5;
        }
        
        if(!isJumping && y < dotPanel.Y_GROUND - height) {
            y += dotPanel.P_SIZE/5;
        }
        
        if(y <= dotPanel.maxHeight) {
            isJumping = false;
        }
        
        //LEFT
        if(left) {
            if(x <= 0) {} 
            else {
                x -= xVelo;
            }
        }
        
        //RIGHT
        if(right) {
            if(x > dotPanel.WIDTH-width) {} 
            else {
                x += xVelo;
            }
        }
    }

    public void action() {
        if(zAction) {
            Spells.getXY();
            isFired = true;
        }
        if(isFired) {
            Spells.x += xVelo;
        }
        if(Spells.x > dotPanel.WIDTH) {
            Spells.x = 0;
            Spells.y = 0;
            isFired = false;
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
        if(e.getKeyCode() == KeyEvent.VK_Z) zAction = true;
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
        if(e.getKeyCode() == KeyEvent.VK_Z) zAction = false;
    }
}