package com.nullString.BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class DeckOfCards{
	//Assigns cards to deck array and returns a shuffled deck	
		
		protected ArrayList <Cards> cards ; //contains the cards of deck
		protected ArrayList <Cards> original; //contains un-shuffled deck
		private Cards deck[] = new Cards[52]; //an empty deck of 52 spaces
		
		//assign cards to the deck
		
		public void createDeck(){
			
			int count = 0;
			
			for (Cards.Suit suit : Cards.Suit.values())
				for (Cards.Face face : Cards.Face.values()){
					deck [count] = new Cards(face, suit);
					
					//assign value to card
					String str = String.format("%s",face);
					
					switch(str){
					
					case "Ace":
						deck[count].value = 11;
						break;
					case "Deuce":
						deck[count].value = 2;
						break;
					case "Three":
						deck[count].value = 3;
						break;
					case "Four":
						deck[count].value = 4;
						break;
					case "Five":
						deck[count].value = 5;
						break;
					case "Six":
						deck[count].value = 6;
						break;
					case "Seven":
						deck[count].value = 7;
						break;
					case "Eight":
						deck[count].value = 8;
						break;
					case "Nine":
						deck[count].value = 9;
						break;
					case "Ten":
						
					case "Jack":
					
					case "Queen":
						
					case "King":
						deck[count].value = 10;
						break;
					default:
						deck[count].value =  0;
						break;
					
					}//end switch block
					
					count++;
				} //end inner for
			//end outer for
		}//end method createDeck
		
		//return shuffled cards
		public ArrayList <Cards> shuffledDeck(){
			cards = new ArrayList <Cards> (Arrays.asList(deck));
			Collections.shuffle(cards);
			return cards;
		}
		
		//return original deck in strings
		public ArrayList <String> originalDeck(){
			createDeck();
			original = new ArrayList <Cards> (Arrays.asList(deck));
			ArrayList <String> unShuffled = new ArrayList<String>();
			for(int i = 0; i < original.size(); i++){
				
				String str = String.format("%s",original.get(i));
				unShuffled.add(str);
			}
			return unShuffled;
		} //end method 
		
}//end class DeckOfCards