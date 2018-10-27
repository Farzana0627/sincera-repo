package Classes;

import java.util.ArrayList;
import java.util.List;

public class Class7 {
	//String[] c={"Red","Green","Blue","Yellow"};
	public List<String> colorBank;
	public void main(String[] colors) {	
		if(colors==null){
			return;
		}
		colorBank=new ArrayList<>();
		for(String s: colors)
			colorBank.add(s);
		System.out.println(colorBank);
	}

}
