import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KNNClass {
	public static String[] Features={}; 
	public static List<FeatureRow> listOfRows= new ArrayList<>();
	public static List<FeatureRow> listOfTestRows= new ArrayList<>();
	public static List<Double> distances;
	public static int numberOfFeatures=0;
	public static final int k=9;
	static int corrected=0;
	static FeatureRow row;
	public static Set<String> classes= new HashSet<>();
	public static void main(String[] args) throws IOException {
		 String trainFile = "train.txt";
		 String testFile = "test.txt";
		 
		 
		
		 FileReader fileReader =  new FileReader(trainFile);
		 FileReader testfileReader =  new FileReader(testFile);
	     BufferedReader bufferedReader= new BufferedReader(fileReader);
	     BufferedReader testbufferedReader= new BufferedReader(testfileReader);
	     String line= bufferedReader.readLine();
		 String testline=null;
	     
	 /*    String[] parts=line.split("\\s+");
	     int numberOfFeatures=parts.length-1;
	     for (int i=0; i<numberOfFeatures; i++){
	    	 Features[i]=parts[i];
	    	 i++;
	     }*/
	     String[] parts=line.split("\\s+");
	     numberOfFeatures=parts.length-1;
	     
	     double[] featureValues= new double[numberOfFeatures];
	    
	     
	     int i=0;
	     while ((line = bufferedReader.readLine()) != null)
		 {	 
	    	 int j;
	    	 parts= line.split("\\s+");	    	
	 		 for (j=0; j<numberOfFeatures; j++) {
	 			featureValues[j] = Double.parseDouble(parts[j]);	
	 		 } 
	 		 row= new FeatureRow(featureValues, parts[j]);
	 		 listOfRows.add(row);
	 		 classes.add(parts[j]);	
	 		 //System.out.println(listOfRows.get(i).featuresArray[0]+" "+listOfRows.get(i).featuresArray[1]+" "+listOfRows.get(i).featuresArray[2]+" "+listOfRows.get(i).featuresArray[3]);
	 
	 		 i++;
		}
	     
	     for(int n=0; n<listOfRows.size(); n++){
			 System.out.println(listOfRows.get(n).featuresArray[0]+" "+listOfRows.get(n).featuresArray[1]+" "+listOfRows.get(n).featuresArray[2]+" "+listOfRows.get(n).featuresArray[3]);
		}
	    int n=0;
	    String[] testparts=new String[numberOfFeatures+1];
	    double[] testfeatureValues= new double[numberOfFeatures];
	    while ((testline = testbufferedReader.readLine()) != null)
	  	{	 
	  	    int j;
	  	    	 
	  	    testparts= testline.split("\\s+");
	  	 	for (j=0; j<numberOfFeatures; j++) {
	  
	  	 		testfeatureValues[j]= Double.parseDouble(testparts[j]);
	  	 	}
	  	 	row= new FeatureRow(testfeatureValues,testparts[j]);
	  	 	listOfTestRows.add(row);
	  	// 	System.out.println(listOfTestRows.get(n).featuresArray[0]+" "+listOfTestRows.get(n).featuresArray[1]+" "+listOfTestRows.get(n).featuresArray[2]+" "+listOfTestRows.get(n).featuresArray[3]+" "+listOfTestRows.get(n).speciesName);
	  	 	
	  		n++;
	  	}
	     
 	
	     getTestResults();
	     checkAccuracy();
	     
	     bufferedReader.close();
	     testbufferedReader.close();
	     
	}
	
	private static void checkAccuracy() {
		// TODO Auto-generated method stub
		System.out.println(""+corrected*100/listOfTestRows.size());
		
	}

	public static void readfeatures(){
		
	}
	
	public static void getTestResults(){
		double distance= 0.0;
		double feature1=0.0;
		double feature2=0.0;
		double feature3=0.0;
		double feature4=0.0;
		String result=null;
		
		
		for (int i=0; i<listOfTestRows.size(); i++){
			
			int j=0;
			for(j=0; j<listOfRows.size(); j++ ){
				
				feature1=(listOfTestRows.get(i).featuresArray[0]-listOfRows.get(j).featuresArray[0]);
			//	System.out.println(listOfTestRows.get(i).featuresArray[0]+" "+listOfRows.get(j).featuresArray[0]+" "+feature1);
				feature2=(listOfTestRows.get(i).featuresArray[1]-listOfRows.get(j).featuresArray[1]);
				feature3=(listOfTestRows.get(i).featuresArray[2]-listOfRows.get(j).featuresArray[2]);
				feature4=(listOfTestRows.get(i).featuresArray[3]-listOfRows.get(j).featuresArray[3]);
			//	System.out.println(feature1+" "+feature2+" "+feature3+" "+feature4);
				distance= Math.sqrt(feature1*feature1+ feature2*feature2+ feature3* feature3+ feature4* feature4);
			//	System.out.println(distance);
				listOfRows.get(j).setDistance(distance);
			}
			//System.out.println(j);
			Collections.sort(listOfRows, new MyComparator());
		//	System.out.println(listOfRows.get(0).distance);
		//	System.out.println(listOfRows.get(1).distance);
		//	System.out.println(listOfRows.get(2).distance);
			result= findMajority();
			if(listOfTestRows.get(i).speciesName==result)
				corrected+=1;
			
			System.out.println(result);
			
		}
	}
	
	
	public static String findMajority(){
		Map<String, Integer> map= new HashMap<>();
		Iterator<String> it = classes.iterator();
		while(it.hasNext()){
			
			map.put(it.next(), 0);
		}
		for (int i=0; i<k; i++){
			map.put(listOfRows.get(i).speciesName, map.get(listOfRows.get(i).speciesName)+1);
		}
		List<Integer> valuelist = new ArrayList<Integer>(map.values());
		Collections.sort(valuelist);
			String key=null;
	        Integer value=valuelist.get(0);
	        for(Map.Entry<String, Integer> entry: map.entrySet()){
	            if(value.equals(entry.getValue())){
	                key = (String) entry.getKey();
	                break;
	            }
	        }
	        
	        return key;
	}

}
