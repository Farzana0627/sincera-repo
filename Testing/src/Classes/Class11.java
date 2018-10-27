package Classes;

import java.util.Iterator;
import java.util.List;

public class Class11 {
	public int flag=0;
	public List<String> List1;
	public List<String> List2;
	public void removeColor(List<String> L1,List<String> L2 )
	{	
		if(L1==null ||L2==null || L1.isEmpty() || L2.isEmpty()) {
			flag=1;
			return;
		}
		List1= L1;
		List2= L2;
		Iterator <String>  it= L1.iterator();
		while(it.hasNext())
		{
			if(L2.contains(it.next()))
				it.remove();	
			}
	}
}
