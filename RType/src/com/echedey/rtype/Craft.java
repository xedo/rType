package com.echedey.rtype;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Craft {
	protected String imgURL = "./craft.png";
	protected int x, y;
	private int movX, movY;
	protected int speed = 1;
	private Image img;
	
	public Craft(){
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(imgURL));
		img = imgIcon.getImage().getScaledInstance(60, 50, java.awt.Image.SCALE_SMOOTH);
	}
	
	public void move (){
		x += movX*speed;
		y += movY*speed;
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
