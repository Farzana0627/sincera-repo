package CollectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ArrayListIteratorDemo {
	public static void main(String[] args) {
		String[] c= {"Red","Green","Blue","Yellow"};
		List <String> colorBank = new ArrayList <> ();
		for(String s: c)
			colorBank.add(s);
		String[] r={"Red","Green"};
		List <String> removeColorList = new ArrayList <>();
		for(String s: r)
			removeColorList.add(s);
		
		System.out.print("Before\n");
		for(int i=0; i<colorBank.size(); i++)
		{
			System.out.print(colorBank.get(i)+" ");
		}
		
			removeColor(colorBank, removeColorList);
			
		System.out.print("\nAfter\n");
		for(int i=0; i<colorBank.size(); i++)
		{
			System.out.print(colorBank.get(i)+" ");
		}
	}
	
	static void removeColor(List<String> L1,List<String> L2 )
	{
		/*if(L2.containsAll(L1))
		{
			System.out.print("All");
		}
		else {	
			System.out.print("NOT All");
		}*/
			
		Iterator <String>  it= L1.iterator();
		while(it.hasNext())
		{
			if(L2.contains(it.next()))
				it.remove();
			
		}
	}

}
