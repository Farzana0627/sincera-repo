

public class FeatureRow {

	double[] featuresArray;
	String speciesName;
	double distance = 0.0;
	public FeatureRow(double[] features, String species) {
		// TODO Auto-generated constructor stub
		featuresArray=features;
		/*petal_length= p_l;
		petal_width= p_w;
		sepal_length= s_l;
		sepal_width= s_w;*/
		speciesName= species;
	
	}
	
	
	public void setDistance(double d){
		distance= d;
	}
	
	
}
