import java.util.ArrayList;

public class BestFirst {
	
	private  ArrayList<ArrayList<Integer>> ArrayOfNodes = new ArrayList<ArrayList<Integer>>();
	private  ArrayList<Integer> Heuristics = new ArrayList<Integer>();
	private Integer [] color;
	private ArrayList<Integer>Path=new ArrayList<Integer>();
	
	public BestFirst(ArrayList<ArrayList<Integer>> nodes,ArrayList<Integer> heuristics)
	{
		ArrayOfNodes=nodes;
		Heuristics=heuristics;
		//System.out.println(heuristics.size());
		color= new Integer[Heuristics.size()]; 
		
		
	}
	
	public void best_first_search(int src,int destination)
	{
		
		for(int i=0;i<Heuristics.size();i++)
		{
			color[i]=0;
		}
		
		Path.add(src);
		System.out.printf(" %d ",src);
		find_dest(src,destination);
		
		
	}

	private void find_dest(int source, int destination) {
	
		if(source==destination)return ;
		
		color[source]=1;
		int dest=10000000;
		int src=source;
			
		
		for(int i=0;i<Heuristics.size();i++)
		{
		
			if(ArrayOfNodes.get(src).get(i)==1 && color[i]==0)
			{
				if(Heuristics.get(i)<dest)
				{
					dest=Heuristics.get(i);
					source=i;
					
				}
			}
		}
		System.out.printf(" -> %d ",source);
		Path.add(source);
		find_dest(source, destination);
		
	}
	
}
