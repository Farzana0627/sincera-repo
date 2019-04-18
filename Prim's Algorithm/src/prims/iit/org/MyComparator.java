package prims.iit.org;

import java.util.Comparator;

public class MyComparator  implements Comparator<Node>{
	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if(o1.Key<o2.Key) return -1;
		else if(o1.Key>o2.Key) return 1;
		return 0;
	}

}
