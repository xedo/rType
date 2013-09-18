package com.echedey.rtype;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation extends JPanel implements ActionListener {

	private Image img;
	private static String backgroundURL = "./spaceBackground.jpg";
	private Timer time;
	private SpaceCraft player;
	private ArrayList<Enemies> enemies;
	private boolean gameOver = false;
	int x, y; // position

	public Animation(String level) {
		addKeyListener(new Controls());
		setFocusable(true);
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(
				backgroundURL));
		img = imgIcon.getImage().getScaledInstance(800, 600,
				java.awt.Image.SCALE_DEFAULT);

		player = new SpaceCraft();
		// starEnemies(level);
		starEnemies(level);
		setDoubleBuffered(true);
		time = new Timer(30, this);
		time.start(); // start actionPerfomred
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
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// draw background
		g2d.drawImage(img, 0, 0, null);
		// draw player
		g2d.drawImage(player.getImg(), player.getX(), player.getY(), null);
		// draw missiles
		ArrayList<Missiles> ms = player.getMissilesVisible();
		for (Missiles missil : ms) {
			g2d.drawImage(missil.getImg(), missil.getX(), missil.getY(), null);
		}
		// draw enemies
		for (Craft alienShips : enemies) {
			g2d.drawImage(alienShips.getImg(), alienShips.getX(),
					alienShips.getY(), null);
		}
		// Game Over
		if (gameOver) {
			String mensage = "Game Over";
			g.setFont(new Font("Arial", Font.BOLD, 60));
			g.setColor(Color.GREEN);
			g.drawString(mensage, (getWidth() / 2) - (int)(g.getFontMetrics().getStringBounds(mensage, g).getWidth() / 2), (getHeight() / 2) - (int)(g.getFontMetrics().getStringBounds(mensage, g).getHeight() / 2));
		}
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// move spacecraft
		if (!player.isCollision()) {
			player.move();
			// move missiles
			ArrayList<Missiles> ms = player.getMissilesVisible();

			for (int i = 0; i < ms.size(); i++) {
				Missiles missil = ms.get(i);
				if (missil.isVisible())
					missil.move();
				else
					ms.remove(i);
			}

			// move enemies
			for (int i = 0; i < enemies.size(); i++) {
				Enemies alien = enemies.get(i);
				if (alien.isCollision())
					enemies.remove(i);
				else
					alien.move();
			}

			checkColitions();
		}
		repaint();

	}

	public void checkColitions() {
		// missile hits
		for (int i = 0; i < player.getMissilesVisible().size(); i++) {
			Rectangle missil = player.getMissilesVisible().get(i).getBounds();
			for (int j = 0; j < enemies.size(); j++) {
				if (enemies.get(j).getBounds().intersects(missil)) {
					enemies.get(j).setCollision(true);
					player.getMissilesVisible().get(i).setCollision(true);
				}
			}
		}
		// Game Over
		for (int i = 0; i < enemies.size(); i++) {
			Rectangle alien = enemies.get(i).getBounds();
			if (player.getBounds().intersects(alien)) {
				player.setCollision(true);
				gameOver = true;
			}
		}
	}

	private class Controls extends KeyAdapter {
		// @Override
		public void keyPressed(KeyEvent e) {
			player.pressKey(e);
		}

		// @Override
		public void keyReleased(KeyEvent e) {
			player.releaseKey(e);
		}
	}

}
