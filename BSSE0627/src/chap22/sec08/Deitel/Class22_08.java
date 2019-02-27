package chap22.sec08.Deitel;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

	public class Class22_08  {
		public static LinkedList<Integer> SortedList1;
		public static void main(String[] args) {
			SortedList1= new LinkedList<>();
			LinkedList<Integer> SortedList2= new LinkedList<>();
			SortedList object= new SortedList();
			Random r= new Random();
			
			for(int i=0 ; i<25; i++)
				SortedList2.add(r.nextInt(100));
			Collections.sort(SortedList2);
			System.out.println("SortedList1: "+object.SortedList1);
			System.out.println("SortedList2: "+ SortedList2);
			object.merge(SortedList2);
			System.out.println("SortedList1: "+object.SortedList1);
			
			
		}
	
	
	}

