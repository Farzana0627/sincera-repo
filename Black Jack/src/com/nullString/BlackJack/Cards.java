package com.nullString.BlackJack;

public class Cards {
	//13 Faces of card 
	public static enum Face{Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King};
	//Four suits of deck
	public static enum Suit{Spade, Diamonds, Hearts, Clubs};
	
	private final Face face;
	private final Suit suit;
	public int value; //contains value of a card
	
	public Cards(Face cardFace, Suit cardSuit){ 
		//final variables initialized
		face = cardFace;
		suit = cardSuit;
	}//end constructor
	
	public String toString(){
		
		return String.format("%s of %s", face, suit);
	}//end toString

}//end class Cards