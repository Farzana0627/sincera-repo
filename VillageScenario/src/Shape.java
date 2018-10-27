import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public abstract class Shape extends JPanel implements I_Shape {
	List <I_Shape> shapes= new ArrayList<>();
	
	public abstract void BuildShape();
	
	public void DrawShape()
	{
		
		BuildShape();
					
		for (I_Shape shape : shapes)
		{
						
			shape.DrawShape();
			
		}
		
	}
	
}
