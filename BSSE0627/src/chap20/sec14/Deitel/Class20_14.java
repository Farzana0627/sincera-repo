package chap20.sec14.Deitel;

import java.util.HashMap;
import java.util.Map;

public class Class20_14 {
	public static void main( String[] args )
	{
	
	MapOperations object= new MapOperations();
	Map< Character, Integer > myMap = new HashMap< Character, Integer >();
	object.createMap( myMap ); 
	object.displayMap( myMap );
	}
	
}
