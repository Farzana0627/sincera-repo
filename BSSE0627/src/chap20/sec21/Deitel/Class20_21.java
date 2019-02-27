package chap20.sec21.Deitel;

import java.util.PriorityQueue;
import java.util.Queue;

public class Class20_21 {
	public static void main(String[] args) {
		Queue<Double> queue= new PriorityQueue<>(3, new MyComparator());
		// insert elements to queue
		queue.offer( 3.2 );
		queue.offer( 9.8 );
		queue.offer( 5.4 );
		System.out.print( "Polling from queue: " );
		while ( queue.size() > 0 )
		{
			System.out.printf( "%.1f ", queue.peek() ); // view top element
			queue.poll(); // remove top element
		}
	}
}


