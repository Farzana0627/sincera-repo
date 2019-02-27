package chap22.sec27.Deitel;


class ListNode< T >
{

	T data; 
	ListNode< T > nextNode; 
	

	ListNode( T object )
	{
		this( object, null );
	} 

	ListNode( T object, ListNode< T > node )
	{
		data = object;
		nextNode = node;
	}

	T getData()
	{
		return data; 
	} 

	ListNode< T > getNext()
	{
		return nextNode; 
	} 
	public void setNext(ListNode<T> next)
	{
		nextNode=next; 
	} 
} 
