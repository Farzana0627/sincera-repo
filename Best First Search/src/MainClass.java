import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class MainClass {
	
	public static void main(String[] args) 
	{
		 ArrayList<ArrayList<Integer>> nodes=new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> heuristics = new ArrayList<Integer>(); 
		
		try
		{
			BufferedReader file= new BufferedReader(new FileReader("input.txt"));
			BufferedReader file1= new BufferedReader(new FileReader("inputHeuristic.txt"));
			
			while(true)
			{
				String currentLine = file.readLine();
				String currentLine1 = file1.readLine();
				
				if(currentLine==null)
					break;
				
				String[] tokens = currentLine.split(",");
				//System.out.println(currentLine);
				
				ArrayList<Integer> temp=new ArrayList<Integer>();
				
				for(int counter=0; counter<tokens.length; counter++)
				{
					Integer value = Integer.parseInt(tokens[counter]);
					
					temp.add(value);
				}
				
				//System.out.println(temp);
				nodes.add(temp);
				heuristics.add(Integer.parseInt(currentLine1));
				
			}
			file.close();
			file1.close();
			
		}
		catch(IOException exception)
		{
			System.out.println("File does not found");
			exception.printStackTrace();
		}
		//System.out.println(heuristics);
		
		BestFirst best=new BestFirst(nodes,heuristics);
		best.best_first_search(0,4);
		
	}


}
