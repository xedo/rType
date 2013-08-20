package com.echedey.rtype;

import java.awt.event.KeyEvent;

public class SpaceCraft extends Craft {
	private String imgURL = "../spaceCraft.png";
	
	public SpaceCraft (){
		super();
		
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
