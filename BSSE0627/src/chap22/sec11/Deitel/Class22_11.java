package chap22.sec11.Deitel;

import java.util.Scanner;

public class Class22_11 {
	public static void main(String[] args) {
		Scanner scr= new Scanner(System.in);
		System.out.println("Write a sentence: ");
		String s= scr.nextLine();
		scr.close();
		String letters = s.replaceAll("[^a-zA-Z ]", "").replaceAll("\\s", "").toLowerCase();
		
		String reverse= new StringBuffer(letters).reverse().toString();
		System.out.println(letters);
		System.out.println(reverse);
		if(letters.endsWith(reverse)) System.out.println("Palindrome!");
		else System.out.println(letters+" is not a pallindrome!");
		
	}
}
