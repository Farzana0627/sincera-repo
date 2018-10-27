package prims.iit.org;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prims extends Graph {
	public Prims() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public void MST() throws IOException
	{

		Map<Edge, Integer> Visited= new HashMap<>();
		
		Queue<Node> QueueOfVertices= new PriorityQueue<Node>(Vertices.size(), new MyComparator());
		QueueOfVertices.addAll(Vertices);
		
		while(!QueueOfVertices.isEmpty())
		{
			Node node=QueueOfVertices.element();
			
			QueueOfVertices.remove(node);
			if(node.Parent!=null){
				Edge e= new Edge(node.Parent,node);
				Visited.put(e, FindEdgeWeight(e));
			}
			Node child=null;
			for(int i=0; i< node.Neighbours.size(); i++)
			{
				child=node.Neighbours.get(i);
				//int weight= EdgeMap.get(node.Name+child.Name);
				Edge tempEdge= new Edge (node, child);
				int weight= FindEdgeWeight(tempEdge);
				if(QueueOfVertices.contains(child) &&  weight <child.Key)
				{
					QueueOfVertices.remove(child);
					child.Parent= node;
					child.Key=weight;
					QueueOfVertices.add(child);
					
				}
			}
		}
	
	
	int cost=0;
	System.out.println("\tPrims");
	for(Map.Entry<Edge, Integer> m: Visited.entrySet())
	{
		System.out.println(m.getKey().node1.Name+","+m.getKey().node2.Name+" "+m.getValue());
		cost+=m.getValue();
	}
	
	System.out.println("Total Cost "+cost);
	
	}	
	public int FindEdgeWeight(Edge e)
	{
		for(int i=0; i< Edges.size(); i++)
			if(Edges.get(i).node1==e.node1 && Edges.get(i).node2==e.node2)
				return Edges.get(i).weight;
		return 0;
	}
}