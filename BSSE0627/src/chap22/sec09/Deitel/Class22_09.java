package chap22.sec09.Deitel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Class22_09 {
	@SuppressWarnings("rawtypes")
	public static List reverseList= new ArrayList<>();
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<>();
		Random r= new Random();
		for(int i=0; i<10; i++)
			list.add(r.nextInt(100));
		reverseCopy(list);
		System.out.println(list);
		System.out.println(reverseList);
		
		
	}
	@SuppressWarnings("unchecked")
	public static <T> List<T> reverseCopy(List<T> list)
	{
		for(int i=list.size()-1; i>-1; i--)
			reverseList.add(list.get(i));
		return reverseList;
	}
}
