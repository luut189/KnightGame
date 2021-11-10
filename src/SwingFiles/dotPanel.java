package SwingFiles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Objects.*;

public class dotPanel extends JPanel {
    	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
	 
	public static final int UNIT_SIZE = 1;
	public static final int GAME_UNITS = (WIDTH * HEIGHT) / UNIT_SIZE;
	 
	public static int P_SIZE = 50;
	 
	public static final int Y_GROUND = HEIGHT - 50;
	 
	public static int xP = 0;
	public static int yP = Y_GROUND;
	 
	public static int[] skill01 = new int[2];
	 
	public static int X_WIDTH = UNIT_SIZE * P_SIZE;
	public static int Y_HEIGHT = UNIT_SIZE * P_SIZE;
	 
	public static double xVelo = 10;
	
	public static int jumpPotential = 6;
	public static int maxHeight = yP - (Y_HEIGHT * jumpPotential);

    	public static int delay = 50;

	Knight knight;
	Ground ground;

	dotPanel() {
		newObject();

		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(true);
		this.setBackground(Color.black);
		this.addKeyListener(new myKeyAdapter());
	}

	public void newObject() {
		knight = new Knight(xP, yP-Y_HEIGHT, X_WIDTH, Y_HEIGHT);
		ground = new Ground(0, Y_GROUND, WIDTH, HEIGHT);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		/*
		for(int i=0;i<HEIGHT/UNIT_SIZE;i++) {
			g.drawLine(0, i*UNIT_SIZE, WIDTH, i*UNIT_SIZE);
		}
		for(int i=0;i<WIDTH/UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, HEIGHT);
		}
		*/
		
		knight.draw(g);
		ground.draw(g);
		move();
	}
	
	public void move() {
		knight.move();
		repaint();
	}

	public class myKeyAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			knight.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			knight.keyReleased(e);
		}
	}
}
