package chap22.sec21.Deitel;

import java.util.Scanner;


public class ListTest
{	
	public static void main( String[] args ) 
	{
		List< Integer > list = new List< Integer >(); 
	
		list.insertAtFront( -1 );
		list.print();
		list.insertAtFront( 0 );
		list.print();
		list.insertAtBack( 1 );
		list.print();
		list.insertAtBack( 5 );
		
		list.print();
		System.out.println("Enter the data of the node to search: ");
		Scanner scr= new Scanner(System.in);
		int data= scr.nextInt();
		scr.close();
		
		list.Search(data);
		
} 
} 

