package Classes;

import java.util.List;

public class Class9 {
	
	public int flag;
	public void DrawShape(List <I_Shape> shapes )
	{
		if(shapes==null) {
			flag=0;
			return;
		}
		flag=0;
		BuildShape();
						
		for (I_Shape shape : shapes)
		{
							
			shape.DrawShape();
				
		}
			
	}
	
	public void BuildShape(){
		
	}

}
