
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DGraph {
	public static void main(String[] args)throws IOException {
		
		List <Vertex> vertices= new ArrayList<>();
		Map<Integer, Integer>  neighbours= new HashMap<Integer, Integer> ();
		int argCounter=0;
		int noOfVertex=Integer.parseInt(args[argCounter]);
		System.out.println("No. of Vertices: "+noOfVertex);
		argCounter++;
		for(int i=0; i<noOfVertex; i++)
		{
			Vertex v=new Vertex(i);
			vertices.add(v);
		}
	
		for(int i=0; i<noOfVertex; i++)
		{	
			for( int j=0; j<noOfVertex; j++)
			{	
				int temp=Integer.parseInt(args[argCounter]);
				
				if(temp==1)
				{	
					neighbours.put(vertices.get(i).Name, vertices.get(j).Name);
				}
				
				argCounter++;
			}			
		
		}
		findVerticesOnPath(neighbours);
		
	}

		public static < T > void findVerticesOnPath( Map <T,T> names)
		{
			
			for(Map.Entry<T, T> m: names.entrySet())
			{
				System.out.println(m.getKey()+" "+ m.getValue());
			}
		}
		
	
}