import java.util.Comparator;


public class MyComparator implements Comparator<FeatureRow>{
	
	
	@Override
	public int compare(FeatureRow o1, FeatureRow o2) {
		// TODO Auto-generated method stub	
		if(o1.distance<o2.distance)
			return -1;
		if(o1.distance>o2.distance)
			return 1;
		return (int)(o1.distance-o2.distance);
	}
}
