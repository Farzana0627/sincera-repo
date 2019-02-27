package chap22.sec07.Deitel;

import java.util.LinkedList;
import java.util.Random;

public class SortedList {
	public static LinkedList<Integer> SortedList;
	public static void main(String[] args) {
		SortedList= new LinkedList<>();
		Random r= new Random();
		for(int i=0; i< 25; i++)
			addvalue(r.nextInt(100));
		System.out.println(SortedList);
	}
	public static void addvalue(int value)
	{
		if(SortedList.size()==0) {
			SortedList.add(value);
			return;
		}
		else if(SortedList.get(0)>value){
			SortedList.add(0, value);
			return;
		}
		else if(SortedList.get(SortedList.size()-1)<value)
		{
			SortedList.add(value);
			return;
		}
		else 
		{
			int i=0;
			while(SortedList.get(i)<value)
				i++;
			SortedList.add(i, value);
		}
		
	}
}
