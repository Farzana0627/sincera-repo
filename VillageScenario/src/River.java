
public class River extends Shape {
int x1,y1,x2,y2,x3,y3,x4,y4;
	
	public River() {
		
		DrawShape();
	}
	
	public River(int x1, int y1, int x2, int y2,int x3, int y3, int x4, int y4) 
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.x4 = x4;
		this.y4 = y4;
		
		DrawShape();
	}

	@Override
	public void BuildShape() {
		//list.add(new RiverBank(x1, y1, x2, y2));
		//list.add(new RiverBank(x3, y3, x4, y4));
		shapes.add(new Line(0, 500, 300, 200));
		shapes.add(new Line(300, 200, 300, 250));
		shapes.add(new Line(300, 250, 550, 0));
		
		shapes.add(new Line(100, 600, 350, 300));
		shapes.add(new Line(350, 300, 350, 350));
		shapes.add(new Line(350, 350, 650, 0));
		
	}/*private RiverBank r1;
	private RiverBank r2;
	private int x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6,x7,y7,x8,y8;
	public River(int x1,int y1,int x2, int y2,int x3,int y3,int x4,int y4,int x5,int y5,int x6, int y6,int x7,int y7,int x8,int y8 )
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.x3=x3;
		this.y3=y3;
		this.x4=x4;
		this.y4=y4;
		this.x5=x5;
		this.x5=x5;
		this.y6=y6;
		this.y6=y6;
		this.x7=x7;
		this.y7=y7;
		this.x8=x8;
		this.y8=y8;
	
	}
	
	public void BuildShape()
	{
		r1= new RiverBank(x1, y1, x2, y2, x3, y3, x4, y4);
		r2= new RiverBank(x5, y5, x6, y6, x7, y7, x8, y8);
		shapes.add(r1);
		shapes.add(r2);
	}
	*/
	
}
