package prims.iit.org;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kruskal extends Graph{
	List< Set<Node> > set=new ArrayList<>();
	public Kruskal() throws IOException {
		super();
		
		// TODO Auto-generated constructor stub
	}
	
	private void MakeSet(List< Set<Node> > set)
	{
		
		for(int i=0; i< Vertices.size(); i++)
		{	
			Set <Node> s= new HashSet<>();
			s.add(Vertices.get(i));
			set.add(s);
		}
	}
	private Set<Node> Find(Node n)
	{
		for(int i=0; i< set.size(); i++)
			if(set.get(i).contains(n))
				return set.get(i); 
		return null;
		//if(set.contains(n))
	}
	private void Union(Set<Node> s1, Set<Node> s2)
	{
		s1.addAll(s2);
		set.remove(s2);
			
	}
	public void MST()
	{
		
		Collections.sort(Edges,new EdgeComparator());
		List<Edge> KruskalEdges= new ArrayList<>();
		MakeSet(set);
		
		for(int i=0; i< Edges.size(); i++)
		{
			if((Find(Edges.get(i).node1))!=(Find(Edges.get(i).node2)))
			{  
				KruskalEdges.add(Edges.get(i));
				Union(Find(Edges.get(i).node1),Find(Edges.get(i).node2));
			}
		}
		String name1,name2;
		int weight,Cost=0;
		System.out.println("\tKRUSKAL");
		for(int i=0; i<KruskalEdges.size(); i++){
			name1=KruskalEdges.get(i).node1.Name;
			name2=KruskalEdges.get(i).node2.Name;
			weight=KruskalEdges.get(i).weight;
			System.out.println(name1+","+name2+" "+weight );
			Cost+=weight;

		}
		System.out.println("Total Cost: "+Cost);
	}
	
	
}
