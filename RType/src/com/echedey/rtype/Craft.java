package com.echedey.rtype;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Craft {
	private String imgURL = "./craft.png";
	private int x, y;
	private int maxY, maxX;
	private int minY, minX;
	private int movX, movY;
	private int speed = 1;
	private Image img;
	private boolean collision;
	
	public Craft(){
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(imgURL));
		img = imgIcon.getImage().getScaledInstance(60, 50, java.awt.Image.SCALE_SMOOTH);
		maxX = 800;
		maxY = 600;
		minX = 0;
		minY = 0;
		x = 0;
		y = 0;
		setCollision(false);
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
//		System.out.println("X:" + x + " Y:" + y);
			
	}

	public Image getImg() {
		return img;
	}
	
	public void setImg(Image img) {
		this.img = img;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getMovX() {
		return movX;
	}
	
	public void setMovX(int movX) {
		this.movX = movX;
	}

	public int getMovY() {
		return movY;
	}
	
	public void setMovY(int movY) {
		this.movY = movY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public boolean isCollision() {
		return collision;
	}

	public void setCollision(boolean collision) {
		this.collision = collision;
	}	
	
}
