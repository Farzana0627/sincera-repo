package DFS;

import java.util.ArrayList;

public class DfsProcessor {
	
	private  ArrayList<ArrayList<Integer>> arrayOfNodes=new ArrayList<ArrayList<Integer>>();
	private String [] color;
	private Integer [] Previous;
	private Integer [] Discover ;
	private Integer [] Finish ;
	private int Time;
 	
	public DfsProcessor(ArrayList<ArrayList<Integer>> graph)
	{
		arrayOfNodes=graph;
		color =new String[arrayOfNodes.size()];
		Previous=new Integer[arrayOfNodes.size()];
		Discover = new Integer[arrayOfNodes.size()];
		Finish =new Integer[arrayOfNodes.size()];
		
	}
	public void dfsMethod()
	{
	
		for(int i=0;i<arrayOfNodes.size();i++)
		{
			color[i]="white";
			Previous[i]=null;
			Discover[i]=10000;
			Finish[i]=1000000;
		}
		
		Previous[0]=0;
		Time=0;
		
		for(int i=0;i<arrayOfNodes.size();i++)
		{
			if(color[i]=="white")
				DFS_Visit(i);
		}
		
		
	}
	private void DFS_Visit(int i) {
		
		color[i]="gray";
		Time+=1;
		Discover[i]=Time;
		
		for(int j=0;j<arrayOfNodes.size();j++)
		{
			if(arrayOfNodes.get(i).get(j)==1 && color[j]=="white")
			{
				Previous[j]=i;
				DFS_Visit(j);
			}
			
		}
		color[i]="black";
		Time+=1;
		Finish[i]=Time;
		
	}
	
	
	public void find_path( int source,int destination)
	{
		if(source==destination)
		{
			System.out.printf(" %d ", source);
			return;		
		}
		
		
		find_path(source, Previous[destination]);
		System.out.printf("-> %d ", destination);
		
		
		
	}

}
