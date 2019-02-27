package chap22.sec26.Deitel;


public class ListNode< T >
{

	public T data; 
	public  ListNode< T > nextNode; 
	

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
	public void setNext(ListNode<T> next)
	{
		nextNode=next; 
	} 
} 