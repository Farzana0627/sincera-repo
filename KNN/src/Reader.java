import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reader {
	FileReader trainreader;
	
	BufferedReader trainbufferedReader;
	BufferedReader testbufferedReader;
	FileReader testreader;
	List<FeatureRow> listOfRows= new ArrayList<>();
	List<FeatureRow> listOfTestRows= new ArrayList<>();
	FeatureRow row;
	Set<String> classes= new HashSet<>();
	int numberOfFeatures;
	public Reader(File trainFile, File testFile) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		trainreader= new FileReader(trainFile);
		trainbufferedReader= new BufferedReader(trainreader);
		
		testreader= new FileReader(testFile);
		testbufferedReader= new BufferedReader(testreader);
	}
	
	
	public void readTrainFile() throws IOException {
	
		// TODO Auto-generated method stub
		String line= trainbufferedReader.readLine();	
		String[] parts=line.split("\\s+");
		numberOfFeatures=parts.length-1;
		double[] featureValues;
	    
 		
	     int i=0;
	     while ((line = trainbufferedReader.readLine()) != null)
		 {	 
	    	 featureValues= new double[numberOfFeatures];
	    	 int j;
	    	 parts= line.split("\\s+");	    	
	 		 for (j=0; j<numberOfFeatures; j++) {
	 			featureValues[j] = Double.parseDouble(parts[j]);	
	 		 } 
	 		 row= new FeatureRow(featureValues, parts[j]);
	 		 listOfRows.add(row);
	 		 classes.add(parts[j]);	
	 		 i++;
		}
	   }
	
	public void readTestFile() throws IOException {
		// TODO Auto-generated method stub
		String testline=null;
		 int n=0;
		    String[] testparts=new String[numberOfFeatures+1];
		    double[] testfeatureValues;
		    while ((testline = testbufferedReader.readLine()) != null)
		  	{	 
		  	    int j;
		  	   
		  	   testfeatureValues= new double[numberOfFeatures];
		  	   testparts= testline.split("\\s+");
		  	 	for (j=0; j<numberOfFeatures; j++) {
		  
		  	 		testfeatureValues[j]= Double.parseDouble(testparts[j]);
		  	 	}
		  	 	row= new FeatureRow(testfeatureValues,testparts[j]);
		  	 	listOfTestRows.add(row);
		  	//	System.out.println(listOfTestRows.get(n).featuresArray[0]+" "+listOfTestRows.get(n).featuresArray[1]+" "+listOfTestRows.get(n).featuresArray[2]+" "+listOfTestRows.get(n).featuresArray[3]+" "+listOfTestRows.get(n).speciesName);
		  	 	
		  		n++;
		  	}
		
	}
}
