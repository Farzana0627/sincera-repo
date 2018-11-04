
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DfsClass {
	
	public static void main(String[] args) 
	{
		 ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
		
		try
		{
			BufferedReader file= new BufferedReader(new FileReader("dfs.txt"));
			
			while(true)
			{
				String currentLine = file.readLine();
				
				if(currentLine==null)
					break;
				
				String[] tokens = currentLine.split(",");
				
				ArrayList<Integer> temp=new ArrayList<Integer>();
				
				for(int counter=0; counter<tokens.length; counter++)
				{
					Integer dataToBeInserted = Integer.parseInt(tokens[counter]);
					
					temp.add(dataToBeInserted);
				}

				graph.add(temp);
				
			}
			file.close();
			
		}
		catch(IOException exception)
		{
			System.out.println("File does not found");
			exception.printStackTrace();
		}
		
		DfsProcessor dfs=new DfsProcessor(graph);
		dfs.dfsMethod();
		dfs.find_path(0, 1);
		System.out.println();
		dfs.time();
	}

}
