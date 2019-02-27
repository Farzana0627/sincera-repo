package chap21.sec04.Deitel;

import java.util.Random;
import java.util.Scanner;

public class SelectionSortTest {
	public static void main(String[] args) {
		Scanner scr= new Scanner(System.in);
		Integer [] Integers= new Integer[10];
		Float [] floatingNumbers= new Float[10];
		Random r= new Random();
		for(int i=0; i<10; i++)
		{
			Integers[i]= r.nextInt(100);
			floatingNumbers[i]=r.nextFloat();
		}
		scr.close();
		@SuppressWarnings("unused")
		SelectionSort sortInt= new SelectionSort(Integers);
		@SuppressWarnings("unused")
		SelectionSort sortDounle= new SelectionSort(floatingNumbers);
		
		
	}
}
