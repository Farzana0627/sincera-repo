package chap20.sec13.Deitel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Class20_13 {
	public static void main(String[] args) {
		List<String> FirstNames= new ArrayList<>();
		FirstNames.add("Farzana");
		FirstNames.add("Tasnim");
		FirstNames.add("Rubama");
		FirstNames.add("Rubaiyat");
		FirstNames.add("Tawsif");
		FirstNames.add("Feroz");
		FirstNames.add("Tasnim");
		FirstNames.add("Rubama");
		FirstNames.add("Tasnim");
		FirstNames.add("Rubaiyat");
		FirstNames.add("Feroz");
		FirstNames.add("Farzana");
		
		Set<String> SetOfFirstNames= new TreeSet<>(FirstNames);
		System.out.println(SetOfFirstNames);
		
		System.out.println("Search for a first name:");
		Scanner scr= new Scanner(System.in);
		String s= scr.next();
		scr.close();
		boolean flag=false;
		for(String str: SetOfFirstNames)
		{
			if(str.equals(s)) {
				System.out.println("Found "+s);
				flag=true;
				break;
			}	
		}
		if(flag==false)
			System.out.println("Not Found!");
		
	
	}
}
