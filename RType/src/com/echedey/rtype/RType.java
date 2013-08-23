package com.echedey.rtype;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RType implements ActionListener {
	private JFrame menu;
	private JButton btnEasy, btnNorm, btnHard, btnNM;
	
	public RType(){
		//Window
		menu = new JFrame();
		menu.setLayout(new GridLayout(5,1));
		menu.setSize(300, 300);
		menu.setResizable(false);
		menu.setAlwaysOnTop(false);
		menu.setTitle("RType");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Menssage
		JLabel welcome = new JLabel ("Difficulty");
		welcome.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		menu.add(welcome);
		
		//Buttons
		btnEasy = new JButton("Easy");
		btnEasy.addActionListener(this);
		menu.add(btnEasy);
		
		btnNorm = new JButton("Normal");
		btnNorm.addActionListener(this);
		menu.add(btnNorm);
		
		btnHard = new JButton("Hard");
		btnHard.addActionListener(this);
		menu.add(btnHard);
		
		btnNM = new JButton("Night Mare");
		btnNM.addActionListener(this);
		menu.add(btnNM);
		
		//Center window
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		play(e.getActionCommand());
		System.out.println(e.getActionCommand());
//		menu.dispose();
	}
	private void play(String level) {
		JFrame window = new JFrame();
		window.setTitle("RType - level: " + level);
		window.setSize(800, 600);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(new Animation(level));
		window.setVisible(true);
		
	}

	public static void main(String[] args) {
	   new RType();
	}

}
