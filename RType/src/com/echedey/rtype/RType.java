package com.echedey.rtype;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RType implements ActionListener {
	private JFrame menu;
	
	public RType(){
		//Window
		menu = new JFrame();
		menu.setLayout(new GridLayout(5,1));
		menu.setSize(300, 300);
		menu.setResizable(false);
		menu.setAlwaysOnTop(false);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setTitle("RType");
		
		//Menssage
		JLabel welcome = new JLabel ("Difficulty");
		welcome.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		menu.add(welcome);
		
		//Buttons
		JButton btnEasy = new JButton("Easy");
		btnEasy.addActionListener(this);
		menu.add(btnEasy);
		
		JButton btnNorm = new JButton("Normal");
		btnEasy.addActionListener(this);
		menu.add(btnNorm);
		
		JButton btnHard = new JButton("Hard");
		btnEasy.addActionListener(this);
		menu.add(btnHard);
		
		JButton btnNM = new JButton("Night Mare");
		btnEasy.addActionListener(this);
		menu.add(btnNM);
		
		//Center window
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	public static void main(String[] args) {
	   new RType();
	}

}
