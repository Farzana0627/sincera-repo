package Class.assignment;

public class PrintArray {
	public static void main(String[] args) {
		
	Integer[] intArray = {1,2,3};
	String[] stringArray={"muna","fabi","snigdha","mumu"};
	
	printArray(intArray);
	printArray(stringArray);
	System.out.println("Maximum: "+ maximum(5,6,7));
	
	}

	public static <T extends Comparable<T>> T maximum(T a,T b,T c) {
		T max=a;
		if(max.compareTo(b)<0)
			max=b;
		if(max.compareTo(c)<0)
			max= c;
		return max;
		
	}
	/*	public static void printArray(Object[] array)
	{
		for(Object a: array)
			System.out.println(a);
	}*/
	
	public static <E> void printArray(E [] array)
	{
		for(E a: array)
			System.out.println(a);
	}
/*	public static  Comparable maximum (Comparable a, Comparable b, Comparable c) {
		Comparable max= a;
		if(max.compareTo(b)<0)
			max= b;
		if(max.compareTo(c)<0)
			max=c;
		return max;
	}*/
	
}