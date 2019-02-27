package chap22.sec30.Deitel;

import java.util.Scanner;

public class QueueTest {
	@SuppressWarnings("unchecked")
	public static void main( String[] args ) throws Exception 
	{
		Queue queue = new Queue(); 
		
		queue.insertAtFront( -1 );
		queue.print();
		queue.insertAtFront( 0 );
		queue.print();
		queue.insertAtBack( 1 );
		queue.print();
		queue.insertAtBack( 5 );
		
		queue.print();
		System.out.println("Enter the data of the node to search: ");
		Scanner scr= new Scanner(System.in);
		int data= scr.nextInt();
		scr.close();
		
		queue.Search(data);
	} 
}
