package chap22.sec06.Deitel;

import java.util.LinkedList;

public class ListConcatenate {
	public static void main(String[] args) {
		LinkedList< Character> list1= new LinkedList<>();
		LinkedList< Character> list2= new LinkedList<>();
		list1.add('m');
		list1.add('u');
		list1.add('n');
		list1.add('a');
		list2.add('m');
		list2.add('a');
		list2.add('h');
		list2.add('a');
		concatanate(list1, list2);
		System.out.println(list1);
	}
	public static void concatanate(LinkedList<Character> list1, LinkedList<Character> list2)
	{
		list1.addAll(list2);
	}
}
