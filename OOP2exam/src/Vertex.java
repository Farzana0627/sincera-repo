

/*
  * Arguments
5
  a b c d e 
a 0 1 0 0 0  
b 0 0 1 0 0 
c 0 0 0 1 0 
d 0 0 0 0 1 
e 1 0 0 0 0 
*/
public class Vertex {
		int Name;
		
		boolean flag=false;
		
		 public Vertex (int name)
		 {
			// TODO Auto-generated constructor stub
			Name=name;
			
			flag=true;	
		
		 } 
		
	}

























/*package Assignment.one;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	int vertexName;
	List <Vertex> neighbours;
	boolean flag=false;
	
	 public Vertex (int name)
	 {
		// TODO Auto-generated constructor stub
		vertexName=name;
		neighbours= new ArrayList<> ();
		flag=true;	
	 } 
	
	//Returns true if edge is there between two vertices
	boolean hasEdge (Vertex v1,Vertex v2 )
	{
		return true;
	}
	
	//Remove edge between two vertices
	public void removeEdge(Vertex v1, Vertex v2) {
		if(v1.neighbours.contains(v2)){
			v1.neighbours.remove(v2);
			v2.neighbours.remove(v1);
		}

	}
	
	//Returns appended strings of vertices' and their neighbour's names
	public String toString()
	{
		StringBuilder sb= new StringBuilder();
		sb.append(vertexName+"       ");
		for(int i=0; i< neighbours.size(); i++)
			sb.append(" "+neighbours.get(i).vertexName);
		return sb.toString();
	}
	
}*/