package chap22.sec30.Deitel;
import java.util.EmptyStackException;

import chap22.sec21.Deitel.*;

@SuppressWarnings("rawtypes")
public class Queue extends List {
	
	public Queue()
	{
		super( "queue" );
	}
	
	@SuppressWarnings("unchecked")
	public synchronized void enqueue( Object object )
	{
		insertAtBack( object );
	}
	
	public void dequeue() throws EmptyStackException
	{
		removeFromFront();
	}
}


