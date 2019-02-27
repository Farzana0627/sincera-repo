package chap20.sec14.Deitel;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MapOperations {
	public void createMap( Map<Character, Integer > map )
	{
		Scanner scanner = new Scanner( System.in ); 
		System.out.println( "Enter a string:" ); 
		String input = scanner.nextLine();
		scanner.close();
	
		String[] tokens = input.split( " " );
		
	
		for ( String token : tokens )
		{
			String word = token.toLowerCase(); 
		
			for(int i=0;i<word.length();i++)
			{
				if ( map.containsKey( word.charAt(i) ) ) 
			
				{
					int count = map.get( word.charAt(i) ); 
					map.put( word.charAt(i) , count + 1 ); 
				} 
			else
				map.put( word.charAt(i), 1 ); 
			}
		} 
	} 
	public void displayMap( Map< Character, Integer > map )
	{
	
		Set< Character > keys = map.keySet(); 
	
		TreeSet< Character > sortedKeys = new TreeSet< Character >( keys );
		System.out.println( "\nMap contains:\nKey\t\tValue" );
	
		for ( Character key : sortedKeys )
		System.out.printf( "%-10s%10s\n", key, map.get( key ) );
		System.out.printf(
				"\nsize: %d\nisEmpty: %b\n", map.size() , map.isEmpty() );
	} 
}
