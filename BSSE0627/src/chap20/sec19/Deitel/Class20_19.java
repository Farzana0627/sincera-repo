package chap20.sec19.Deitel;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Class20_19 {
	public static void main(String[] args) {
		
		System.out.println("Enter a whole number:");
		Scanner scr= new Scanner (System.in);
		Integer number= scr.nextInt();
		scr.close();

		if(Prime(number)==true)
			System.out.println("Prime!");
	}
	
	public static boolean Prime(Integer input)
	{
		
		if(input==1) System.out.println("Not Prime!");
		else
		{
			Set<Integer> Factors= new TreeSet<>();
			//check prime
			for(int i=2; i<=Math.sqrt(input); i++)
			{
				if(input%i==0 && Prime(i)) 
					Factors.add(i);
			}
			if(Factors.isEmpty()){
				
				return true;
			}
			else {
				System.out.println("Prime factors:\n"+ Factors);
				return false;
			}
		}
		return false;
	}
}
