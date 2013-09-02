package com.echedey.rtype;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Craft {
	protected String imgURL = "./craft.png";
	protected int x, y;
	protected int maxY, maxX;
	protected int minY, minX;
	private int movX, movY;
	protected int speed = 1;
	protected Image img;
	
	public Craft(){
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(imgURL));
		img = imgIcon.getImage().getScaledInstance(60, 50, java.awt.Image.SCALE_SMOOTH);
		maxX = 800;
		maxY = 600;
		minX = 0;
		minY = 0;
	}
	
	public void move (){
		// X
		x += movX*speed;
		if (x >= maxX)
			x = maxX;
		if (x <= minX)
			x = minX;
		
		// Y
		y += movY*speed;
		if (y >= maxY)
			y = maxY;
		if (y <= minY)
			y = minY;
			
	}

	public Image getImg() {
		return img;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setMovX(int movX) {
		this.movX = movX;
	}

	public void setMovY(int movY) {
		this.movY = movY;
	}
	
	
}
