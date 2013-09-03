package com.echedey.rtype;

import javax.swing.ImageIcon;

public class Missiles extends Craft{
	private boolean visible;
	
	public Missiles (int x, int y){
		super();
		setImgURL("./missil.png");
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(getImgURL()));
		setImg(imgIcon.getImage());//.getScaledInstance(60, 50, java.awt.Image.SCALE_SMOOTH));
		
		//always moving horizontally
		setMovX(1);
		setMovY(0);
		setSpeed(20);
		setX(x);
		setY(y - getImg().getHeight(null)/2);
		visible = true;
	}
	
	@Override
	public void move(){
		setX(getX() + getMovX()*getSpeed());
		if (getX() >= 800)
			visible = false;
	}
	
	public boolean isVisible(){
		return visible;
	}
} 
