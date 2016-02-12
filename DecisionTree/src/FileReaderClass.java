import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;


public class FileReaderClass {
	public static String PATH_TO_DATA_FILE = "data.txt";
	
	public static int numberOfAttributes=0;
	public static int numberOfRecords=0;
	public static int decisionValues=0;
	public static ArrayList<Attribute> Attributes=new ArrayList<>();
	
	private ArrayList<Record> testRecords= new ArrayList<>();
	
	public ArrayList<Record> buildRecords() {
	
		
		ArrayList<Record> records = new ArrayList<Record>();
		//BufferedReader reader = null;
		DataInputStream dis = null;
		
		try { 
		
	           File f = new File(PATH_TO_DATA_FILE);
	           Scanner reader = new Scanner(f);
	
	    	   numberOfAttributes= Integer.parseInt(reader.nextLine());
	    	   numberOfRecords= Integer.parseInt(reader.nextLine());
	          
	           String line;
	          
	           for(int k=0; k<numberOfRecords; k++){
	        	
	        	   Record r = new Record();
	        	   line = reader.nextLine();
		              StringTokenizer st = new StringTokenizer(line, ",");          
		              for(int i=0; i<numberOfAttributes; i++)
		              { 	 
		            	 
		            	  if(k==0) {
		            		
		            		  Attributes.add(new Attribute(i));
		            	  }
		            	  String s;
		            	  s=st.nextToken();
		            
		            	  if(!Attributes.get(i).getMap().keySet().contains(s))
		            		  Attributes.get(i).setMap(s, Attributes.get(i).getMap().keySet().size() );		      	            	 	            	
		            	 
		            	  
		            	  int value=Attributes.get(i).getMap().get(s);
		            	     
		            	     DiscreteAttribute d=new DiscreteAttribute(s, value);
			            	 r.setAttribute(d);
	 
			           }
		         
		              records.add(r);
		            	  
		             }
		          
		      
		             
	           
		              for(int j=0; j<5; j++)
		              {
		            
		            	  Record r = new Record();
			        	   line = reader.nextLine();
				              StringTokenizer st = new StringTokenizer(line, ",");			       
				           	
				              for(int i=0; i<numberOfAttributes-1; i++)
				              { 	 
				            	   
				            	  String s;
				            	  s=st.nextToken();
				            	       	 	             
				            	  int value=Attributes.get(i).getMap().get(s);
				            	
				            	     DiscreteAttribute d=new DiscreteAttribute(s, value);
					            	 r.setAttribute(d);
			 
					           }
				            	     
				            		
				        
				        	     
				        	 
		      	              testRecords.add(r);
		              }
		            decisionValues=  Attributes.get(numberOfAttributes-1).getMap().keySet().size() ;
		            System.out.println(decisionValues);
		             
	           
	     }
		
	       
		
		 catch (IOException e) { 
	           System.out.println("Uh oh, got an IOException error: " + e.getMessage()); 
	        } 
		   catch (Exception e) {
	            System.out.println("Uh oh, got an Exception error: " + e.getMessage()); 
	        }
	        finally { 
	           if (dis != null) {
	              try {
	                 dis.close();
	              } catch (IOException ioe) {
	                 System.out.println("IOException error trying to close the file: " + ioe.getMessage()); 
	              }
	           }
	        }
		
		return records;
	}
	

	public ArrayList<Attribute> getAttributes()
	{
		return this.Attributes;
	}
	
	public ArrayList<Record> getTestRecords()
	{
		return this.testRecords;
	}
		
}
