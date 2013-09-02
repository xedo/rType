package com.echedey.rtype;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class SpaceCraft extends Craft {

	public SpaceCraft() {
		super();
		speed = 10;
		imgURL = "./spaceCraft.png";
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(imgURL));
		img = imgIcon.getImage().getScaledInstance(60, 50, java.awt.Image.SCALE_FAST);

		// limit space

		// wait for load the img (scale is a bit slow)
		while ((img.getWidth(null) == -1) || (img.getHeight(null) == -1))
			continue;
		maxX -= img.getWidth(null); // - width image
		maxY -= img.getHeight(null); // - height image
		System.out.println(maxX + "x" + maxY);
		
		// default position
		x = 20;
		y = maxY/2;

	}

	public void pressKey(KeyEvent k) {
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

	public void releaseKey(KeyEvent k) {
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
