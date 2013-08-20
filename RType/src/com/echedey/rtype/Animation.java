package com.echedey.rtype;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation extends JPanel implements ActionListener{
	
	Image img;
	Timer time;
	int x, y; //position
	
	public Animation(String level){
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		time = new Timer(30,this);
		time.start(); //start actionPerfomred
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		//set graphics
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//move spacecraft
		//move missiles
		//move enemies
		
		repaint();
		
	}

}
