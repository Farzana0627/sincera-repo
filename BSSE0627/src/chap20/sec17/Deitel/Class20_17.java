package chap20.sec17.Deitel;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Class20_17 {
	public static void main(String[] args) {
		Random r= new Random();
		LinkedList <Integer> list = new LinkedList<>();
		int i=0;
		while(i<25)
		{
			list.add(r.nextInt(101));
			i++;
		}
		Collections.sort(list);
		System.out.println(list);
		Integer sum=0,count=0;
		Iterator<Integer> it= list.iterator();
		while(it.hasNext()){
			count++;
			sum+=it.next();
		}
		System.out.println(count);
		System.out.println("Sum: "+sum);
		System.out.println("Average: "+(float)(sum/count));
		
	}
}
