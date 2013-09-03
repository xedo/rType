package com.echedey.rtype;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation extends JPanel implements ActionListener{
	
	private Image img;
	private static String backgroundURL = "./spaceBackground.jpg";
	private Timer time;
	private SpaceCraft player;
	private ArrayList <Enemies> enemies;
	int x, y; //position
	
	public Animation(String level){
		addKeyListener(new Controls());
		setFocusable(true);
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(backgroundURL));
		img = imgIcon.getImage().getScaledInstance(800, 600, java.awt.Image.SCALE_DEFAULT);
		
		player = new SpaceCraft();
		//starEnemies(level);
		starEnemies(level);
		setDoubleBuffered(true);
		time = new Timer(30,this);
		time.start(); //start actionPerfomred
	}
	
	private void starEnemies(String level) {
		enemies = new ArrayList<Enemies>();
		if (level == "Easy")
			for (int i = 0; i < 2; i++) 
				enemies.add(new Enemies());
		
		if (level == "Normal")
			for (int i = 0; i < 5; i++) 
				enemies.add(new Enemies());
		
		if (level == "Hard")
			for (int i = 0; i < 6; i++) 
				enemies.add(new Enemies());
		
		if (level == "Night Mare")
			for (int i = 0; i < 10; i++) 
				enemies.add(new Enemies());
		
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//draw background
		g2d.drawImage(img, 0, 0, null);
		//draw player
		g2d.drawImage(player.getImg(), player.getX(), player.getY(), null);
		//draw missiles
		ArrayList<Missiles> ms = player.getMissilesVisible();
		for (Missiles missil : ms) {
			g2d.drawImage(missil.getImg(), missil.getX(), missil.getY(), null);
		}
		//draw enemies
		for (Craft alienShips : enemies) {
			g2d.drawImage(alienShips.getImg(),alienShips.getX(), alienShips.getY(), null);
		}
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//move spacecraft
		player.move();
		//move missiles
		ArrayList <Missiles> ms = player.getMissilesVisible();
		for (Missiles missil : ms) {
			if (missil.isVisible())
				missil.move();
			else
				ms.remove(this);
		}
		//move enemies
		
		repaint();
		
	}
	
	private class Controls extends KeyAdapter{
		//@Override
		public void keyPressed(KeyEvent e){
			player.pressKey(e);
		}
		
		//@Override
		public void keyReleased(KeyEvent e){
			player.releaseKey(e);
		}
	}

}
