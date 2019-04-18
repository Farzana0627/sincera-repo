package prims.iit.org;
/*
6
a b c d e f
0 4 0 0 0 2
4 0 6 0 0 3
0 6 0 3 0 1
0 0 3 0 2 0
0 0 0 2 0 4
2 3 1 0 4 0

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class Graph{
	List<Node> Vertices=new ArrayList<>();
	//Map<String, Integer> EdgeMap= new HashMap<>();
	List<Edge> Edges= new ArrayList<Edge>();
	int noOfVertices=0;
	int indexOfRoot=0;
	
	public Graph() throws IOException{
		// TODO Auto-generated constructor stub
		
		 String fileName = "/home/muna/Desktop/bfs.txt";
		 String line= null;
		 FileReader fileReader =  new FileReader(fileName);
	     BufferedReader bufferedReader= new BufferedReader(fileReader);
	     line=bufferedReader.readLine();
	     int n= Integer.parseInt(line);
	     line=bufferedReader.readLine();
	     for (String part : line.split("\\s+")) {
	 			Node newNode=new Node(part);
				Vertices.add(newNode);
	 	    }
	     
	 	 for(int i=0; i<n; i++)
		 {		
	 		line=bufferedReader.readLine();
	 		int j=0;
	 		for (String part : line.split("\\s+")) {
	 			int w = Integer.parseInt(part);
	 			if(w!=0 && i!=j)
				{
					Vertices.get(i).Neighbours.add(Vertices.get(j));
					Edge edge=new Edge(Vertices.get(i), Vertices.get(j));
					//EdgeMap.put(Vertices.get(i).Name+Vertices.get(j).Name, w);
					edge.setEdgeWeight(w);
					Edges.add(edge);
				}
	 			j++;
	 	    }
	 		
		 }
	 	
		
		
	 	bufferedReader.close();
	 	Random r= new Random();
	 	int rootIndex= r.nextInt(Vertices.size()-1);
	
		Vertices.get(rootIndex).Key=0;
			
		
	}
	
	
}
