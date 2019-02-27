package chap20.sec16.Deitel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Class20_16 {
	public static void main(String[] args) {
		Scanner scr= new Scanner(System.in);
		System.out.println("Write a sentence: ");
		String s= scr.nextLine();
		scr.close();
		String[] words = s.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
		Map<String, Integer> wordCounts = new HashMap<String, Integer>();

		for (String word : words) {
		    Integer count = wordCounts.get(word);
		    if (count == null) {
		        count = 0;
		    }
		    wordCounts.put(word, count + 1);
		}
		for(Map.Entry<String, Integer> m: wordCounts.entrySet() )
			System.out.println(m.getKey()+" "+ m.getValue());
	}
}
