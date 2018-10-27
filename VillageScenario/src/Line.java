import javax.swing.JFrame;

public class Line implements I_Shape{
	private int x1,y1,x2,y2;
	public Line(int x1, int y1, int x2, int y2)
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		
	
	} 

	public void DrawShape()
	{
		//System.out.println(x1+" "+ y1+" "+ x2+" "+ y2);
		Main.G.drawLine(x1, y1, x2, y2);
		
	}

	
	/*	
		public void DrawShape()
	{
		repaint();
		
	}
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawLine(x1, y1, x2, y2);
		
		
	}*/
	

	
}
