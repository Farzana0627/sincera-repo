
public class Heap {
	
	
	public Heap() {
		// TODO Auto-generated constructor stub
	}
	public int[] BuildHeap(int[] A, int last) {
		for(int i=(int) (last/2); i>0; i--)
			MaxHeapify(A,i,last);
		
		return A;
	}
	public void MaxHeapify(int[] A, int parent, int last)
	{
		int child= 2*parent;
		while (child <= last)
		{
			if((child+1) <= last && A[child+1]> A[child])
				child++;
			if(A[child]> A[parent]){
				int tempChild=A[child];
				int tempParent=A[parent];
				A[child]= tempParent;
				A[parent]=tempChild;
			}
			parent= child;
			child= 2*parent;
		}

	}
	public void HeapSort(int[] A, int last)
	{
		BuildHeap(A, last);
		System.out.println("MaxHeap: ");
		PrintHeap(A);
		
		while(last>1)
		{
			int temp1=A[1];
			int temp2=A[last];
			A[1]= temp2;
			A[last]=temp1;
			PrintHeap(A);
			last--;
			FloydHeapify(A, last);

		}
	}
	public void FloydHeapify(int[] A, int last)
	{
		int parent=1, child=2;
		while(child<= last )
		{
			if((child+1)<= last && A[child]< A[child+1])
				child++;
			
			int tempChild=A[child];
			int tempParent=A[parent];
			A[child]= tempParent;
			A[parent]=tempChild;
			parent= child;
			child= 2*parent;
			PrintHeap(A);
		}
		
		while(parent>1 && A[parent]> A[parent/2])
		{
			int temp1=A[parent];
			int temp2=A[parent/2];
			A[parent]= temp2;
			A[parent/2]=temp1;
			parent= parent/2;
			PrintHeap(A);
		}
		
		
	}
	
	public void PrintHeap(int[] A)
	{
		for(int i=1; i< A.length; i++)
			System.out.print(A[i]+" ");
		System.out.println();
	}
	
	
}
