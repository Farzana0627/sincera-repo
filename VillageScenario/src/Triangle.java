
public class Triangle extends Shape{
	
	
	private int x1,y1,x2,y2,x3,y3;
	private Line l1,l2,l3;
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3 )
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.x3=x3;
		this.y3=y3;
		DrawShape();
	}
	
	public void BuildShape()
	{
		l1= new Line (x1,y1,x2,y2);
		l2= new Line (x2,y2,x3,y3);
		l3= new Line (x3,y3,x1,y1);
		shapes.add(l1);
		shapes.add(l2);
		shapes.add(l3);
	}
	
}
