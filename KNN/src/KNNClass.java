
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class KNNClass {
	List<FeatureRow> listOfRows= new ArrayList<>();
	List<FeatureRow> listOfTestRows= new ArrayList<>();
	int numberOfFeatures=0;
	final int k=45;
	int corrected=0;
	Reader reader;
	Set<String> classes= new HashSet<>();
	public KNNClass(Reader r){
		reader=r;
		listOfRows= r.listOfRows;
		listOfTestRows= r.listOfTestRows;
		numberOfFeatures= r.numberOfFeatures;
		classes=r.classes;
	     
	}
	
	public void checkAccuracy() {
		// TODO Auto-generated method stub
		System.out.println("KNN Algorithm; K="+k);
		System.out.println("Total number of test data: "+ listOfTestRows.size());
		System.out.println("Correct predictions: "+corrected);
		System.out.println("Accuracy: "+corrected*100/listOfTestRows.size()+"%");
		
	}


	
	public void getTestResults(){
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
				feature2=(listOfTestRows.get(i).featuresArray[1]-listOfRows.get(j).featuresArray[1]);
				feature3=(listOfTestRows.get(i).featuresArray[2]-listOfRows.get(j).featuresArray[2]);
				feature4=(listOfTestRows.get(i).featuresArray[3]-listOfRows.get(j).featuresArray[3]);
				distance= Math.sqrt(feature1*feature1+ feature2*feature2+ feature3* feature3+ feature4* feature4);
				listOfRows.get(j).setDistance(distance);
			}
			Collections.sort(listOfRows, new MyComparator());
			result= findMajority();
			if(listOfTestRows.get(i).speciesName.equals(result))
				corrected+=1;
		}
	}
	
	
	public String findMajority(){
		String[] species= new String[classes.size()];
		Iterator<String> it = classes.iterator();
		int index=0;
		while(it.hasNext()){
			species[index]=it.next();
			index++;
		}
		int[][] frequency= new int[3][1];
		int max=0, maxSpeciesIndex=0; 
		for(int n=0; n<species.length; n++){
			frequency[n][0]=0;
			for (int i=0; i<k; i++){
				if(listOfRows.get(i).speciesName.equals(species[n])){
					frequency[n][0]+=1;
				}
			}
			if(max<frequency[n][0]){
				max=frequency[n][0];
				maxSpeciesIndex=n;

			}
			
		}
		
		return species[maxSpeciesIndex];
		}

}
