package StringOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StringMain {
	public static void main(String[] args) {
		
		Map<String, Integer> StringMap= new HashMap<String, Integer>();
		
		Scanner scr= new Scanner(System.in);
		StringMap.put("m",1 );
		System.out.println("Enter a string:");
		
		while(true)
		{
			String s=scr.next();
			if(s=="q") break;
			if(StringMap.containsKey(s)){

				System.out.println("Encountered Before: "+StringMap.get(s));
				continue;
			}
			else 
			{
				Set <Character> setOfCharacters= new HashSet<>();

				for(int i=0; i< s.length(); i++){
				
				char c= s.charAt(i);
				setOfCharacters.add(c);
					
				StringMap.put(s, setOfCharacters.size());
				}
			}
			System.out.println(StringMap.get(s));
		}
		scr.close();
	}
}
