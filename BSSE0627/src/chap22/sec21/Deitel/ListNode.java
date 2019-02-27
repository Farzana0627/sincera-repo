package chap22.sec21.Deitel;

public class ListNode< T >
{

	public T data; 
	public ListNode< T > nextNode; 
	

	public ListNode( T object )
	{
		this( object, null );
	} 

	public ListNode( T object, ListNode< T > node )
	{
		data = object;
		nextNode = node;
	}

	public T getData()
	{
		return data; 
	} 

	public ListNode< T > getNext()
	{
		return nextNode; 
	} 
} 