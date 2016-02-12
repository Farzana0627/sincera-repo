
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Attribute {
	private String name;
	private int AttributeIndex;
	private ArrayList <DiscreteAttribute> discreteAttributes= new ArrayList<>();
	private Map<String, Integer> map= new HashMap<>();
	
	public Attribute( int AttributeIndex) {
		this.AttributeIndex = AttributeIndex;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setDiscreteAttributes(ArrayList <DiscreteAttribute> d) {
		this.discreteAttributes = d;
	}

	public ArrayList<DiscreteAttribute> getDiscreteAttributes() {
		return this.discreteAttributes;
	}
	
	public Map<String, Integer> getMap()
	{
		return this.map;
	}
	
	public void setMap(String name, Integer value)
	{
		this.map.put(name, value);
	}
	
}
