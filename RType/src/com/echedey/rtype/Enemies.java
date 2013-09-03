package com.echedey.rtype;

import javax.swing.ImageIcon;

public class Enemies extends Craft {

	public Enemies() {
		super();
		setImgURL("./enemy1.png");
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(
				getImgURL()));
		setImg(imgIcon.getImage());// .getScaledInstance(60, 50,
		// java.awt.Image.SCALE_SMOOTH));

		setMovX(-1);
		setMovY(0);
		setX(getMaxX());
		setY((int)(Math.random()*100));

	}

	@Override
	public void move() {
		// X
		setX(getX() + getMovX() * getSpeed());
		if (getX() >= getMaxX())
			setX(getMinX());
		if (getX() <= getMinX())
			setX(getMaxX());

		// Y
		setY(getY() + getMovY() * getSpeed());
		if (getY() >= getMaxY())
			setY(getMinY());
		if (getY() <= getMinY())
			setY(getMaxY());
	}
}