package com.echedey.rtype;

import javax.swing.ImageIcon;

public class Enemies extends Craft {

	public Enemies() {
		super();
		setImgURL("./enemy1.png");
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(
				getImgURL()));
		setImg(imgIcon.getImage().getScaledInstance(50, 50,
				java.awt.Image.SCALE_SMOOTH));

		// limit space

		// wait for load the img (scale is a bit slow)
		while ((getImg().getHeight(null) == -1))
			continue;
		setMaxY(getMaxY() - getImg().getHeight(null)); // - height image

		setSpeed(5);
		setMovX(-1);
		setMovY(0);
		// set random horizontal positions
		setX(getMaxX() + (int) (Math.random() * 800));
		setY((int) (Math.random() * 600));

	}

	@Override
	public void move() {
		// X
		setX(getX() + getMovX() * getSpeed());
		// if (getX() >= getMaxX())
		// setX(getMinX());
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