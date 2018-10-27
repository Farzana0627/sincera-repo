package Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class mainSet {
	public static void main(String[] args) {
	//Hashset starts(unordered)
		Set<String> set= new HashSet<>();
		set.add("apple");
		set.add("orange");
		set.add("apple");
		for(String s: set)
			System.out.println(s);// apple is not printed
		//Hashset ends
		
		System.out.println("\n");
		//Treeset (ordered)
		Set<String> set1= new TreeSet<>();
		set1.add("apple");//a
		set1.add("orange");//o
		set1.add("banana");//b
		for(String s: set1)
			System.out.println(s);
		
	}
}
