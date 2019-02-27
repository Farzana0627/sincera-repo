package chap21.sec05.Deitel;

public class GenericMethodTest {
	public static void main(String[] args) {
		// create arrays of Integer, Double and Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		
		System.out.println( "Array integerArray contains:" );
		printArray( intArray, 0, 3 );
		
		System.out.println( "\nArray doubleArray contains:" );
		printArray( doubleArray,2,5 );
		
		System.out.println( "\nArray characterArray contains:" );
		printArray( charArray, 1,4 );
		
		printArray( intArray, 2,6  );
		printArray( doubleArray,-1,3 );
		printArray( charArray, 1,9 );
	} 


		public static < T > void printArray( T[] inputArray, int lowerSubscript,int higherSubscript ) throws IndexOutOfBoundsException
		{
			if(lowerSubscript<0 || higherSubscript> inputArray.length-1)
			{
				throw new IndexOutOfBoundsException();
				
			}
			for ( int i=lowerSubscript; i<=higherSubscript;i++)
				System.out.printf( "%s ", inputArray[i] );
			System.out.println();
		}
}
