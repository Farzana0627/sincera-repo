package prims.iit.org;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge o1, Edge o2) {
		// TODO Auto-generated method stub
		
		return o1.weight- o2.weight;
	}

}
