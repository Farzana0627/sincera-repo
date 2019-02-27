package chap22.sec08.Deitel;

import java.util.LinkedList;
import java.util.Random;

public class SortedList {
	 LinkedList<Integer> SortedList1;
	
	 public SortedList() {
		// TODO Auto-generated constructor stub
		 SortedList1= new LinkedList<>();
			Random r= new Random();
			for(int i=0; i< 25; i++)
				addvalue(r.nextInt(100));
	}
		
	public void addvalue(int value)
	{
		if(SortedList1.size()==0) {
			SortedList1.add(value);
			return;
		}
		else if(SortedList1.get(0)>value){
			SortedList1.add(0, value);
			return;
		}
		else if(SortedList1.get(SortedList1.size()-1)<value)
		{
			SortedList1.add(value);
			return;
		}
		else 
		{
			int i=0;
			while(SortedList1.get(i)<value)
				i++;
			SortedList1.add(i, value);
		}
		
	}
	public void merge(LinkedList<Integer> list)
	{
		for(int i=0; i<list.size();i++)
			addvalue(list.get(i));
	}
}

