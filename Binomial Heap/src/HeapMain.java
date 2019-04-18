
public class HeapMain {
	public static void main(String[] args) {
		Heap heap= new Heap();
		int A[]= {0,3,5,8,7,1,13,11,15,6};
		int last= A.length-1;
		A=heap.BuildHeap(A,last);
		
		heap.HeapSort(A, last);
		heap.PrintHeap(A);
	}
}
