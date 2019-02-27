package chap21.sec04.Deitel;

public class SelectionSort {
	
	public <T extends Comparable<T>> SelectionSort  (T[] data)
	{
		int smallest;
		for ( int i = 0; i < data.length - 1; i++ )
		{
			smallest = i; 
			@SuppressWarnings("unused")
			T min=data[i];
			for ( int index = i ; index < data.length; index++ )
				if ( data [ index ].compareTo(data[ smallest ])<0  )
				{	
					min=data[index];
					smallest = index;
				}
			T temporary =  data[i]; 
			data[i]  =  data[smallest] ; 
			data[smallest] = temporary;
		
		}
		printArray(data);
	
	}

	public <T> void printArray( T[] array )
	{
		
		for ( int i = 0; i < array.length; i++ )
			System.out.print( array[ i ] + " " );
		System.out.println();
	} 
}
