package chap21.sec06.Deitel;

public class OverloadingTest {
	public static void main(String[] args) {
		// create arrays of Integer, Double and Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		String[] stringArray={"Muna", "Mumu","Snigdha","Fabiha"};
		
		System.out.println( "Array integerArray contains:" );
		printArray( intArray);
		
		System.out.println( "\nArray doubleArray contains:" );
		printArray( doubleArray );
		
		System.out.println( "\nArray characterArray contains:" );
		printArray( charArray );
		
		System.out.println( "\nArray characterArray contains:" );
		printArray( charArray );
		
		System.out.println( "\nArray StringArray contains:" );
		printArray( stringArray );
	}
	public static < T > void printArray( T[] inputArray )
	{
		
		for ( T element : inputArray )
			System.out.printf( "%s ", element );
		System.out.println();
	}
	public static void printArray( String[] inputArray )
	{
		int i=0;
		for ( String element : inputArray ){
			System.out.printf( "%-10s", element );
			
			if(i==inputArray.length/2-1)
				System.out.println();
			i++;
		}
			
		System.out.println();
	}
}
