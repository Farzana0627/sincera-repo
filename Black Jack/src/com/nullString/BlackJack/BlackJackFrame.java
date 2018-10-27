package com.nullString.BlackJack;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class BlackJackFrame extends JFrame {

	//GUI component instances
	private JPanel contentPane;
	private JLabel comLabel;
	private JLabel comCard1Label;
	private JLabel comCard2Label;
	private JLabel comCard3Label;
	private JLabel comCard4Label;
	private JLabel comCard5Label;
	private JLabel playerLabel;
	private JLabel playerCard1Label;
	private JLabel playerCard2Label;
	private JLabel playerCard3Label;
	private JLabel playerCard4Label;
	private JLabel playerCard5Label;
	private JButton dealButton;
	private JButton hitButton;
	private JButton stayButton;
	private JLabel gameStatus;
	private JLabel comTotal;
	private JLabel playerTotal;
	//Card handling instances
	private DeckOfCards deck = new DeckOfCards();
	private PickCards pick = new PickCards();
	private List <String> original = new ArrayList <String>();
	private List <Cards> comCards = new ArrayList <Cards>();
	private List <Cards> playerCards = new ArrayList <Cards>(); 
	private ArrayList<Cards> cardList = pick.deckOfCard;
	private int secondComCard;
	private int scorePlayer=0,scoreCom=0;
	int cardCount = 4;
	int count = 2;

	
	
	//constructor to set up the GUI-components
	public BlackJackFrame() {
		
		super("BLACK JACK");
		
		setBounds(100, 100, 724, 522);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comLabel = new JLabel("COMPUTER'S HAND");
		comLabel.setBounds(26, 12, 152, 15);
		contentPane.add(comLabel);
		
		comCard1Label = new JLabel();
		comCard1Label.setBounds(26, 39, 79, 102);
		contentPane.add(comCard1Label);
		
		comCard2Label = new JLabel();
		comCard2Label.setBounds(116, 39, 79, 102);
		contentPane.add(comCard2Label);
				
		comCard3Label = new JLabel();
		comCard3Label.setBounds(206, 39, 79, 102);
		contentPane.add(comCard3Label);
		
		comCard4Label = new JLabel();
		comCard4Label.setBounds(296, 39, 79, 102);
		contentPane.add(comCard4Label);
		
		comCard5Label = new JLabel();
		comCard5Label.setBounds(386, 39, 79, 102);
		contentPane.add(comCard5Label);
		
		playerLabel = new JLabel("PLAYER'S HAND");
		playerLabel.setBounds(26, 245, 152, 15);
		contentPane.add(playerLabel);
		
		playerCard1Label = new JLabel();
		playerCard1Label.setBounds(26, 272, 79, 102);
		contentPane.add(playerCard1Label);
		
		playerCard2Label = new JLabel();
		playerCard2Label.setBounds(116, 272, 79, 102);
		contentPane.add(playerCard2Label);
		
		playerCard3Label = new JLabel();
		playerCard3Label.setBounds(206, 272, 79, 102);
		contentPane.add(playerCard3Label);
		
		playerCard4Label = new JLabel();
		playerCard4Label.setBounds(296, 272, 79, 102);
		contentPane.add(playerCard4Label);
		
		playerCard5Label = new JLabel();
		playerCard5Label.setBounds(386, 272, 79, 102);
		contentPane.add(playerCard5Label);
		
		dealButton = new JButton("DEAL");
		dealButton.setBounds(555, 75, 120, 50);
		contentPane.add(dealButton);
		
		hitButton = new JButton("HIT");
		hitButton.setEnabled(false);
		hitButton.setBounds(555, 130, 120, 50);
		contentPane.add(hitButton);
		
		stayButton = new JButton("STAY");
		stayButton.setEnabled(false);
		stayButton.setBounds(555, 185, 120, 50);
		contentPane.add(stayButton);
		
		gameStatus = new JLabel();
		gameStatus.setBounds(495, 285, 150, 15);
		contentPane.add(gameStatus);
		
		comTotal = new JLabel("COMPUTER TOTAL:");
		comTotal.setBounds(495, 305, 150, 15);
		contentPane.add(comTotal);
		
		playerTotal = new JLabel("PLAYER TOTAL:");
		playerTotal.setBounds(495, 325, 150, 15);
		contentPane.add(playerTotal);
		
		//original un-shuffled deck for icon assigning
		
		//add action listeners for buttons
		dealButton.addActionListener(
				new ActionListener() { //anonymous inner class starts
					
					@Override
					public void actionPerformed(ActionEvent event) {
						//enable hit and stay button for playing
						hitButton.setEnabled(true);
						stayButton.setEnabled(true);
						
						comCards = pick.getComHand(); //cards in computer hand
						playerCards = pick.getPlayerHand(); //cards in players hand
						
						//change first dealer card label
						Cards card = comCards.get(0);
						scoreCom += getCardValue(card);
						int index = indexOfCard(card);
						comCard1Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
						
						//change second dealer card
						card = comCards.get(1);
						scoreCom += getCardValue(card);
						secondComCard = indexOfCard(card);
						comCard2Label.setIcon(new ImageIcon(getClass().getResource("s.png")));
						
						
						//first player card
						card = playerCards.get(0);
						scorePlayer += getCardValue(card);
						index = indexOfCard(card);
						playerCard1Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
						
						//second player card
						card = playerCards.get(1);
						scorePlayer += getCardValue(card);
						index = indexOfCard(card);
						playerCard2Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
						
						if(scorePlayer <21 ){
							
							gameStatus.setText("CONTINUE");
							playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
						}
						
						if(scorePlayer == 21 ){
							
							gameStatus.setText("BLACKJACK");
							comCard2Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", secondComCard)+".gif")));
							playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
							comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
							hitButton.setEnabled(false);
							stayButton.setEnabled(false);
						}
						
						if(scorePlayer == 21 && scoreCom == 21){
							
							gameStatus.setText("PUSH");
							comCard2Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", secondComCard)+".gif")));
							playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
							comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
							hitButton.setEnabled(false);
							stayButton.setEnabled(false);
						}
						
						if (scoreCom == 21 && scoreCom >scorePlayer){
							
							gameStatus.setText("BLACKJACK");
							comCard2Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", secondComCard)+".gif")));
							playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
							comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
							hitButton.setEnabled(false);
							stayButton.setEnabled(false);
						}
						dealButton.setEnabled(false);
					}//end method actionPerfomed
				}//end anonymous inner class
			);
		
				//action listener for hit button
			hitButton.addActionListener(  
				new ActionListener() { //anonymous class starts
							
					@Override
					public void actionPerformed(ActionEvent event) {
						count++;
								
						Cards card = cardList.get(cardCount);
						int index = indexOfCard(card);
						if(count == 3){
							playerCard3Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
							cardCount++;
						}
						else if(count == 4){
							playerCard4Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
							cardCount++;
						}
						else if(count == 5){
							playerCard5Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
							cardCount++;
						}
						else{
							return;
						}
						if (scorePlayer >= 11 && card.value == 11)
							scorePlayer += 1;
						else
							scorePlayer += getCardValue(card);
							
						if(scorePlayer > 21){
									
							gameStatus.setText("BUSTED");
							hitButton.setEnabled(false);
							stayButton.setEnabled(false);
							comCard2Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", secondComCard)+".gif")));
							comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
							playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
						
						}
						
						if(scorePlayer == 21 && scorePlayer > scoreCom){
									
							gameStatus.setText("BLACKJACK");
							comCard2Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", secondComCard)+".gif")));
							playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
							comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
							hitButton.setEnabled(false);
							stayButton.setEnabled(false);
								
						}
						
						if(scorePlayer <21 && scorePlayer != scoreCom){
									
							gameStatus.setText("CONTINUE");
							playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
						
						}
								
					}
				}//end inner class
						
			);//end adding action listener
			
			
		//add action listener to stayButton
		stayButton.addActionListener( 
			new ActionListener() { //anonymous inner class starts
							
			@Override
			public void actionPerformed(ActionEvent event) {
			
				hitButton.setEnabled(false);
								
				comCard2Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", secondComCard)+".gif")));
								
				for(int i = 0; i < 3 ; i++){
									
					Cards card = cardList.get(cardCount);
					cardCount++;
					int index = indexOfCard(card);
					if(i == 0){
						if(scoreCom >= 11 && scoreCom < 21){
							if(comHit(scoreCom))
								comCard3Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
							else break;
						}
						else
							comCard3Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
						}
						else if(i == 1){
							if(scoreCom >= 11 && scoreCom < 21){
								if(comHit(scoreCom))
									comCard3Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
								else break;
							}
							else
								comCard3Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
						}
						else if(i == 2){
							if(scoreCom >= 11 && scoreCom < 21){
								if(comHit(scoreCom))
									comCard3Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
								else break;
							}
							else
								comCard3Label.setIcon(new ImageIcon(getClass().getResource(String.format("%s", index)+".gif")));
						}
						else 
							break;
									
						if(scoreCom >= 11 && card.value ==11)
							scoreCom++;
						else
							scoreCom += getCardValue(card);
						if(scoreCom >= 21)
							break;
					}//end for 
								
								comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
								
								if(scoreCom > 21){
									gameStatus.setText("COMPUTER BUST");
									playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
									comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
								}
								if(scoreCom == 21 && scoreCom > scorePlayer){
									gameStatus.setText("BLACKJACK");
									playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
									comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
								}
								if(scorePlayer > scoreCom && scoreCom < 21 && scorePlayer < 21){
									gameStatus.setText("PLAYER WIN");
									playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
									comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
								}
								else if(scorePlayer < scoreCom && scoreCom <= 21 && scorePlayer <= 21){
									gameStatus.setText("COMPUTER WIN");
									playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
									comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
								}
								else if(scorePlayer == scoreCom && scoreCom <= 21 && scorePlayer <= 21){
									gameStatus.setText("PUSH");
									playerTotal.setText(String.format("PLAYER TOTAL: %d", scorePlayer));
									comTotal.setText(String.format("COMPUTER TOTAL: %d", scoreCom));
								}
								
								stayButton.setEnabled(false);
							}
						}//end inner class
			); //end add listener
	}//end of constructor	
	
	//obtain index of card in the sorted deck for processing icon
	public int indexOfCard(Cards card){
		
		original = deck.originalDeck();
		String str = String.format("%s", card);
			
		return original.indexOf(str) + 1;
	} //end indexOfCard
		
	//get the associated card value
	public int getCardValue(Cards card){
		
		int cardValue = 0;
		
		if(cardList.contains(card))
			cardValue = cardList.get(cardList.indexOf(card)).value;
		
		return cardValue;
	} //end getCardValue
	
	//computer determines whether to hit further
	public boolean comHit(int scoreCom){
		
		int x = 21 - scoreCom;
		int rnd = new Random().nextInt(10)+ 1;
		if (rnd <= x)
			return true;
		else
			return false;
	}//end method comHit
	
	
}//end class Black Jack Frame