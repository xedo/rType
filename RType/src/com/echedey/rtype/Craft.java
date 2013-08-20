package com.echedey.rtype;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Craft {
	private String imgURL = "../craft.png";
	private int x, y;
	private int movX, movY;
	private Image img;
	
	public Craft(){
		ImageIcon craft = new ImageIcon(imgURL);
		img = craft.getImage();
	}
	
	public void move (){
		x += movX;
		y += movY;
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
