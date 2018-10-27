package com.nullString.BlackJack;

import javax.swing.JFrame;

public class MainApp {
	public static void main(String[] args) {
	
	
		 final BlackJackFrame  blackJackApp = new BlackJackFrame();
		
		blackJackApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		blackJackApp.setSize(725, 525);
		blackJackApp.setVisible(true);		
	}
}