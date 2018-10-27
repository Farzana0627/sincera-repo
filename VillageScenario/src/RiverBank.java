public class RiverBank extends Shape {
	int x1,y1,x2,y2;
	
	public RiverBank(int x1, int y1, int x2, int y2) 
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		DrawShape();
	}
	
	@Override
	public void BuildShape()
	{
		shapes.add(new Line(x1, y1, (x2-x1)/3+100, (y1-y2)/3+100));
		shapes.add(new Line((x2-x1)/3+100, (y1-y2)/3+100,(x2-x1)/3+100,(y1-y2)/3+150));
		shapes.add(new Line( (x2-x1)/3+100,(y1-y2)/3+150,x2,y2));
		
	}/*private line l1,l2,l3;
	
	private int x1,y1,x2,y2,x3,y3,x4,y4;
	public RiverBank(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4 )
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.x3=x3;
		this.y3=y3;
		this.x4=x4;
		this.y4=y4;
	}
	
	public void BuildShape()
	{
		l1= new line(x1,y1,x2,y2);
		l2= new line(x2,y2,x3,y3);
		l3= new line(x3,y3,x4,y4);
		shapes.add(l1);
		shapes.add(l2);
		shapes.add(l3);
		
	}*/
	
}
