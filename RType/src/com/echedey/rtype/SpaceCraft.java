package com.echedey.rtype;

import java.awt.event.KeyEvent;

public class SpaceCraft extends Craft {
	
	public SpaceCraft (){
		super();
		imgURL = "./spaceCraft.png";
		speed = 10;
		//default position
		x = 30;
		y = 250;
		//limit space
		maxX = 800; // - width image
		maxY = 600; // - height image
		minX = 0;
		minY = 0;
	}
	
	public void pressKey (KeyEvent k){
		int key = k.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_LEFT:
			setMovX(-1);
			break;
			
		case KeyEvent.VK_RIGHT:
			setMovX(1);
			break;
			
		case KeyEvent.VK_UP:
			setMovY(-1);
			break;
			
		case KeyEvent.VK_DOWN:
			setMovY(1);
			break;
			
		default:
			break;
		}
	}
	
	public void releaseKey (KeyEvent k){
		int key = k.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_LEFT:
			setMovX(0);
			break;
			
		case KeyEvent.VK_RIGHT:
			setMovX(0);
			break;
			
		case KeyEvent.VK_UP:
			setMovY(0);
			break;
			
		case KeyEvent.VK_DOWN:
			setMovY(0);
			break;
			
		default:
			break;
		}
	}

}
