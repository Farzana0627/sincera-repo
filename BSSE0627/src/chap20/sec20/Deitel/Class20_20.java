package chap20.sec20.Deitel;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Class20_20 {
	public static void main(String[] args) {
		System.out.println("Enter a sentence in either uppercase or lowercase:");
		Scanner scr= new Scanner(System.in);
		String s= scr.nextLine();// use only uppercase or only lowercase
		scr.close();
		Split(s);
		
	}
	public static void Split(String s)
	{
		String[] array=s.split(" ");
		Set<String> strings= new TreeSet<>();
		Collections.addAll(strings, array);
		System.out.println(strings);
	}
}
