package chap20.sec18.Deitel;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Class20_18 {
	public static void main(String[] args) {
		Character [] array= {'a','b','n','c','h','t','i','k','f','g'};
		
		LinkedList<Character> list1= new LinkedList<>(Arrays.asList(array));
		LinkedList<Character> list2= new LinkedList<>(list1);
		
		Collections.reverse(list2);
		System.out.println(list1);
		System.out.println(list2);
	}
}
