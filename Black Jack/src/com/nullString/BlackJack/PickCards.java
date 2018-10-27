package com.nullString.BlackJack;

import java.util.List;
import java.util.ArrayList;


public class PickCards{
	
	private static List <Cards> comHand = new ArrayList<Cards>(); //cards in the hand of computer
	private static List <Cards> playerHand  = new ArrayList<Cards>(); //cards in the hand of player
	private DeckOfCards  deck = new DeckOfCards();
	public static ArrayList <Cards> deckOfCard;
	
	
	//constructor to set player hand and com hand
	public PickCards(){
		deck.createDeck(); //make a deck of cards in DeckOfCards
		deckOfCard = deck.shuffledDeck(); //get shuffled deck
		playerHand =  deckOfCard.subList(0, 2);
		comHand =  deckOfCard.subList(2, 4);
	
	}//end constructor

	//return playerHand
	public List<Cards> getPlayerHand(){
		return playerHand;
	}//end getPlayerCard
		
	//return comHand
	public List<Cards> getComHand(){
		return comHand;
	}//end getComHand

	public ArrayList<Cards> getDeckOfCard() {
		
		return deckOfCard;
	}
	
}//end class PickCards