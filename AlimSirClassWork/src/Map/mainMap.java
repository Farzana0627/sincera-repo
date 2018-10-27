package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class mainMap {
	public static void main(String[] args) {
		Map <String, Integer> myMap= new HashMap<>();// K= index; V= value
		myMap.put("Black", 1);
		myMap.put("Green", 2);
		myMap.put("Red", 3);
		myMap.put("Blue", 5);
		
		TreeSet<String> ts= new TreeSet<>(myMap.keySet());
		for(String s: ts)
			System.out.println(s+": "+ myMap.get(s));// sorted keys
		
		System.out.println("\n");
		

		Integer a=myMap.get("Green");
		myMap.put("Green", ++a);// age increament then impelment
		
		
		System.out.println("Green: "+myMap.get("Green"));
		Integer b=myMap.get("Green");
		myMap.put("Green", b++);// age  impelment then increament 
		
		System.out.println("Green: "+myMap.get("Green"));
		
		System.out.println("key set: "+myMap.keySet());
		System.out.println("\n");
		for(Map.Entry<String, Integer> m: myMap.entrySet())
		{
			System.out.println(m.getKey()+" "+ m.getValue());
		}
		
	}
}
