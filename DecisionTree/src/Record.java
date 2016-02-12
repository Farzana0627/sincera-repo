import java.util.ArrayList;


public class Record {
	private ArrayList<DiscreteAttribute> attributes= new ArrayList<>();
	public ArrayList<DiscreteAttribute> getAttributes() {
	
		return attributes;
	}
	public void print()
	{
		System.out.println("muna2");
		for(int i=0; i< this.attributes.size(); i++)
			System.out.println(this.attributes.get(i).getName());
	}
	public void setAttributes(ArrayList<DiscreteAttribute> attributes) {
		this.attributes = attributes;
	}
	
	public void setAttribute(DiscreteAttribute d){
		this.attributes.add(d);
	}
}
