package chap21.sec07.Deitel;

import java.util.Scanner;

public class Equal {
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner inputData = new Scanner(System.in);
		Object object1, object2;
		
		System.out.println("Enter two integer :");
		object1 = inputData.nextInt();
		object2 = inputData.nextInt();
		
		if(IsEqualTo(object1, object2))
			System.out.println(object1+" and "+object2+" are "+"equal!");
		else System.out.println(object1+" and "+object2+" are not "+"equal!");
		
		System.out.println("Enter two String :");
		object1 = inputData.next();
		object2 = inputData.next();
		
		if(IsEqualTo(object1, object2))
			System.out.println(object1+" and "+object2+" are "+"equal!");
		else System.out.println(object1+" and "+object2+" are not "+"equal!");
		
		System.out.println("Enter two double :");
		object1 = inputData.nextDouble();
		object2 = inputData.nextDouble();
		
		if(IsEqualTo(object1, object2))
			System.out.println(object1+" and "+object2+" are "+"equal!");
		else System.out.println(object1+" and "+object2+" are not "+"equal!");
		
		
	}
	
	public static <T> boolean IsEqualTo(T o1, T o2)
	{
		if(o1.equals(o2))
			return true;
		else return false;
	}

}
