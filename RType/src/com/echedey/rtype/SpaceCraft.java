package com.echedey.rtype;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SpaceCraft extends Craft {
	private ArrayList<Missiles> missilesVisible;

	public SpaceCraft() {
		super();
		setSpeed(10);
		setImgURL("./spaceCraft.png");
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(
				getImgURL()));
		setImg(imgIcon.getImage().getScaledInstance(60, 50,
				java.awt.Image.SCALE_SMOOTH));

		// limit space

		// wait for load the img (scale is a bit slow)
		while ((getImg().getWidth(null) == -1)
				|| (getImg().getHeight(null) == -1))
			continue;
		setMaxX(getMaxX() - getImg().getWidth(null)); // - width image
		setMaxY(getMaxY() - getImg().getHeight(null)); // - height image
		// default position
		setX(20);
		setY(getMaxY() / 2);

		missilesVisible = new ArrayList<Missiles>();

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

		case KeyEvent.VK_SPACE:
			trigger(true);
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

		case KeyEvent.VK_SPACE:
			trigger(false);
			break;

		default:
			break;
		}
	}

	public void trigger(boolean shoot) {
		if (shoot)
			missilesVisible.add(new Missiles(getX() + getImg().getWidth(null),
					getY() + getImg().getHeight(null) / 2));
	}

	public ArrayList<Missiles> getMissilesVisible() {
		return missilesVisible;
	}

}
